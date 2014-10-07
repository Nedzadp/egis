/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.tables;

import com.pss.pp4is.data.containers.InspectionDetailContainer;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.Table;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class InspectionDetailTable extends Table implements Serializable{

    private final InspectionDetailContainer inspectionDetailContainer;
    private final LayoutController layoutController;
    
    public InspectionDetailTable(LayoutController layoutController,InspectionDetailContainer inspectionDetailContainer) {
        this.layoutController =layoutController;
        this.inspectionDetailContainer = inspectionDetailContainer;
        initTable();
    }
    
    private void initTable() {
        setColumnCollapsingAllowed(true);
        setColumnReorderingAllowed(true);
        setSelectable(true);
        setImmediate(true);
        setNullSelectionAllowed(false);
        setSizeFull();
        createDataRow();
        setPageLength(size());
        setVisibleColumns(InspectionDetailContainer.NATURAL_COL_ORDER);
        setColumnCollapsed("inspection_details_id", true);
        setColumnCollapsed("master_id", true);
        setColumnCollapsed("masterName", true);
        setColumnCollapsed("vizsgalt_feltoltve_path", true);
        setColumnCollapsed("eredmeny_path", true);
        setColumnCollapsed("jelolt_path", true);
        setColumnCollapsed("maszk_path", true);
        setColumnCollapsed("mester_path", true);
        setColumnCollapsed("mester_feldolgozott_path", true);
        setColumnCollapsed("vizsgalt_path", true);
        setColumnCollapsed("vizsgalt_feldolgozott_path", true);
        setColumnCollapsed("jelolt_szamozott_path", true);
        setColumnCollapsed("elfogadva", true);
        setColumnCollapsed("engedellyel_elfogadva", true);
        setColumnCollapsed("elutasitva", true);
        setColumnCollapsed("inspection_profile_notes", true);
        setColumnCollapsed("onTheBunchList", true);
        setColumnCollapsed("urgent", true);
        setColumnCollapsed("vizsgalt_feltoltve_path_pdf", true);
        
        setColumnHeaders(inspectionDetailContainer.getCOL_HEADERS_ENGLISH(layoutController));
        setColumnWidth("vizsgalt_name", 270);
        setColumnWidth("type", 70);
        setColumnWidth("result", 80);
        setColumnWidth("cert", 96);
    }
    
    private void createDataRow() {
        setContainerDataSource(inspectionDetailContainer);
    }

    public void refreshTable(InspectionDetailContainer inspectionDetailContainer) {
        if(this.size()!= 0) {
            removeAllItems();
        }
        setContainerDataSource(inspectionDetailContainer);
        setVisibleColumns(InspectionDetailContainer.NATURAL_COL_ORDER);
        setColumnCollapsed("inspection_details_id", true);
        setColumnCollapsed("master_id", true);
        setColumnCollapsed("masterName", true);
        setColumnCollapsed("vizsgalt_feltoltve_path", true);
        setColumnCollapsed("eredmeny_path", true);
        setColumnCollapsed("jelolt_path", true);
        setColumnCollapsed("maszk_path", true);
        setColumnCollapsed("mester_path", true);
        setColumnCollapsed("mester_feldolgozott_path", true);
        setColumnCollapsed("vizsgalt_path", true);
        setColumnCollapsed("vizsgalt_feldolgozott_path", true);
        setColumnCollapsed("jelolt_szamozott_path", true);
        setColumnCollapsed("elfogadva", true);
        setColumnCollapsed("engedellyel_elfogadva", true);
        setColumnCollapsed("elutasitva", true);
        setColumnCollapsed("inspection_profile_notes", true);
        setColumnCollapsed("onTheBunchList", true);
        setColumnCollapsed("urgent", true);
        setColumnCollapsed("vizsgalt_feltoltve_path_pdf", true);
        setColumnHeaders(inspectionDetailContainer.getCOL_HEADERS_ENGLISH(layoutController));
    }
}

