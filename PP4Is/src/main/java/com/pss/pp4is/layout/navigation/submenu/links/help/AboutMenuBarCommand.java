/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu.links.help;

import com.pss.pp4is.layout.AbstractCommand;
import com.pss.pp4is.layout.content.CustomPanelLayout;
import com.pss.pp4is.layout.content.views.help.MainContentAboutLayout;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.MenuBar;

/**
 *
 * @author Nedzad
 */
public class AboutMenuBarCommand extends AbstractCommand{

    public AboutMenuBarCommand(LayoutController layoutController) {
        super(layoutController);
    }

    @Override
    public void menuSelected(MenuBar.MenuItem selectedItem) {
        getLayoutController().setMenuSelected(selectedItem);
        CustomPanelLayout layout = new MainContentAboutLayout(getLayoutController());
        layout.initLayout();
        getLayoutController().getCustomLayout().getMainContentComponent().removeAllComponents();
        getLayoutController().getCustomLayout().getMainContentComponent().addComponent(layout);
    }
   
}
