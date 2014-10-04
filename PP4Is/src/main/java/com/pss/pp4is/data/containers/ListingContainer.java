/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.containers;

import com.pss.pp4is.data.models.ListingModel;
import com.vaadin.data.util.BeanItemContainer;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class ListingContainer  extends BeanItemContainer<ListingModel> implements Serializable{

    public static final Object[] NATURAL_COL_ORDER = new String[] {
        "listingMiddleContent", "value","listingMiddleContent2"};

    public static final String[] COL_HEADERS_ENGLISH = new String[] {
         "Middle", "value", "listingMiddleContent2"};
    
    public ListingContainer() throws IllegalArgumentException {
        super(ListingModel.class);
    }
    
    
}
