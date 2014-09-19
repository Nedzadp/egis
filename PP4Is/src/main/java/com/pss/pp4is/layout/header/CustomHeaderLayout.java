/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.header;

import com.pss.pp4is.layout.UserLoginHeader;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.combobox.FilteringMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Embedded;
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
        comboBox.setFilteringMode(FilteringMode.CONTAINS);
        comboBox.setTextInputAllowed(false);

        comboBox.addItem("Test 1");
        comboBox.addItem("Test 2");
        comboBox.addItem("Test 3");
        leftHeaderLayout.addComponent(comboBox);
        
        return leftHeaderLayout;
    }
    
}
