/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu.links;

import com.pss.pp4is.layout.content.CustomVerticalLayout;
import com.pss.pp4is.layout.content.MainContentLayoutEnum;
import com.pss.pp4is.layout.navigation.submenu.CustomSubmenuLink;
import com.pss.pp4is.layout.navigation.submenu.SubMenuNavigationEnum;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;

/**
 *
 * @author Nedzad
 */
public class SubMenuInspectionProfilesNavigationLink extends CustomSubmenuLink{

    public SubMenuInspectionProfilesNavigationLink() {
        setCaption("Inspection profiles");
    }

    @Override
    public void handleClick(ClickEvent event) {
        getLayoutController().fixSelectedSubMenu(this);
        Notification.show("Not implemented yet");
    }
    
   
}
