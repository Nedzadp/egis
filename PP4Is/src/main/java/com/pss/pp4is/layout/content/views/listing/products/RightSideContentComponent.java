/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.listing.products;

import com.vaadin.ui.AbsoluteLayout;

/**
 *
 * @author Nedzad
 */
public class RightSideContentComponent extends AbsoluteLayout{

    public RightSideContentComponent() {
        initLayout();
    }
 
    private void initLayout() {
        setWidth("500");
        setHeight("800");
        addStyleName("right-side");
    }
}
