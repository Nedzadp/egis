/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.links;

import com.pss.pp4is.layout.navigation.CustomButtonLink;
import com.pss.pp4is.layout.navigation.MainMenuNavigationEnum;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.Notification;
/**
 *
 * @author Nedzad
 */
public class MainMenuListsNavigationLink extends CustomButtonLink{

    public MainMenuListsNavigationLink() {
        setCaption("Lists");
    }

    @Override
    public void handleClick(ClickEvent event) {
        getLayoutController().fixSelectedMenu(this);
        this.addStyleName("selected");
        getLayoutController().setCustomButtonLink(this);
        getLayoutController().buildSubMenu(MainMenuNavigationEnum.MAIN_MENU_LISTS_LINK.getRow(),getLayoutController().getCustomLayout().getSubMenuNavigationLayout().getSubMenuLayout(),true);
    }
}