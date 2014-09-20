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
public class SubMenuHomeNavigationLink extends CustomSubmenuLink{

    @Override
    public void addCaption() {
        setCaption(getLayoutController().getI18n().translate("Welcome"));
    }

    @Override
    public void handleClick(ClickEvent event) {
        getLayoutController().fixSelectedSubMenu(this);
        getLayoutController().getCustomLayout().getMainContentComponent().removeAllComponents();
        if(getLayoutController().getUser()!=null) {
            getLayoutController().getCustomLayout().getMainContentComponent().initWelcomeLayout();
        } else {
            getLayoutController().getCustomLayout().getMainContentComponent().initLayout();
        }
    }
    
    @Override
    public String getLinkCaption() {
        return getCaption();
    }
}
