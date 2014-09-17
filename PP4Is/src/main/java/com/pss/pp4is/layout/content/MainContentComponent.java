/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content;

import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Nedzad
 */
public class MainContentComponent extends  VerticalLayout{
    
    public MainContentComponent() {
        setMargin(false);
        setSpacing(false);
        setSizeFull();
        
        initLayout();
    }
    
    public void initLayout() {
        addComponent(new CustomLayout("home"));
    }
    
    public void initWelcomeLayout() {
        addComponent(new CustomLayout("welcome"));
    }
}
