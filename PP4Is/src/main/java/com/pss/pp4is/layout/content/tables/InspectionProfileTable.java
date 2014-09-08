/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.tables;

import com.pss.pp4is.data.containers.InspectionProfileContainer;
import com.pss.pp4is.data.containers.ProductLanguageContainer;
import com.vaadin.ui.Table;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class InspectionProfileTable extends Table implements Serializable{

    private final InspectionProfileContainer inspectionProfileContainer;
    
    public InspectionProfileTable(InspectionProfileContainer inspectionProfileContainer) {
        this.inspectionProfileContainer = inspectionProfileContainer;
        initTable();
    }
    
    private void initTable() {
        setColumnCollapsingAllowed(true);
        setColumnReorderingAllowed(true);
        setSelectable(true);
        setImmediate(true);
        setNullSelectionAllowed(false);
        setSizeFull();
        setPageLength(10);
        createDataRow();
        setVisibleColumns(InspectionProfileContainer.NATURAL_COL_ORDER);
        setColumnCollapsed("inspectionProfileId", true);
        setColumnHeaders(InspectionProfileContainer.COL_HEADERS_ENGLISH);
    }
    
    private void createDataRow() {
        setContainerDataSource(inspectionProfileContainer);
    }
}
