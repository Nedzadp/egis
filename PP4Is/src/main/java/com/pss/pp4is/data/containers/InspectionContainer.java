/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.containers;

import com.pss.pp4is.data.models.Inspection;
import com.vaadin.data.util.BeanItemContainer;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class InspectionContainer extends BeanItemContainer<Inspection> implements Serializable{

    public static final Object[] NATURAL_COL_ORDER = new String[] {
        "inspectionId", "inspectionDate", "path", "inspector", "cikkNum", "meoNum", "naploNum", "taskaNum", "closed" };

    public static final String[] COL_HEADERS_ENGLISH = new String[] {
         "Inspection Id", "Insp. date", "Path", "Inspector", "cikkNum", "meoNum", "naploNum", "taskaNum", "closed"  };
    
    public InspectionContainer() throws IllegalArgumentException {
        super(Inspection.class);
    }
    
}
