/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation;

import com.pss.pp4is.layout.navigation.links.MainMenuHomeNavigationLink;
import com.pss.pp4is.layout.navigation.links.MainMenuListsNavigationLink;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.HorizontalLayout;

/**
 *
 * @author Nedzad
 */
public class MainMenuNavigationLayout extends  HorizontalLayout{
    
    private final LayoutController layoutController;
    private MainMenuHomeNavigationLink menuHomeNavigationLink;
    
    public MainMenuNavigationLayout(LayoutController layoutController) {
        this.layoutController = layoutController;
        initLayout();
    }
    
    private void initLayout() {
        
        for(MainMenuNavigationEnum mainMenu : MainMenuNavigationEnum.getValuesForAnonymousUser()) {
            CustomButtonLink buttonLink = mainMenu.getInstance();
            buttonLink.setLayoutController(layoutController);
            if(mainMenu.getRow() == 1) {
                layoutController.setCustomButtonLink(buttonLink);
            }
            addComponent(buttonLink);
        }
    }
    
    public void initLayoutForAuthenticatedUser() {
        
        for(MainMenuNavigationEnum mainMenu : MainMenuNavigationEnum.getValuesForAuthenticatedUser()) {
            CustomButtonLink buttonLink = mainMenu.getInstance();
            buttonLink.setLayoutController(layoutController);
            if(mainMenu.getRow() == 1) {
                layoutController.setCustomButtonLink(buttonLink);
            }
            addComponent(buttonLink);
        }
    }
}
