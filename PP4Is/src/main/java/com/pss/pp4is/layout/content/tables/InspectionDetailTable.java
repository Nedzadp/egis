/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.tables;

import com.pss.pp4is.data.containers.InspectionDetailContainer;
import com.pss.pp4is.data.containers.InspectionProfileContainer;
import com.vaadin.ui.Table;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class InspectionDetailTable extends Table implements Serializable{

    private final InspectionDetailContainer inspectionDetailContainer;
    
    public InspectionDetailTable(InspectionDetailContainer inspectionDetailContainer) {
        this.inspectionDetailContainer = inspectionDetailContainer;
        initTable();
    }
    
    private void initTable() {
        addStyleName("right-table");
        setColumnCollapsingAllowed(true);
        setColumnReorderingAllowed(true);
        setSelectable(true);
        setImmediate(true);
        setNullSelectionAllowed(false);
        setSizeFull();
        setPageLength(10);
        createDataRow();
        setVisibleColumns(InspectionDetailContainer.NATURAL_COL_ORDER);
        setColumnCollapsed("inspection_details_id", true);
        setColumnCollapsed("master_id", true);
        setColumnHeaders(InspectionDetailContainer.COL_HEADERS_ENGLISH);
        setColumnWidth("inspection_details_id", 120);
    }
    
    private void createDataRow() {
        setContainerDataSource(inspectionDetailContainer);
    }
}

