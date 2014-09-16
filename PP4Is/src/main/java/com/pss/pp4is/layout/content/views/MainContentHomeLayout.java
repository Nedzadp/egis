/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views;

import com.pss.pp4is.data.models.Product;
import com.pss.pp4is.data.models.ProductMaster;
import com.pss.pp4is.layout.content.CustomVerticalLayout;
import com.pss.pp4is.layout.content.LeftMainContentComponent;
import com.pss.pp4is.layout.content.RightMainContentComponent;
import com.vaadin.data.Property;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.HorizontalLayout;


/**
 *
 * @author Nedzad
 */
public class MainContentHomeLayout extends CustomVerticalLayout{

    public MainContentHomeLayout() {
        initLayout();
    }
    
    private void initLayout() {
        setMargin(false);
        setSpacing(false);
        
        addComponent(new CustomLayout("welcome"));
    }
}
