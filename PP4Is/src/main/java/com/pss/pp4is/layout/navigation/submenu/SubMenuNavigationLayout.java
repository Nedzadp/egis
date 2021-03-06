/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu;

import com.pss.pp4is.layout.navigation.MainMenuNavigationEnum;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.HorizontalLayout;

/**
 *
 * @author Nedzad
 */
public class SubMenuNavigationLayout extends  HorizontalLayout{

    private HorizontalLayout subMenuLayout;
    private final LayoutController layoutController;
    
    public SubMenuNavigationLayout(LayoutController layoutController) {
        this.layoutController = layoutController;
        addStyleName("submenu");
        initLayout();
    }
    private void initLayout() {
        addComponent(subMenuLayout = new HorizontalLayout());
        layoutController.buildSubMenu(MainMenuNavigationEnum.MAIN_MENU_HOME_LINK.getRow(), subMenuLayout,false);
    }
    
    public void initLayoutForAuthenticatedUser() {
        addComponent(subMenuLayout = new HorizontalLayout());
        layoutController.buildSubMenu(MainMenuNavigationEnum.MAIN_MENU_HOME_LINK.getRow(), subMenuLayout,true);
    }

    public HorizontalLayout getSubMenuLayout() {
        return subMenuLayout;
    }

    public void initLayoutForAuthenticatedUserWithLanguage() {
        addComponent(subMenuLayout = new HorizontalLayout());
        layoutController.buildSubMenu(layoutController.getCurrentRootLinkSelected().getCustomButtonLinkId(), subMenuLayout,true);
    }
}
