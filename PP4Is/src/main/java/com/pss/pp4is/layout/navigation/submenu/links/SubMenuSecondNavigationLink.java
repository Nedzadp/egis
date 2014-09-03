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
public class SubMenuSecondNavigationLink extends CustomSubmenuLink {
    public SubMenuSecondNavigationLink() {
        setCaption("Submenu link");
    }

    @Override
    public void handleClick(ClickEvent event) {
        getLayoutController().setCustomSubmenuLink(this);
        getLayoutController().fixSelectedSubMenu(this);
        
        
    }
}
