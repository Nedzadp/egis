/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu.links.home;

import com.pss.pp4is.layout.AbstractCommand;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.MenuBar;

/**
 *
 * @author Nedzad
 */
public class RestartClockMenuBarCommand extends AbstractCommand {

    public RestartClockMenuBarCommand(LayoutController layoutController) {
        super(layoutController);
    }

    @Override
    public void menuSelected(MenuBar.MenuItem selectedItem) {
        getLayoutController().setMenuSelected(selectedItem);
       getLayoutController().getUserLoginHeader().resetClock();
    }
}
