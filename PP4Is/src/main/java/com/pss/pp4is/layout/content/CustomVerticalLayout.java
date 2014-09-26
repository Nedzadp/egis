/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content;

import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Nedzad
 */
public abstract class CustomVerticalLayout extends VerticalLayout{
    private LayoutController layoutController;
    
    public CustomVerticalLayout() {
    }

    public void setLayoutController(LayoutController layoutController) {
        this.layoutController = layoutController;
    }

    public LayoutController getLayoutController() {
        return layoutController;
    }
    
    public abstract void initLayout();
    
}
