/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.header;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

/**
 *
 * @author Nedzad
 */
public class CustomHeaderLayout extends  HorizontalLayout{

    public CustomHeaderLayout() {
        initLayout();
    }
 
    private void initLayout() {
        setWidth("100%");
        setHeight("35px");
        addStyleName("custom-header");
        HorizontalLayout leftHeaderLayout = createLeftHeader();
        
        addComponent(leftHeaderLayout);
        setComponentAlignment(leftHeaderLayout, Alignment.TOP_LEFT);
        
        HorizontalLayout rightHeaderLayout = createRightHeader();
        addComponent(rightHeaderLayout);
        setComponentAlignment(rightHeaderLayout, Alignment.TOP_RIGHT);
        
    }
    
    private HorizontalLayout createLeftHeader() {
        HorizontalLayout leftHeaderLayout = new HorizontalLayout();
        leftHeaderLayout.setWidth("120px");
       
        Embedded flagOne = new Embedded(null, new ThemeResource("images/hungary-flag.png"));
        leftHeaderLayout.addComponent(flagOne);
       
        Embedded flagTwo = new Embedded(null, new ThemeResource("images/united-kingdom-flag.png"));
        leftHeaderLayout.addComponent(flagTwo);
        
        Embedded flagThree = new Embedded(null, new ThemeResource("images/germany-flag.png"));
        leftHeaderLayout.addComponent(flagThree);
        
        return leftHeaderLayout;
    }
    
    private HorizontalLayout createRightHeader() {
        HorizontalLayout rightHeaderLayout = new HorizontalLayout();
        rightHeaderLayout.setWidth("350px");
        rightHeaderLayout.addStyleName("header-login");
        TextField username = new TextField();
        username.setInputPrompt("username");
        username.addStyleName("align-right");
        rightHeaderLayout.addComponent(username);
        PasswordField password = new PasswordField();
        password.setInputPrompt("password");
        rightHeaderLayout.addComponent(password);
        
        return rightHeaderLayout;
    }
    
}
