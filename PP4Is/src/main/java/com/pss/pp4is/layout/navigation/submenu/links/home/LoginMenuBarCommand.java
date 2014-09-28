/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu.links.home;

import com.pss.pp4is.layout.AbstractCommand;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.themes.ValoTheme;

/**
 *
 * @author Nedzad
 */
public class LoginMenuBarCommand extends AbstractCommand{

    public LoginMenuBarCommand(LayoutController layoutController) {
        super(layoutController);
    }

    @Override
    public void menuSelected(MenuBar.MenuItem selectedItem) {
        getLayoutController().setMenuSelected(selectedItem);
        Notification note = new Notification(null,"Log in here, please!",Notification.Type.TRAY_NOTIFICATION);
        note.setDelayMsec(2000);
        note.setPosition(Position.TOP_CENTER);
        note.setStyleName(ValoTheme.NOTIFICATION_SMALL);
        note.show(Page.getCurrent());

        
        getLayoutController().getUserLoginHeader().getLoginLabel().removeStyleName("login-label-color");
        getLayoutController().getUserLoginHeader().getLoginLabel().addStyleName("login-label-blinker");
        
        getLayoutController().getUserLoginHeader().getUsernameField().addStyleName("login-fields-blinker");
        getLayoutController().getUserLoginHeader().getPasswordField().addStyleName("login-fields-blinker");
        
        getLayoutController().getUserLoginHeader().getUsernameField().focus();
    }
}
