/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool 
          with fuzzy matching, translation memory, keyword search, 
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2007 Zoltan Bartko, Alex Buloichik
               2009 Didier Briel
               2015 Aaron Madlon-Kay
               Home page: http://www.omegat.org/               
               Support center: http://groups.yahoo.com/group/OmegaT/

 This file is part of OmegaT.

 OmegaT is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 OmegaT is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **************************************************************************/

package org.omegat.core.spellchecker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.omegat.core.Core;
import org.omegat.core.CoreEvents;
import org.omegat.core.data.SourceTextEntry;
import org.omegat.core.events.IEntryEventListener;
import org.omegat.core.events.IProjectEventListener;
import org.omegat.util.Log;
import org.omegat.util.OConsts;
import org.omegat.util.Preferences;
import org.omegat.util.StaticUtils;

/**
 * Common spell checker interface for use any spellchecker providers.
 * 
 * @author Zoltan Bartko (bartkozoltan at bartkozoltan dot com)
 * @author Alex Buloichik (alex73mail@gmail.com)
 * @author Didier Briel
 * @author Aaron Madlon-Kay
 */
public class SpellChecker implements ISpellChecker {
    /** The spell checking provider. */
    private ISpellCheckerProvider checker;

    /** the list of ignored words */
    private List<String> ignoreList = new ArrayList<String>();

    /** the list of learned (valid) words */
    private List<String> learnedList = new ArrayList<String>();

    /** Cache of correct words. */
    private final Set<String> correctWordsCache = new HashSet<String>();
    /** Cache of incorrect words. */
    private final Set<String> incorrectWordsCache = new HashSet<String>();

    /**
     * the file name with the ignored words
     */
    private String ignoreFileName;

    /**
     * the file name with the learned words
     */
    private String learnedFileName;

    /** Creates a new instance of SpellChecker */
    public SpellChecker() {
        CoreEvents.registerProjectChangeListener(new IProjectEventListener() {
            public void onProjectChanged(PROJECT_CHANGE_TYPE eventType) {
                switch (eventType) {
                case LOAD:
                case CREATE:
                    initialize();
                    break;
                case CLOSE:
                    destroy();
                    break;
                }
                resetCache();
            }
        });
        CoreEvents.registerEntryEventListener(new IEntryEventListener() {
            public void onNewFile(String activeFileName) {
                resetCache();
            }

            public void onEntryActivated(SourceTextEntry newEntry) {
            }
        });
    }

    /**
     * Initialize the library for the given project. Loads the lists of ignored
     * and learned words for the project
     */
    public void initialize() {
        // initialize the spell checker - get the data from the preferences
        String language = Core.getProject().getProjectProperties().getTargetLanguage().getLocaleCode();

        String dictionaryDir = Preferences.getPreferenceDefault(
                Preferences.SPELLCHECKER_DICTIONARY_DIRECTORY,
                new File(StaticUtils.getConfigDir(), OConsts.SPELLING_DICT_DIR).getPath());

        installBundledDictionary(dictionaryDir, language);
        
        File affixName = new File(dictionaryDir, language + OConsts.SC_AFFIX_EXTENSION);
        File dictionaryName = new File(dictionaryDir, language + OConsts.SC_DICTIONARY_EXTENSION);

        // find out the internal project directory
        String projectDir = Core.getProject().getProjectProperties().getProjectInternal();

        // load the ignore list
        ignoreFileName = projectDir + OConsts.IGNORED_WORD_LIST_FILE_NAME;

        // Since we read from disk, we clean the list first
        ignoreList = new ArrayList<String>();
        fillWordList(ignoreFileName, ignoreList);

        // now the correct words
        learnedFileName = projectDir + OConsts.LEARNED_WORD_LIST_FILE_NAME;

        // Since we read from disk, we clean the list first
        learnedList = new ArrayList<String>();
        fillWordList(learnedFileName, learnedList);

        checker = null;
        if (dictionaryName.isFile()) {
            try {
                checker = new SpellCheckerHunspell(language, dictionaryName.getPath(), affixName.getPath());
            } catch (Exception ex) {
                Log.log("Error loading hunspell: " + ex.getMessage());
            } catch (Error err) {
                Log.log("Error loading hunspell: " + err.getMessage());
            }
            if (checker == null) {
                try {
                    checker = new SpellCheckerJMySpell(language, dictionaryName.getPath(), affixName.getPath());
                } catch (Exception ex) {
                    Log.log("Error loading jmyspell: " + ex.getMessage());
                }
            }
        }
        if (checker == null) {
            checker = new SpellCheckerDummy();
            Log.log("No spell checker loaded");
        }
        for (String w : learnedList) {
            checker.learnWord(w);
        }
    }
    
    /**
     * If there is a Hunspell dictionary for the current target language bundled inside
     * this OmegaT distribution, install it if necessary. 
     */
    private void installBundledDictionary(String dictionaryDir, String language) {
        InputStream bundledDict = getClass().getResourceAsStream(language + ".zip");
        if (bundledDict == null) {
            // Relevant dictionary not present.
            return;
        }
        
        File affix = new File(dictionaryDir, language + OConsts.SC_AFFIX_EXTENSION);
        File dict = new File(dictionaryDir, language + OConsts.SC_DICTIONARY_EXTENSION);
        if (affix.isFile() && dict.isFile()) {
            // Dictionary already installed.
            return;
        }
        
        try {
            StaticUtils.extractFileFromJar(bundledDict, Arrays.asList(affix.getName(), dict.getName()), dictionaryDir);
            bundledDict.close();            
        } catch (IOException e) {
            Log.log(e);
        }
    }

    /**
     * destroy the library
     */
    public void destroy() {
        saveWordLists();
        checker.destroy();
        checker = null;
    }

    protected void resetCache() {
        synchronized (this) {
            incorrectWordsCache.clear();
            correctWordsCache.clear();
        }
    }

    /**
     * Save the word lists to disk
     */
    public void saveWordLists() {
        // Write the ignored and learned words to the disk
        dumpWordList(ignoreList, ignoreFileName);
        dumpWordList(learnedList, learnedFileName);
    }

    /**
     * fill the word list (ignore or learned) with contents from the disk
     */
    private void fillWordList(String filename, List<String> list) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), OConsts.UTF8));

            String thisLine;
            while ((thisLine = br.readLine()) != null) {
                list.add(thisLine);
            }
        } catch (FileNotFoundException ex) {
            // discard this
        } catch (IOException ex) {
            // so now what?
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                // so now what?
            }
        }
    }

    /**
     * dump word list to a file
     */
    private void dumpWordList(List<String> list, String filename) {
        if (filename == null)
            return;
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), OConsts.UTF8));

            for (String text : list) {
                bw.write(text);
                bw.newLine();
            }
        } catch (IOException ex) {
            // so now what?
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Check the word. If it is ignored or learned (valid), returns true.
     * Otherwise false.
     */
    public boolean isCorrect(String word) {
        //check if spellchecker is already initialized. If not, skip checking
        //to prevent nullPointerErrors.
        if (checker==null) 
            return true;

        word = normalize(word);
        
        // check in cache first
        synchronized (this) {
            if (incorrectWordsCache.contains(word)) {
                return false;
            } else if (correctWordsCache.contains(word)) {
                return true;
            }
        }

        boolean isCorrect;

        // if it is valid (learned), it is ok
        if (learnedList.contains(word) || ignoreList.contains(word)) {
            isCorrect = true;
        } else {
            isCorrect = checker.isCorrect(word);
        }

        // remember in cache
        synchronized (this) {
            if (isCorrect) {
                correctWordsCache.add(word);
            } else {
                incorrectWordsCache.add(word);
            }
        }
        return isCorrect;
    }

    /**
     * return a list of strings as suggestions
     */
    public List<String> suggest(String word) {
        if (isCorrect(word)) {
            return Collections.emptyList();
        }

        return checker.suggest(normalize(word));
    }

    /**
     * Add a word to the list of ignored words
     */
    public void ignoreWord(String word) {
        word = normalize(word);
        if (!ignoreList.contains(word)) {
            ignoreList.add(word);
            synchronized (this) {
                incorrectWordsCache.remove(word);
                correctWordsCache.add(word);
            }
        }
    }

    /**
     * Add a word to the list of correct words
     */
    public void learnWord(String word) {
        word = normalize(word);
        if (!learnedList.contains(word)) {
            learnedList.add(word);
            checker.learnWord(word);
            synchronized (this) {
                incorrectWordsCache.remove(word);
                correctWordsCache.add(word);
            }
        }
    }
    
    /**
     * Normalize the orthography of the word by replacing alternative characters
     * with "canonical" ones.
     */
    private static String normalize(String word) {
        // U+2019 RIGHT SINGLE QUOTATION MARK to U+0027 APOSTROPHE
        return word.replace('\u2019', '\'');
    }
}
