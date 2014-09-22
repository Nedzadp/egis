/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout;

import com.pss.pp4is.layout.content.MainContentComponent;
import com.pss.pp4is.layout.header.CustomHeaderLayout;
import com.pss.pp4is.layout.navigation.MainMenuNavigationLayout;
import com.pss.pp4is.layout.navigation.submenu.SubMenuNavigationLayout;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.event.MouseEvents;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Nedzad
 */
public class CustomLayout extends  VerticalLayout{

    private static final String LOGO_PATH = "img/pp4s-logo.jpg";
    private static final String EGIS_LOGO_PATH = "img/egis-logo.png";
    private MainMenuNavigationLayout mainMenuNavigationLayout;
    private SubMenuNavigationLayout subMenuNavigationLayout;
    private MainContentComponent mainContentComponent;
    private final LayoutController layoutController;
    
    public CustomLayout(LayoutController layoutController) {
        this.layoutController = layoutController;
        init();
    }
    
    public final void init() {
        initLayout();
        
        createHeader();
        
        createMainMenuNavigation();
        
        createSubMenuNavigation();
        
        //addHorizontalLines(true);
        
        addMainContent();
    }
    
    private void initLayout()  {
        addStyleName("vertical-custom-layout");
    }
    
    private void createHeader() {
        addComponent(new CustomHeaderLayout(layoutController));
        
        addHorizontalLines(false);
        
        addLogo();
        
    }
    
    private void addHorizontalLines(boolean sameColor) {
        HorizontalLayout mainHorizontalLine = new HorizontalLayout();
        mainHorizontalLine.setHeight("4px");
        mainHorizontalLine.addStyleName("hrline2");
        addComponent(mainHorizontalLine);
        
        if(!sameColor) {
            HorizontalLayout subHorizontalLine = new HorizontalLayout();
            subHorizontalLine.setWidth("300px");
            subHorizontalLine.setHeight("4px");
            subHorizontalLine.addStyleName("hrline");

            mainHorizontalLine.addComponent(subHorizontalLine);
            mainHorizontalLine.setComponentAlignment(subHorizontalLine, Alignment.TOP_LEFT);
        }
    }
    
    private void addLogo() {
        HorizontalLayout logoLayout = new HorizontalLayout();
        logoLayout.setWidth("100%");
        // Display the image without caption
        Image logo = new Image(null, new ThemeResource(LOGO_PATH));
        logo.addClickListener(new ClickListener() {
            @Override
            public void click(MouseEvents.ClickEvent event) {
                getLayoutController().getCustomLayout().getMainContentComponent().removeAllComponents();
                if(getLayoutController().getUser()!=null) {
                    getLayoutController().getCustomLayout().getMainContentComponent().initWelcomeLayout();
                }else {
                    getLayoutController().getCustomLayout().getMainContentComponent().initLayout();
                }
            }
        });
        logoLayout.addComponent(logo);
        Image egis_logo = new Image(null, new ThemeResource(EGIS_LOGO_PATH));
        logoLayout.addComponent(egis_logo);
        logoLayout.setComponentAlignment(egis_logo, Alignment.TOP_RIGHT);
        addComponent(logoLayout);
    }
    
    private void addMainContent() {
        addComponent(mainContentComponent = new MainContentComponent(layoutController));
        layoutController.setMainContentComponent(mainContentComponent);
    }
    
    private void createMainMenuNavigation() {
        subMenuNavigationLayout = new SubMenuNavigationLayout(layoutController);
        layoutController.setSubMenuNavigationLayout(subMenuNavigationLayout);
        addComponent(mainMenuNavigationLayout = new MainMenuNavigationLayout(layoutController));
        layoutController.setMainMenuNavigationLayout(mainMenuNavigationLayout);
    }

    public MainContentComponent getMainContentComponent() {
        return mainContentComponent;
    }
   
    private void createSubMenuNavigation() {
        addComponent(subMenuNavigationLayout);
    }

    public SubMenuNavigationLayout getSubMenuNavigationLayout() {
        return subMenuNavigationLayout;
    }

    public MainMenuNavigationLayout getMainMenuNavigationLayout() {
        return mainMenuNavigationLayout;
    }

    public LayoutController getLayoutController() {
        return layoutController;
    }
}
