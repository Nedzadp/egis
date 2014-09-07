/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu.links.home;

import com.pss.pp4is.layout.navigation.submenu.CustomSubmenuLink;
import com.vaadin.ui.Notification;

/**
 *
 * @author Nedzad
 */
public class SubMenuExitNavigationLink extends CustomSubmenuLink{

    public SubMenuExitNavigationLink() {
        setCaption("Exit");
    }

    @Override
    public void handleClick(ClickEvent event) {
        getLayoutController().fixSelectedSubMenu(this);
        Notification.show("Not implemented yet");
    }
    
}
