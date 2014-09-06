/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.system;

import com.pss.pp4is.layout.CustomLayout;
import com.pss.pp4is.layout.UserLoginHeader;
import com.pss.pp4is.layout.content.MainContentComponent;
import com.pss.pp4is.layout.navigation.CustomButtonLink;
import com.pss.pp4is.layout.navigation.MainMenuNavigationLayout;
import com.pss.pp4is.layout.navigation.submenu.CustomSubmenuLink;
import com.pss.pp4is.layout.navigation.submenu.SubMenuNavigationEnum;
import com.pss.pp4is.layout.navigation.submenu.SubMenuNavigationLayout;
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
    private UserLoginHeader userLoginHeader;
    private MainMenuNavigationLayout mainMenuNavigationLayout;
    private SubMenuNavigationLayout subMenuNavigationLayout;
    private MainContentComponent mainContentComponent;
    
    public LayoutController(CustomLayout customLayout) {
        this.customLayout = customLayout;
    }

    public CustomLayout getCustomLayout() {
        return customLayout;
    }

    public MainMenuNavigationLayout getMainMenuNavigationLayout() {
        return mainMenuNavigationLayout;
    }

    public void setMainMenuNavigationLayout(MainMenuNavigationLayout mainMenuNavigationLayout) {
        this.mainMenuNavigationLayout = mainMenuNavigationLayout;
    }

    public SubMenuNavigationLayout getSubMenuNavigationLayout() {
        return subMenuNavigationLayout;
    }

    public void setSubMenuNavigationLayout(SubMenuNavigationLayout subMenuNavigationLayout) {
        this.subMenuNavigationLayout = subMenuNavigationLayout;
    }

    public MainContentComponent getMainContentComponent() {
        return mainContentComponent;
    }

    public void setMainContentComponent(MainContentComponent mainContentComponent) {
        this.mainContentComponent = mainContentComponent;
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

    public void setUserLogin(UserLoginHeader userLoginHeader) {
       this.userLoginHeader = userLoginHeader;
    }

    public UserLoginHeader getUserLoginHeader() {
        return userLoginHeader;
    }

    public void refreshLayout() {
        getUserLoginHeader().removeAllComponents();
        getMainMenuNavigationLayout().removeAllComponents();
        getSubMenuNavigationLayout().removeAllComponents();
        getMainContentComponent().removeAllComponents();
        getMainMenuNavigationLayout().initLayoutForAuthenticatedUser();
        
    }
}
