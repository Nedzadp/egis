/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.containers;

import com.pss.pp4is.data.models.Product;
import com.vaadin.data.util.BeanItemContainer;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class ProductContainer extends BeanItemContainer<Product> implements Serializable{

    public static final Object[] NATURAL_COL_ORDER = new String[] {
        "productId", "name", "productTypeName", "productLanguageName", "productPrinterName", "productNote" };

    public static final String[] COL_HEADERS_ENGLISH = new String[] {
         "Product Id", "Name", "Type", "Language", "Printer", "Note" };
    
    public ProductContainer() throws IllegalArgumentException {
        super(Product.class);
    }
    
}
