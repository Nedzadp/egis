/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu.links.home;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.layout.navigation.submenu.CustomSubmenuLink;
import com.pss.pp4is.system.LanguageEnum;

/**
 *
 * @author Nedzad
 */
public class SubMenuMagyarNavigationLink extends  CustomSubmenuLink{

    @Override
    public void addCaption() {
        setCaption("Magyar");
    }
    
    @Override
    public void handleClick(ClickEvent event) {
        getLayoutController().fixSelectedSubMenu(this);
        getLayoutController().getI18n().setLanguageEnum(LanguageEnum.HUNGARIAN);
        if(getLayoutController().getUser()==null) {
            getLayoutController().refreshLanguageLayout();
        } else {
            getLayoutController().refreshLanguageLayoutAuthenticated();
            DataController.updateUserLanguage(getLayoutController().getUser(), LanguageEnum.HUNGARIAN.getLang());
        }
        getLayoutController().getComboBox().setValue(getLayoutController().getI18n().getLanguageEnum().getLang());
    }
    @Override
    public String getLinkCaption() {
        return getCaption();
    }
}
