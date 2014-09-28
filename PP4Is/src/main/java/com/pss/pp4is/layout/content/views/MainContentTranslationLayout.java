/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.layout.content.CustomPanelLayout;
import com.pss.pp4is.layout.content.tables.TranslationTable;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Nedzad
 */
public class MainContentTranslationLayout extends CustomPanelLayout{

    public MainContentTranslationLayout(LayoutController layoutController) {
        super(layoutController);
    }

    
    @Override
    public void initLayout() {
        VerticalLayout layoutContent = new VerticalLayout();
        layoutContent.setMargin(true);
        layoutContent.setSpacing(true);
        
        layoutContent.addComponent(new Label(getLayoutController().getI18n().translate("Translation listing")));
        layoutContent.addComponent(new TranslationTable(getLayoutController(), DataController.getTranslations()));
        
        addComponent(layoutContent);
    }
}