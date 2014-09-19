/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.listing;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.layout.content.CustomVerticalLayout;
import com.pss.pp4is.layout.content.tables.ProductPrinterTable;
import com.vaadin.ui.Label;

/**
 *
 * @author Nedzad
 */
public class MainContentProductPrinterLayout extends CustomVerticalLayout{

    
    @Override
    public void initLayout() {
        setMargin(true);
        setSpacing(true);
        
        addComponent(new Label(getLayoutController().getI18n().translate("Product printer listing")));
        
        ProductPrinterTable productPrinterTable = new ProductPrinterTable(DataController.getProductPrinter());
        
        addComponent(productPrinterTable);
        
    }
}
