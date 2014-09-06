/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu.links;

import com.pss.pp4is.layout.navigation.submenu.CustomSubmenuLink;
import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.Notification;

/**
 *
 * @author Nedzad
 */
public class SubMenuLoginNavigationLink extends CustomSubmenuLink{

    public SubMenuLoginNavigationLink() {
        setCaption("Log in");
    }

    @Override
    public void handleClick(ClickEvent event) {
        Notification note = new Notification(null,"Log in here, please!",Notification.Type.HUMANIZED_MESSAGE);
        note.setDelayMsec(3000);
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
