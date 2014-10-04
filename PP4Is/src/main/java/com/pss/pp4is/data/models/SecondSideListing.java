/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.models;

import com.vaadin.ui.HorizontalLayout;

/**
 *
 * @author Nedzad
 */
public class SecondSideListing extends HorizontalLayout{

    private final Integer value;
    
    public SecondSideListing(Integer value) {
        this.value = value;
        initLayout();
    }
    
    private void initLayout() {
        addStyleName("css-shapes-preview2-green");
    }
    
}
