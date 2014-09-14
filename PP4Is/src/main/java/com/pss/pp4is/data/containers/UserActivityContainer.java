/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.containers;

import com.pss.pp4is.data.models.UserActivity;
import com.vaadin.data.util.BeanItemContainer;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class UserActivityContainer extends BeanItemContainer<UserActivity> implements Serializable{

    public static final Object[] NATURAL_COL_ORDER = new String[] {
        "id", "loggedIn", "loggedOut", "clockReset", "username"};

    public static final String[] COL_HEADERS_ENGLISH = new String[] {
         "User activity id", "Logged in", "Logged out", "Clock reset counter", "Username"};
    
    public UserActivityContainer() throws IllegalArgumentException {
        super(UserActivity.class);
    }
}