/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation;

import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.HorizontalLayout;

/**
 *
 * @author Nedzad
 */
public class MainMenuNavigationLayout extends  HorizontalLayout{
    
    private final LayoutController layoutController;
    
    public MainMenuNavigationLayout(LayoutController layoutController) {
        this.layoutController = layoutController;
        initLayout();
    }
    
    private void initLayout() {
        
        for(MainMenuNavigationEnum mainMenu : MainMenuNavigationEnum.getValuesForAnonymousUser()) {
            CustomButtonLink buttonLink = mainMenu.getInstance();
            buttonLink.setLayoutController(layoutController);
            buttonLink.addCaption();
            buttonLink.setCustomButtonLinkId(mainMenu.getRow());
            if(mainMenu.getRow() == 1) {
                layoutController.setCustomButtonLink(buttonLink);
            }
            if(layoutController.getCurrentRootLinkSelected() == null) {
                layoutController.setCurrentRootLinkSelected(buttonLink);
                layoutController.fixSelectedMenu(buttonLink);
            }
            if(buttonLink.equals(layoutController.getCurrentRootLinkSelected())) {
                layoutController.fixSelectedMenu(buttonLink);
            }
            addComponent(buttonLink);
        }
    }
    
    public void initLayoutForAuthenticatedUser() {
        
        for(MainMenuNavigationEnum mainMenu : MainMenuNavigationEnum.getValuesForAuthenticatedUser()) {
            CustomButtonLink buttonLink = mainMenu.getInstance();
            buttonLink.setLayoutController(layoutController);
            buttonLink.addCaption();
            buttonLink.setCustomButtonLinkId(mainMenu.getRow());
                    
            if(layoutController.getCurrentRootLinkSelected() == null) {
                layoutController.setCurrentRootLinkSelected(buttonLink);
                layoutController.setCustomButtonLink(buttonLink);
                buttonLink.addStyleName("selected");
            }
            if(buttonLink.equals(layoutController.getCurrentRootLinkSelected())) {
                buttonLink.addStyleName("selected");
                layoutController.setCustomButtonLink(buttonLink);
            }
            
            addComponent(buttonLink);
        }
    }
}
