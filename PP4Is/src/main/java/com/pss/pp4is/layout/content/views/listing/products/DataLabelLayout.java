/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.listing.products;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

/**
 *
 * @author Nedzad
 */
public class DataLabelLayout extends HorizontalLayout {
    
    private final Label type;
    private final Label data;
    
    public DataLabelLayout(Label type, Label data) {
        this.type = type;
        this.data = data;
        initLayout();
    }
    
    private void initLayout() {
        addStyleName("data-label-layout");
        
        type.addStyleName("type-label");
        type.setHeight("4px");
        data.addStyleName("data-label");
        data.setHeight("4px");
        addComponent(type);
        Label spacer = new Label(" ");
        spacer.setWidth("5px");
        addComponent(spacer);
        addComponent(data);
    }
    
}
