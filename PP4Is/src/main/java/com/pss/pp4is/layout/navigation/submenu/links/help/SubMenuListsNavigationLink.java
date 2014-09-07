/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu.links.help;

import com.pss.pp4is.layout.navigation.submenu.CustomSubmenuLink;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;

/**
 *
 * @author Nedzad
 */
public class SubMenuListsNavigationLink extends CustomSubmenuLink{

    public SubMenuListsNavigationLink() {
        setCaption("Lists");
    }

    @Override
    public void handleClick(Button.ClickEvent event) {
        getLayoutController().fixSelectedSubMenu(this);
        Notification.show("Not implemented yet");
    }
    
   
}