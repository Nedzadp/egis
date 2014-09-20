/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.data.models.TranslationComponent;
import com.pss.pp4is.layout.content.CustomVerticalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;

/**
 *
 * @author Nedzad
 */
public class MainContentTranslationLayout extends CustomVerticalLayout{

    
    @Override
    public void initLayout() {
        setMargin(true);
        setSpacing(true);
        
        addComponent(new Label(getLayoutController().getI18n().translate("Translation listing")));
        
        Table translationTable = new Table();
        translationTable.setContainerDataSource(DataController.getTranslations());
        
        translationTable.setVisibleColumns("keyword","englishTranslation","hungarianTranslation");
        translationTable.setColumnHeaders(getLayoutController().getI18n().translate("Keyword"),getLayoutController().getI18n().translate("English"),getLayoutController().getI18n().translate("Hungarian"));
        
        addComponent(translationTable);
    }
}