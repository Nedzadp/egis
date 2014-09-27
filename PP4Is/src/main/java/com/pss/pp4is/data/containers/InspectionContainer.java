/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.containers;

import com.pss.pp4is.data.models.Inspection;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.data.util.BeanItemContainer;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class InspectionContainer extends BeanItemContainer<Inspection> implements Serializable{

    public static final Object[] NATURAL_COL_ORDER = new String[] {
        "inspectionId", "inspectionDate", "path", "inspector", "cikkNum", "meoNum", "naploNum", "taskaNum", "closed" };

    public   String[] COL_HEADERS_ENGLISH;
    
    public InspectionContainer() throws IllegalArgumentException {
        super(Inspection.class);
    }

    public String[] getCOL_HEADERS_ENGLISH(LayoutController layoutController) {
         COL_HEADERS_ENGLISH = new String[] { layoutController.getI18n().translate("Inspection Id"), 
             layoutController.getI18n().translate("Insp. date"), 
             layoutController.getI18n().translate("Path"), 
             layoutController.getI18n().translate("Inspector"), 
             layoutController.getI18n().translate("cikkNum"), 
             layoutController.getI18n().translate("meoNum"), 
             layoutController.getI18n().translate("naploNum"), 
             layoutController.getI18n().translate("taskaNum"), 
             layoutController.getI18n().translate("closed")  };
         
         return COL_HEADERS_ENGLISH;
    }
    
    
    
}
