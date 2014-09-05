/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu.links;

import com.pss.pp4is.layout.navigation.submenu.CustomSubmenuLink;

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
       getLayoutController().getUserLoginHeader().getLoginLabel().removeStyleName("login-label");
       getLayoutController().getUserLoginHeader().getLoginLabel().addStyleName("login-label-action");
    }
    
}
