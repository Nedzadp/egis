/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.containers;

import com.pss.pp4is.data.models.ProductMaster;
import com.vaadin.data.util.BeanItemContainer;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class ProductMasterContainer extends BeanItemContainer<ProductMaster> implements Serializable{

    public static final Object[] NATURAL_COL_ORDER = new String[] {
        "masterId", "name", "leaflet", "braille", "falt", "active" };

    public static final String[] COL_HEADERS_ENGLISH = new String[] {
         "Master Id", "Name", "Leaflet", "Braille", "Falt", "Active" };
    
    public ProductMasterContainer() throws IllegalArgumentException {
        super(ProductMaster.class);
    }
    
}
