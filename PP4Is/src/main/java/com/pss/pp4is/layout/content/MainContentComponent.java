/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content;

import com.pss.pp4is.layout.content.views.reports.HorizontalFilter;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Nedzad
 */
public class MainContentComponent extends  VerticalLayout{
    
    private final LayoutController layoutController;
    public MainContentComponent(LayoutController layoutController) {
        this.layoutController = layoutController;
    }
    
    public final void initLayout() {
        if(layoutController.getI18n().getLanguageEnum().getLang().equals("eng")) {
            addComponent(new CustomLayout("home_eng"));
        } else if(layoutController.getI18n().getLanguageEnum().getLang().equals("hun")) {
            addComponent(new CustomLayout("home_hun"));
        }
        HorizontalFilter filter = new HorizontalFilter(this.layoutController,null,null);
        addComponent(filter);
    }
    
    public void initWelcomeLayout() {
        if(layoutController.getI18n().getLanguageEnum().getLang().equals("eng")) {
            addComponent(new CustomLayout("welcome_eng"));
        } else if(layoutController.getI18n().getLanguageEnum().getLang().equals("hun")) {
            addComponent(new CustomLayout("welcome_hun"));
        }
    }
}
