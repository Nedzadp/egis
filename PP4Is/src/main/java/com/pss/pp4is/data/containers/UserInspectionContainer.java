/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.containers;

import com.pss.pp4is.data.models.UserInspection;
import com.vaadin.data.util.BeanItemContainer;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class UserInspectionContainer extends BeanItemContainer<UserInspection> implements Serializable{

    public static final Object[] NATURAL_COL_ORDER = new String[] {
        "username", "productName", "createdAt", "created", "modifiedAt", "modified"};

    public static final String[] COL_HEADERS_ENGLISH = new String[] {
         "Username", "Product Name", "Created at", "Created", "Modified at", "Modified"};
    
    public UserInspectionContainer() throws IllegalArgumentException {
        super(UserInspection.class);
    }
}

