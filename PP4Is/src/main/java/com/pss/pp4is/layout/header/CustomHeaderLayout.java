/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.header;

import com.pss.pp4is.layout.UserLoginHeader;
import com.pss.pp4is.system.LanguageEnum;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.data.Property;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;

/**
 *
 * @author Nedzad
 */
public class CustomHeaderLayout extends  HorizontalLayout{

    private final LayoutController layoutController;
    private UserLoginHeader userLoginHeader;
    
    public CustomHeaderLayout(LayoutController layoutController) {
        this.layoutController = layoutController;
        initLayout();
    }
 
    private void initLayout() {
        setWidth("100%");
        setHeight("35px");
        addStyleName("custom-header");
        HorizontalLayout leftHeaderLayout = createLeftHeader();
        
        addComponent(leftHeaderLayout);
        setComponentAlignment(leftHeaderLayout, Alignment.TOP_LEFT);
        
        userLoginHeader = new UserLoginHeader(layoutController);
        addComponent(userLoginHeader);
        setComponentAlignment(userLoginHeader, Alignment.TOP_RIGHT);
        layoutController.setUserLogin(userLoginHeader);
    }
    
    private HorizontalLayout createLeftHeader() {
        HorizontalLayout leftHeaderLayout = new HorizontalLayout();
        leftHeaderLayout.setWidth("100%");
       
        ComboBox comboBox = new ComboBox(null);
        
        comboBox.setNullSelectionAllowed(false);
        comboBox.setTextInputAllowed(false);
        comboBox.setImmediate(true);
        comboBox.addStyleName("custom-combobox");
        
        comboBox.addItem("eng");
        comboBox.setItemCaption("eng", "English");
        comboBox.setItemIcon("eng", new ThemeResource("img/English.png"));
        
        comboBox.addItem("hun");
        comboBox.setItemCaption("hun", "Hungary");
        comboBox.setItemIcon("hun", new ThemeResource("img/Hungary.png"));
        
        comboBox.setValue(layoutController.getI18n().getLanguageEnum().getLang());
        
        comboBox.addValueChangeListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                final String language = String.valueOf(event.getProperty().getValue());
                layoutController.getI18n().setLanguageEnum(LanguageEnum.getLanguage(language));
                if(layoutController.getUser()==null) {
                    layoutController.refreshLanguageLayout();
                } else {
                    layoutController.refreshLanguageLayoutAuthenticated();
                    layoutController.getCurrentSubmenuLinkSelected().click();
                }
            }
        });
        
        leftHeaderLayout.addComponent(comboBox);
        
        return leftHeaderLayout;
    }
    
}
