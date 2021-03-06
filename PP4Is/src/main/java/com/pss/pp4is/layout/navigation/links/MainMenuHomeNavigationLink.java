/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.links;

import com.pss.pp4is.layout.navigation.CustomButtonLink;
import com.pss.pp4is.layout.navigation.MainMenuNavigationEnum;

/**
 *
 * @author Nedzad
 */
public class MainMenuHomeNavigationLink extends CustomButtonLink{


    @Override
    public void addCaption() {
        setCaption(getLayoutController().getI18n().translate("PP4I system"));
    }

    
    @Override
    public void handleClick(ClickEvent event) {
        setCustomButtonLinkId(MainMenuNavigationEnum.MAIN_MENU_HOME_LINK.getRow());
        getLayoutController().fixSelectedMenu(this);
        boolean authenticated = false;
        if(getLayoutController().getUserLoginHeader().getUser() != null) {
            authenticated = true;
        }
        getLayoutController().buildSubMenu(MainMenuNavigationEnum.MAIN_MENU_HOME_LINK.getRow(),getLayoutController().getCustomLayout().getSubMenuNavigationLayout().getSubMenuLayout(),authenticated);
    }
    
   
}
