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
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import javax.servlet.annotation.WebServlet;

@Theme("pp4istheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI
{
    private LayoutController layoutController;
    private CustomLayout customLayout;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.pss.pp4is.AppWidgetSet", heartbeatInterval = 300)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        initNewLayout();
    }
    
    private void initNewLayout() {
        VerticalLayout verticalLayout = new VerticalLayout();
        
        layoutController = new LayoutController();
        layoutController.setI18n(new I18n(LanguageEnum.getENGLISH()));
        customLayout = new CustomLayout(layoutController);
        layoutController.setCustomLayout(customLayout);
        verticalLayout.addComponent(customLayout);
        
        setContent(verticalLayout);
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
