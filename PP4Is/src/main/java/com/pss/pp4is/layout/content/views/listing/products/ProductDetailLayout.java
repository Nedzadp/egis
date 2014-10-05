/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.listing.products;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.data.models.NewProductListing;
import com.pss.pp4is.data.models.Product;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Nedzad
 */
public class ProductDetailLayout extends VerticalLayout{

    private final LayoutController layoutController;
    private final NewProductListing productListing;
    
    public ProductDetailLayout(LayoutController layoutController, NewProductListing productListing) {
        this.layoutController = layoutController;
        this.productListing = productListing;
        initLayout();
    }
    
    private void initLayout() {
       addStyleName("product-detail-layout");
       
       Product product = DataController.getProduct(productListing.getProductId());
       
       
       HorizontalLayout headerLayout = new HorizontalLayout();
       headerLayout.addStyleName("product-detail-header-layout");
       Label headerText = new Label(layoutController.getI18n().translate("Product details"));
       headerText.addStyleName("header-label");
       headerLayout.addComponent(headerText);
       
       VerticalLayout dataLayout = new VerticalLayout();
       dataLayout.addStyleName("data-layout");
       
       dataLayout.addComponent(new DataLabelLayout(new Label(layoutController.getI18n().translate("Document type:")), new Label(product.getProductTypeName())));
       dataLayout.addComponent(new DataLabelLayout(new Label(layoutController.getI18n().translate("Language:")), new Label(product.getProductLanguageName())));
       dataLayout.addComponent(new DataLabelLayout(new Label(layoutController.getI18n().translate("Printer company:")), new Label(product.getProductPrinterName())));
       dataLayout.addComponent(new DataLabelLayout(new Label(layoutController.getI18n().translate("ID:")), new Label(product.getProductId().toString())));
       dataLayout.addComponent(new DataLabelLayout(new Label(layoutController.getI18n().translate("Note:")), new Label(product.getProductNote())));
       
       addComponent(headerLayout);
       addComponent(dataLayout);
       
       
    }
}
