/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool 
          with fuzzy matching, translation memory, keyword search, 
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2000-2006 Keith Godfrey and Maxym Mykhalchuk
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

package org.omegat.gui.main;

import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import com.vlsolutions.swing.docking.DockKey;
import com.vlsolutions.swing.docking.Dockable;
import com.vlsolutions.swing.docking.DockingConstants;

/**
 * Dockable ScrollPane for a docking library.
 * 
 * @author Maxym Mykhalchuk
 * @author Aaron Madlon-Kay
 */
@SuppressWarnings("serial")
public class DockableScrollPane extends JScrollPane implements Dockable {
    DockKey dockKey;

    /** Updates the tool tip text of the docking pane. */
    @Override
    public void setToolTipText(String text) {
        dockKey.setTooltip(text);
    }

    /** Updates the name of the docking pane. */
    @Override
    public void setName(String name) {
        dockKey.setName(name);
    }

    /** Creates a new instance of DockableScrollBox */
    public DockableScrollPane(String key, String name, Component view, boolean detouchable) {
        super(view);
        if (view instanceof JTextComponent && UIManager.getBoolean("OmegaTDockablePanel.isProportionalMargins")) {
            JTextComponent c = (JTextComponent) view;
            int size = c.getFont().getSize() / 2;
            c.setBorder(new EmptyBorder(size, size, size, size));
        }
        Border panelBorder = UIManager.getBorder("OmegaTDockablePanel.border"); 
        if (panelBorder != null) {
            setBorder(panelBorder);
        }
        Border viewportBorder = UIManager.getBorder("OmegaTDockablePanelViewport.border");
        if (viewportBorder != null) {
            setViewportBorder(viewportBorder);
        }
        dockKey = new DockKey(key, name, null, null, DockingConstants.HIDE_BOTTOM);
        dockKey.setFloatEnabled(detouchable);
        dockKey.setCloseEnabled(false);
    }

    @Override
    public DockKey getDockKey() {
        return dockKey;
    }

    @Override
    public Component getComponent() {
        return this;
    }

}
