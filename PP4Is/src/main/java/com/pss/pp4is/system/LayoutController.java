/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.system;

import com.pss.pp4is.layout.CustomLayout;
import com.pss.pp4is.layout.navigation.CustomButtonLink;
import com.pss.pp4is.layout.navigation.submenu.CustomSubmenuLink;
import com.pss.pp4is.layout.navigation.submenu.SubMenuNavigationEnum;
import com.vaadin.ui.HorizontalLayout;
import java.util.List;

/**
 *
 * @author Nedzad
 */
public class LayoutController{

    private final CustomLayout customLayout;
    private CustomButtonLink customButtonLink;
    private CustomSubmenuLink customSubmenuLink;
    
    public LayoutController(CustomLayout customLayout) {
        this.customLayout = customLayout;
    }

    public CustomLayout getCustomLayout() {
        return customLayout;
    }

    public void setCustomButtonLink(CustomButtonLink customButtonLink) {
        this.customButtonLink = customButtonLink;
        this.customButtonLink.addStyleName("selected");
    }

    public CustomButtonLink getCustomButtonLink() {
        return customButtonLink;
    }
    
    public void fixSelectedMenu(CustomButtonLink customButtonLink) {
        getCustomButtonLink().removeStyleName("selected");
        setCustomButtonLink(customButtonLink);
    }
    public void buildSubMenu(int rootMainMenu,HorizontalLayout menu) {
         menu.removeAllComponents();
        
        List<SubMenuNavigationEnum> subMenus = SubMenuNavigationEnum.getSubmenusByRootMenu(rootMainMenu);
        for(SubMenuNavigationEnum subMenu : subMenus) {
            CustomSubmenuLink link = subMenu.getInstance();
            link.setLayoutController(this);
            menu.addComponent(link);
        }
    }

    public void setCustomSubmenuLink(CustomSubmenuLink customSubmenuLink) {
        this.customSubmenuLink = customSubmenuLink;
        this.customSubmenuLink.addStyleName("sub-menu-selected");
    }

    public CustomSubmenuLink getCustomSubmenuLink() {
        return customSubmenuLink;
    }
    
    public void fixSelectedSubMenu(CustomSubmenuLink customSubmenuLink) {
        getCustomSubmenuLink().removeStyleName("sub-menu-selected");
        setCustomSubmenuLink(customSubmenuLink);
    }
    
    
    
}
