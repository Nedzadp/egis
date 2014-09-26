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
        Notification note = new Notification(null,"Log in here, please!",Notification.Type.HUMANIZED_MESSAGE);
        note.setDelayMsec(4000);
        note.setPosition(Position.TOP_CENTER);
        note.setStyleName("mynotification");
        note.show(Page.getCurrent());

        
        getLayoutController().getUserLoginHeader().getLoginLabel().removeStyleName("login-label");
        getLayoutController().getUserLoginHeader().getLoginLabel().addStyleName("login-label-blinker");
        
        getLayoutController().getUserLoginHeader().getUsernameField().addStyleName("login-fields-blinker");
        getLayoutController().getUserLoginHeader().getPasswordField().addStyleName("login-fields-blinker");
        
        getLayoutController().getUserLoginHeader().getUsernameField().focus();
    }
}
