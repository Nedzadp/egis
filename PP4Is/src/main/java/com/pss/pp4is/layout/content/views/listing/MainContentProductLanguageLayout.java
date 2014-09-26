/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.listing;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.layout.content.CustomPanelLayout;
import com.pss.pp4is.layout.content.CustomVerticalLayout;
import com.pss.pp4is.layout.content.tables.ProductLanguageTable;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Nedzad
 */
public class MainContentProductLanguageLayout extends CustomPanelLayout{

    public MainContentProductLanguageLayout(LayoutController layoutController) {
        super(layoutController);
    }


    @Override
    public void initLayout() {
        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);
        
        layout.addComponent(new Label(getLayoutController().getI18n().translate("Product language listing")));
        
        ProductLanguageTable productLanguageTable = new ProductLanguageTable(DataController.getProductLanguage());
        
        layout.addComponent(productLanguageTable);
        
        setContent(layout);
    }
}