/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.containers;

import com.pss.pp4is.data.models.ProductLanguage;
import com.vaadin.data.util.BeanItemContainer;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class ProductLanguageContainer extends BeanItemContainer<ProductLanguage> implements Serializable{

    public static final Object[] NATURAL_COL_ORDER = new String[] {
        "productLanguageId", "name"};

    public static final String[] COL_HEADERS_ENGLISH = new String[] {
         "Product language id" ,"Name"};
    
    public ProductLanguageContainer() throws IllegalArgumentException {
        super(ProductLanguage.class);
    }
    
}
