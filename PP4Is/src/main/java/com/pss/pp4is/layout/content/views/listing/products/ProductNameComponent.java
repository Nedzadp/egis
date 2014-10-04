/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.listing.products;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;

/**
 *
 * @author Nedzad
 */
public class ProductNameComponent extends HorizontalLayout {

    private final String productName;
    
    public ProductNameComponent(String productName) {
        this.productName = productName;
        initLayout();
    }
    
    private void initLayout() {
        addStyleName("product-name");
        HorizontalLayout layout = new HorizontalLayout();
        layout.addStyleName("product-name-layout");
        Label label = new Label(productName);
        label.addStyleName("product-name-label");
        layout.addComponent(label);
        addComponent(layout);
        
        ImageComponent imageComponent = new ImageComponent("arrow3.png", "1");
        addComponent(imageComponent);
    }
}
