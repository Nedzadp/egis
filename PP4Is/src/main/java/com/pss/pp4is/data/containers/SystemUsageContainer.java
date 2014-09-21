/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.containers;

import com.pss.pp4is.data.models.SystemUsage;
import com.vaadin.data.util.BeanItemContainer;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class SystemUsageContainer extends BeanItemContainer<SystemUsage> implements Serializable{

    public static final Object[] NATURAL_COL_ORDER = new String[] {
        "username", "hoursInSystem", "newProducts", "newInspections", "uploadedImages","inspectedImages"};

    public static final String[] COL_HEADERS_ENGLISH = new String[] {
         "Username", "Hours in system", "New products", "New inspections", "Uploaded master images", "Inspected images"};
    
    public SystemUsageContainer() throws IllegalArgumentException {
        super(SystemUsage.class);
    }
}