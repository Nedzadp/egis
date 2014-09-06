/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu.links;

import com.pss.pp4is.layout.navigation.submenu.CustomSubmenuLink;
import com.vaadin.ui.Notification;

/**
 *
 * @author Nedzad
 */
public class SubMenuEnglishNavigationLink extends CustomSubmenuLink{

    public SubMenuEnglishNavigationLink() {
        setCaption("English");
    }

    @Override
    public void handleClick(ClickEvent event) {
        getLayoutController().fixSelectedSubMenu(this);
        Notification.show("No implemented yet");
    }
    
    
}
