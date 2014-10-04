/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.models;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

/**
 *
 * @author Nedzad
 */
public class MiddleContentBlue extends HorizontalLayout{

    private final String value;
    public MiddleContentBlue(String value) {
        this.value = value;
        initLayout();
    }
    
    private void initLayout() {
        addStyleName("css-content-blue");
        addComponent(new Label(value));
    }
    
}
