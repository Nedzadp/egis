/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu.links.home;

import com.pss.pp4is.layout.content.window.ExitWindow;
import com.pss.pp4is.layout.navigation.submenu.CustomSubmenuLink;
import com.vaadin.ui.UI;

/**
 *
 * @author Nedzad
 */
public class SubMenuExitNavigationLink extends CustomSubmenuLink{

    @Override
    public void addCaption() {
        setCaption(getLayoutController().getI18n().translate("Exit"));
    }
    

    @Override
    public void handleClick(ClickEvent event) {
        getLayoutController().fixSelectedSubMenu(this);
        UI.getCurrent().addWindow(new ExitWindow(getLayoutController()));
    }
    
    @Override
    public String getLinkCaption() {
        return getCaption();
    }
}
