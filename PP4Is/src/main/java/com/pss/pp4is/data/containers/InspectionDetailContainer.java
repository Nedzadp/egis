/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.containers;

import com.pss.pp4is.data.models.InspectionDetail;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.data.util.BeanItemContainer;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class InspectionDetailContainer extends BeanItemContainer<InspectionDetail> implements Serializable{

    public static final Object[] NATURAL_COL_ORDER = new String[] {
        "inspection_details_id", "master_id", "masterName", "vizsgalt_name", "type","result", "cert","vizsgalt_feltoltve_path", "eredmeny_path", "jelolt_path", "maszk_path", "mester_path", "mester_feldolgozott_path",
        "vizsgalt_path", "vizsgalt_feldolgozott_path", "jelolt_szamozott_path", "elfogadva", "engedellyel_elfogadva", "elutasitva","inspection_profile_notes", "onTheBunchList", "urgent", "vizsgalt_feltoltve_path_pdf"
    };

    public String[] COL_HEADERS_ENGLISH;
    
    public InspectionDetailContainer() throws IllegalArgumentException {
        super(InspectionDetail.class);
    }

    public String[] getCOL_HEADERS_ENGLISH(LayoutController layoutController) {
         COL_HEADERS_ENGLISH = new String[] { layoutController.getI18n().translate("inspection_details_id"), 
             layoutController.getI18n().translate("master_id"), 
             layoutController.getI18n().translate("masterName"), 
             layoutController.getI18n().translate("Inspection images"), 
             layoutController.getI18n().translate("Type"), 
             layoutController.getI18n().translate("Result"),
             layoutController.getI18n().translate("Cert"),
             layoutController.getI18n().translate("vizsgalt_feltoltve_path"), 
             layoutController.getI18n().translate("eredmeny_path"), 
             layoutController.getI18n().translate("jelolt_path"), 
             layoutController.getI18n().translate("maszk_path"), 
             layoutController.getI18n().translate("mester_path"), 
             layoutController.getI18n().translate("mester_feldolgozott_path"),
             layoutController.getI18n().translate("vizsgalt_path"), 
             layoutController.getI18n().translate("vizsgalt_feldolgozott_path"), 
             layoutController.getI18n().translate("jelolt_szamozott_path"), 
             layoutController.getI18n().translate("elfogadva"), 
             layoutController.getI18n().translate("engedellyel_elfogadva"), 
             layoutController.getI18n().translate("elutasitva"),
             layoutController.getI18n().translate("inspection_profile_notes"), 
             layoutController.getI18n().translate("onTheBunchList"), 
             layoutController.getI18n().translate("urgent"), 
             layoutController.getI18n().translate("vizsgalt_feltoltve_path_pdf")
        };
         
        return COL_HEADERS_ENGLISH;
    }

   
    
}
