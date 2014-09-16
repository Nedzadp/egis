/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.form;

import com.pss.pp4is.data.models.Product;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextArea;

/**
 *
 * @author Nedzad
 */
public class LeftFormLayoutTop extends FormLayout implements IFormLayout{
    private ComboBox productId;
    private ComboBox productName;
    private ComboBox productType;
    private ComboBox language;
    private TextArea printerComp;

    public LeftFormLayoutTop() {
        setMargin(true);
        setSizeUndefined();
        initFormLayout();
    }
    
    private void initFormLayout() {
        
        addComponent(productId = new ComboBox("Product id"));
        productId.setNullSelectionAllowed(false);
        productId.setWidth("155px");
        addComponent(productName = new ComboBox("Name"));
        productName.setNullSelectionAllowed(false);
        productName.setWidth("155px");
        
        addComponent(productType = new ComboBox("Type"));
        productType.setNullSelectionAllowed(false);
        productType.setWidth("155px");
        addComponent(language = new ComboBox("Language"));
        language.setNullSelectionAllowed(false);
        language.setWidth("155px");
        addComponent(printerComp = new TextArea("Printer comp"));
        printerComp.setWidth("155px");
    }

    public ComboBox getProductId() {
        return productId;
    }

    public ComboBox getProductName() {
        return productName;
    }

    public ComboBox getProductType() {
        return productType;
    }

    public ComboBox getLanguage() {
        return language;
    }

    public TextArea getPrinterComp() {
        return printerComp;
    }

    public void updateLayout(Product product) {
        getProductId().removeAllItems();
        getProductId().addItem(product.getProductId());
        getProductId().select(product.getProductId());
        
        getProductName().removeAllItems();
        getProductName().addItem(product.getName());
        getProductName().select(product.getName());
        
        getProductType().removeAllItems();
        getProductType().addItem(product.getProductTypeName());
        getProductType().select(product.getProductTypeName());
        
        getLanguage().removeAllItems();
        getLanguage().addItem(product.getProductLanguageName());
        getLanguage().select(product.getProductLanguageName());
        
        getPrinterComp().setValue(product.getProductPrinterName());
    }
    
}
