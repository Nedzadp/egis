/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu.links.help;

import com.pss.pp4is.layout.content.CustomVerticalLayout;
import com.pss.pp4is.layout.content.MainContentLayoutEnum;
import com.pss.pp4is.layout.navigation.submenu.CustomSubmenuLink;
import com.pss.pp4is.layout.navigation.submenu.SubMenuNavigationEnum;
import com.vaadin.ui.Button;

/**
 *
 * @author Nedzad
 */
public class SubMenuInformationNavigationLink extends CustomSubmenuLink{

    public SubMenuInformationNavigationLink() {
        setCaption("Information");
    }

    @Override
    public void handleClick(Button.ClickEvent event) {
        getLayoutController().fixSelectedSubMenu(this);
        CustomVerticalLayout layout = MainContentLayoutEnum.getInstanceBySubMenu(SubMenuNavigationEnum.SUB_MENU_INFORMATION.getRow());
        if(layout != null) {
            getLayoutController().getCustomLayout().getMainContentComponent().removeAllComponents();
            getLayoutController().getCustomLayout().getMainContentComponent().addComponent(layout);
        }
    }
    
}
