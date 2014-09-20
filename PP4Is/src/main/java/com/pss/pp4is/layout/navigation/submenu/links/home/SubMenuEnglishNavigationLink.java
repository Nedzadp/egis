/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu.links.home;

import com.pss.pp4is.layout.navigation.submenu.CustomSubmenuLink;
import com.pss.pp4is.system.LanguageEnum;

/**
 *
 * @author Nedzad
 */
public class SubMenuEnglishNavigationLink extends CustomSubmenuLink{

    @Override
    public void addCaption() {
        setCaption("English");
    }

    
    @Override
    public void handleClick(ClickEvent event) {
        getLayoutController().fixSelectedSubMenu(this);
        getLayoutController().getI18n().setLanguageEnum(LanguageEnum.ENGLISH);
        if(getLayoutController().getUser()==null) {
            getLayoutController().refreshLanguageLayout();
        } else {
            getLayoutController().refreshLayout();
            getLayoutController().getCustomButtonLink().handleClick(null);
            getLayoutController().getCustomSubmenuLink().handleClick(null);
        }
    }
    @Override
    public String getLinkCaption() {
        return getCaption();
    }
    
}
