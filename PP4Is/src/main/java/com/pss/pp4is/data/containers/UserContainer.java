/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.containers;

import com.pss.pp4is.data.models.User;
import com.vaadin.data.util.BeanItemContainer;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class UserContainer extends BeanItemContainer<User> implements Serializable{

    public static final Object[] NATURAL_COL_ORDER = new String[] {
        "userId", "firstName", "lastName","email","username","password", "language", "isActive"};

    public static final String[] COL_HEADERS_ENGLISH = new String[] {
         "User id" ,"First name","Last name","Email","Username","Password","Language","Active"};
    
    public UserContainer() throws IllegalArgumentException {
        super(User.class);
    }
}

