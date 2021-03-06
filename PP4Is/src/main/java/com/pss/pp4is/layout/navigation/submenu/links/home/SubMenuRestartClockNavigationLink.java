/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu.links.home;

import com.pss.pp4is.layout.navigation.submenu.CustomSubmenuLink;

/**
 *
 * @author Nedzad
 */
public class SubMenuRestartClockNavigationLink extends CustomSubmenuLink {

    @Override
    public void addCaption() {
        setCaption(getLayoutController().getI18n().translate("Restart clock"));
    }
    
    @Override
    public void handleClick(ClickEvent event) {
        getLayoutController().fixSelectedSubMenu(this);
        getLayoutController().getUserLoginHeader().resetClock();
    }
    @Override
    public String getLinkCaption() {
        return getCaption();
    }
}
