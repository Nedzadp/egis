/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.layout.content.CustomPanelLayout;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
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
        
        Table translationTable = new Table();
        translationTable.setSizeFull();
        translationTable.setContainerDataSource(DataController.getTranslations());
        translationTable.setVisibleColumns("keyword","englishTranslation","hungarianTranslation");
        translationTable.setColumnHeaders(getLayoutController().getI18n().translate("Keyword"),getLayoutController().getI18n().translate("English"),getLayoutController().getI18n().translate("Hungarian"));
        
        translationTable.setColumnWidth("keyword", 420);
        
        layoutContent.addComponent(translationTable);
        
        setContent(layoutContent);
    }
}