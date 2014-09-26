/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content;

import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.Panel;
import com.vaadin.ui.themes.ValoTheme;

/**
 *
 * @author Nedzad
 */
public abstract class CustomPanelLayout extends Panel{
    private final LayoutController layoutController;
    
    public CustomPanelLayout(LayoutController layoutController) {
        this.layoutController = layoutController;
        addStyleName(ValoTheme.PANEL_BORDERLESS);
        addStyleName(ValoTheme.PANEL_SCROLL_INDICATOR);
        setWidth("990px");
        setHeight("100%");
    }

    public LayoutController getLayoutController() {
        return layoutController;
    }
    
    public abstract void initLayout();
}
