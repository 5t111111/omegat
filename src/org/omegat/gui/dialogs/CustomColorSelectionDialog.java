/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool 
          with fuzzy matching, translation memory, keyword search, 
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2014 Briac Pilpre
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

package org.omegat.gui.dialogs;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.AbstractAction;

import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.ListModel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.omegat.util.OStrings;
import org.omegat.util.Preferences;
import org.omegat.util.gui.DockingUI;
import org.omegat.util.gui.StaticUIUtils;
import org.omegat.util.gui.Styles;
import org.omegat.util.gui.Styles.EditorColor;

/**
 * Dialog for configuring custom colors.
 * 
 * @author Briac Pilpre
 * @author Aaron Madlon-Kay
 */
@SuppressWarnings("serial")
public class CustomColorSelectionDialog extends javax.swing.JDialog {

    private final Map<EditorColor, Color> temporaryPreferences = new EnumMap<EditorColor, Color>(EditorColor.class);
    private final ChangeListener colorChangeListener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            recordTemporaryPreference();
        }
    };
    
    
    /**
     * Creates new form CustomColorSelectionDialog
     */
    public CustomColorSelectionDialog(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        getRootPane().setDefaultButton(okButton);
        configureColorChooser();
        StaticUIUtils.setEscapeAction(this, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeDialog();
            }
        });
        colorStylesListValueChanged(null);
        DockingUI.displayCentered(this);
    }

    private void configureColorChooser() {
        try {
            removeTransparencySlider(colorChooser);
        } catch (Exception e) {
            // Ignore
        }
        colorChooser.getSelectionModel().addChangeListener(colorChangeListener);
    }
    
    private void recordTemporaryPreference() {
        EditorColor selectedStyle = (EditorColor) colorStylesList.getSelectedValue();
        if (selectedStyle == null) {
            return;
        }
        temporaryPreferences.put(selectedStyle, colorChooser.getColor());
    }

    private void setColorChooserWithoutNotifying(Color color) {
        colorChooser.getSelectionModel().removeChangeListener(colorChangeListener);
        colorChooser.setColor(color == null ? Color.BLACK : color);
        colorChooser.getSelectionModel().addChangeListener(colorChangeListener);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sampleEditorPane = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        colorStylesLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        colorStylesList = new javax.swing.JList(Styles.EditorColor.values());
        colorChooser = new javax.swing.JColorChooser();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        resetCurrentColorButton = new javax.swing.JButton();
        resetAllColorsButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        sampleEditorPane.setEditable(false);
        sampleEditorPane.setText("Sample translation text");
        sampleEditorPane.setMinimumSize(new java.awt.Dimension(400, 100));
        sampleEditorPane.setName(""); // NOI18N
        sampleEditorPane.setPreferredSize(new java.awt.Dimension(400, 100));
        sampleEditorPane.setRequestFocusEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(OStrings.getString("GUI_COLORS_TITLE")); // NOI18N
        setIconImage(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 10));
        jPanel3.setLayout(new java.awt.BorderLayout());

        org.openide.awt.Mnemonics.setLocalizedText(colorStylesLabel, OStrings.getString("GUI_COLORS_COLOR")); // NOI18N
        jPanel3.add(colorStylesLabel, java.awt.BorderLayout.NORTH);

        colorStylesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        colorStylesList.setSelectedIndex(0);
        colorStylesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                colorStylesListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(colorStylesList);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.WEST);
        jPanel1.add(colorChooser, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 10, 10));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridLayout(0, 1));

        org.openide.awt.Mnemonics.setLocalizedText(resetCurrentColorButton, OStrings.getString("GUI_COLORS_RESET_COLOR")); // NOI18N
        resetCurrentColorButton.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        resetCurrentColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetThisColorButtonActionPerformed(evt);
            }
        });
        jPanel4.add(resetCurrentColorButton);

        org.openide.awt.Mnemonics.setLocalizedText(resetAllColorsButton, OStrings.getString("GUI_COLORS_RESET_ALL_COLORS")); // NOI18N
        resetAllColorsButton.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        resetAllColorsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetAllColorsButtonActionPerformed(evt);
            }
        });
        jPanel4.add(resetAllColorsButton);

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        org.openide.awt.Mnemonics.setLocalizedText(okButton, OStrings.getString("BUTTON_OK")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        jPanel5.add(okButton);

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton, OStrings.getString("BUTTON_CANCEL")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel5.add(cancelButton);

        jPanel4.add(jPanel5);

        jPanel2.add(jPanel4, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void colorStylesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_colorStylesListValueChanged
        EditorColor selectedStyle = (EditorColor) colorStylesList.getSelectedValue();
        if (selectedStyle == null) {
            colorChooser.setEnabled(false);
            resetCurrentColorButton.setEnabled(false);
            return;
        }
        colorChooser.setEnabled(true);
        resetCurrentColorButton.setEnabled(true);
        Color color = temporaryPreferences.containsKey(selectedStyle) ? 
                temporaryPreferences.get(selectedStyle) : selectedStyle.getColor();
        setColorChooserWithoutNotifying(color);
    }//GEN-LAST:event_colorStylesListValueChanged

    private void resetAllColorsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetAllColorsButtonActionPerformed

        int confirm = JOptionPane.showConfirmDialog(this, OStrings.getString("GUI_COLORS_RESET_ALL_COLORS_CONFIRM"), OStrings.getString("GUI_COLORS_RESET_ALL_COLORS").replaceFirst("&", ""), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        ListModel model = colorStylesList.getModel();
        for (int i = 0; i < model.getSize(); i++) {
            EditorColor style = (EditorColor) model.getElementAt(i);
            temporaryPreferences.put(style, style.getDefault());
        }
        resetThisColorButtonActionPerformed(null);
    }//GEN-LAST:event_resetAllColorsButtonActionPerformed

    private void resetThisColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetThisColorButtonActionPerformed
        EditorColor selectedStyle = (Styles.EditorColor) colorStylesList.getSelectedValue();
        if (selectedStyle == null) {
            return;
        }
        Color defaultColor = selectedStyle.getDefault();
        if (defaultColor == null) {
            setColorChooserWithoutNotifying(Color.BLACK);
            temporaryPreferences.put(selectedStyle, null);
        } else {
            colorChooser.setColor(defaultColor);
        }
    }//GEN-LAST:event_resetThisColorButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        for (Entry<EditorColor, Color> e : temporaryPreferences.entrySet()) {
            EditorColor style = e.getKey();
            style.setColor(e.getValue());
        }
        Preferences.save();
        if (!temporaryPreferences.isEmpty()) {
            JOptionPane.showMessageDialog(this, OStrings.getString("GUI_COLORS_CHANGED_RESTART"));
        }
        closeDialog();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        closeDialog();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void closeDialog() {
        temporaryPreferences.clear();
        setVisible(false);
        dispose();
    }

    // Hide the Transparency Slider.
    // From: http://stackoverflow.com/a/22608885
    private static void removeTransparencySlider(JColorChooser jc) throws Exception {

        AbstractColorChooserPanel[] colorPanels = jc.getChooserPanels();
        for (int i = 1; i < colorPanels.length; i++) {
            AbstractColorChooserPanel cp = colorPanels[i];

            Field f = cp.getClass().getDeclaredField("panel");
            f.setAccessible(true);

            Object colorPanel = f.get(cp);
            Field f2 = colorPanel.getClass().getDeclaredField("spinners");
            f2.setAccessible(true);
            Object spinners = f2.get(colorPanel);

            Object transpSlispinner = Array.get(spinners, 3);
            if (i == colorPanels.length - 1) {
                transpSlispinner = Array.get(spinners, 4);
            }
            Field f3 = transpSlispinner.getClass().getDeclaredField("slider");
            f3.setAccessible(true);
            JSlider slider = (JSlider) f3.get(transpSlispinner);
            slider.setEnabled(false);
            slider.setVisible(false);
            Field f4 = transpSlispinner.getClass().getDeclaredField("spinner");
            f4.setAccessible(true);
            JSpinner spinner = (JSpinner) f4.get(transpSlispinner);
            spinner.setEnabled(false);
            spinner.setVisible(false);

            Field f5 = transpSlispinner.getClass().getDeclaredField("label");
            f5.setAccessible(true);
            JLabel label = (JLabel) f5.get(transpSlispinner);
            label.setVisible(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JColorChooser colorChooser;
    private javax.swing.JLabel colorStylesLabel;
    private javax.swing.JList colorStylesList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okButton;
    private javax.swing.JButton resetAllColorsButton;
    private javax.swing.JButton resetCurrentColorButton;
    private javax.swing.JEditorPane sampleEditorPane;
    // End of variables declaration//GEN-END:variables
}
