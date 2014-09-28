/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.help;

import com.pss.pp4is.layout.content.CustomPanelLayout;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Nedzad
 */
public class MainContentAboutLayout extends CustomPanelLayout{

    public MainContentAboutLayout(LayoutController layoutController) {
        super(layoutController);
    }

   
    @Override
    public void initLayout() {
        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);
        if(getLayoutController().getI18n().getLanguageEnum().getLang().equals("eng")) {
            layout.addComponent(new CustomLayout("about_eng"));
        } else if(getLayoutController().getI18n().getLanguageEnum().getLang().equals("hun")) {
            layout.addComponent(new CustomLayout("about_hun")); 
        } 
        addComponent(layout);
    }
}
