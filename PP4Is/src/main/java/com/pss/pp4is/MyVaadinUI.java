package com.pss.pp4is;

import com.pss.pp4is.layout.CustomLayout;
import com.pss.pp4is.system.I18n;
import com.pss.pp4is.system.LanguageEnum;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import javax.servlet.annotation.WebServlet;

@Theme("pp4istheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI
{
    private LayoutController layoutController;
    private CustomLayout customLayout;
    private VerticalLayout footer;
    
    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.pss.pp4is.AppWidgetSet", heartbeatInterval = 300)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        initNewLayout();
    }
    
    private void initNewLayout() {
        
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();
        VerticalLayout layout = new VerticalLayout();
        layout.addStyleName("vertical-background");
        
        layoutController = new LayoutController();
        layoutController.setI18n(new I18n(LanguageEnum.getENGLISH()));
        customLayout = new CustomLayout(layoutController);
        layoutController.setCustomLayout(customLayout);
        layout.addComponent(customLayout);
        mainLayout.addComponent(layout);
        mainLayout.setExpandRatio(layout, 0.95f);
        
        createFooter();
        
        mainLayout.addComponent(footer);
        mainLayout.setExpandRatio(footer, 0.05f);
        
        setContent(mainLayout);
    }
    
    
    private void createFooter() {
        HorizontalLayout headerLine = new HorizontalLayout();
        headerLine.addStyleName("header-layout-line");
        headerLine.setHeight("4px");
        
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSizeFull();
        horizontalLayout.addStyleName("header-layout");
        horizontalLayout.setHeight("36px");
        
        HorizontalLayout footerContent = new HorizontalLayout();
        footerContent.addStyleName("header-layout-content");
        footerContent.setSpacing(true);
        
        HorizontalLayout footerImageLayout = new HorizontalLayout();
        footerImageLayout.setWidth("725px");
        Image footerLogo =new Image(null, new ThemeResource("img/footer-logo.png"));
        footerImageLayout.addComponent(footerLogo);
        
        HorizontalLayout footerLabelLayout = new HorizontalLayout();
        Label footerLabel = new Label(layoutController.getI18n().translate("Copyright 2014 Pixel System Solutions Kft."));
        footerLabel.addStyleName("login-label-color");
        footerLabelLayout.addComponent(footerLabel);
        
        footerContent.addComponent(footerImageLayout);
        footerContent.addComponent(footerLabelLayout);
        
        horizontalLayout.addComponent(footerContent);
        horizontalLayout.setComponentAlignment(footerContent, Alignment.MIDDLE_CENTER);
        
        footer = new VerticalLayout();
        footer.addStyleName("footer-background");
        footer.setSizeFull();
        footer.addComponent(headerLine);
        footer.setExpandRatio(headerLine, 0.1f);
        footer.addComponent(horizontalLayout);
        footer.setExpandRatio(horizontalLayout, 0.9f);
    }
    
    private void initLayout() {
        
        VerticalLayout layout  = new VerticalLayout();

        layout.setSizeFull();
        
        layoutController = new LayoutController();
        layoutController.setI18n(new I18n(LanguageEnum.getENGLISH()));
        customLayout = new CustomLayout(layoutController);
        layoutController.setCustomLayout(customLayout);
        layout.addComponent(customLayout);
        
        setContent(layout);
    }

 
}
