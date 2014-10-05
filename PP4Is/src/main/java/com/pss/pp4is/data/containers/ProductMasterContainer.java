/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.containers;

import com.pss.pp4is.data.models.ProductMaster;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.data.util.BeanItemContainer;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class ProductMasterContainer extends BeanItemContainer<ProductMaster> implements Serializable{

    public static final Object[] NATURAL_COL_ORDER = new String[] {
        "masterId", "name", "type", "pdf", "active",  "leaflet", "braille", "falt" };

    public  String[] COL_HEADERS_ENGLISH;
    
   
    public ProductMasterContainer() throws IllegalArgumentException {
        super(ProductMaster.class);
    }
    
    public String[] getCOL_HEADERS_ENGLISH(LayoutController layoutController) {
         COL_HEADERS_ENGLISH = new String[] { 
             layoutController.getI18n().translate("Master Id"), 
             layoutController.getI18n().translate("Master images"), 
             layoutController.getI18n().translate("Type"), 
             layoutController.getI18n().translate("Pdf"), 
             layoutController.getI18n().translate("Active"),
             layoutController.getI18n().translate("Leaflet"), 
             layoutController.getI18n().translate("Braille"), 
             layoutController.getI18n().translate("Falt")
               };
         
         return COL_HEADERS_ENGLISH;
    }
}
