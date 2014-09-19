/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu.links.lists;

import com.pss.pp4is.layout.content.CustomVerticalLayout;
import com.pss.pp4is.layout.content.MainContentLayoutEnum;
import com.pss.pp4is.layout.navigation.submenu.CustomSubmenuLink;
import com.pss.pp4is.layout.navigation.submenu.SubMenuNavigationEnum;

/**
 *
 * @author Nedzad
 */
public class SubMenuProductsInspectionsNavigationLink extends CustomSubmenuLink{

    @Override
    public void addCaption() {
        setCaption(getLayoutController().getI18n().translate("Products and inspections"));
    }

    @Override
    public void handleClick(ClickEvent event) {
        getLayoutController().fixSelectedSubMenu(this);
        CustomVerticalLayout layout = MainContentLayoutEnum.getInstanceBySubMenu(SubMenuNavigationEnum.SUB_MENU_PRODUCTS_INSPECTIONS.getRow());
        if(layout != null) {
            layout.setLayoutController(getLayoutController());
            layout.initLayout();
            getLayoutController().getCustomLayout().getMainContentComponent().removeAllComponents();    
            getLayoutController().getCustomLayout().getMainContentComponent().addComponent(layout);
        }
    }
}
