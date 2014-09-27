/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu.links.home;

import com.pss.pp4is.layout.AbstractCommand;
import com.pss.pp4is.layout.content.window.ExitWindow;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;

/**
 *
 * @author Nedzad
 */
public class ExitMenuBarCommand extends AbstractCommand{

    public ExitMenuBarCommand(LayoutController layoutController) {
        super(layoutController);
    }

    @Override
    public void menuSelected(MenuBar.MenuItem selectedItem) {
        
        UI.getCurrent().addWindow(new ExitWindow(getLayoutController()));
    }
}
