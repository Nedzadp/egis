/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.containers;

import com.pss.pp4is.data.models.InspectionDetail;
import com.vaadin.data.util.BeanItemContainer;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class InspectionDetailContainer extends BeanItemContainer<InspectionDetail> implements Serializable{

    public static final Object[] NATURAL_COL_ORDER = new String[] {
        "inspection_details_id", "master_id", "masterName", "vizsgalt_name", "vizsgalt_feltoltve_path", "eredmeny_path", "jelolt_path", "maszk_path", "mester_path", "mester_feldolgozott_path",
        "vizsgalt_path", "vizsgalt_feldolgozott_path", "jelolt_szamozott_path", "elfogadva", "engedellyel_elfogadva", "elutasitva","inspection_profile_notes", "onTheBunchList", "urgent", "vizsgalt_feltoltve_path_pdf"
    };

    public static final String[] COL_HEADERS_ENGLISH = new String[] {
        "inspection_details_id", "master_id", "masterName", "vizsgalt_name", "vizsgalt_feltoltve_path", "eredmeny_path", "jelolt_path", "maszk_path", "mester_path", "mester_feldolgozott_path",
        "vizsgalt_path", "vizsgalt_feldolgozott_path", "jelolt_szamozott_path", "elfogadva", "engedellyel_elfogadva", "elutasitva","inspection_profile_notes", "onTheBunchList", "urgent", "vizsgalt_feltoltve_path_pdf"
    };
    
    public InspectionDetailContainer() throws IllegalArgumentException {
        super(InspectionDetail.class);
    }
    
}
