/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.tables;

import com.pss.pp4is.data.containers.InspectionContainer;
import com.vaadin.ui.Table;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class ProductInspectionTable extends Table implements Serializable{

    private final InspectionContainer inspectionContainer;
    
    public ProductInspectionTable(InspectionContainer inspectionContainer) {
        this.inspectionContainer = inspectionContainer;
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
        setColumnCollapsed("inspectionId", true);
        setVisibleColumns(inspectionContainer.NATURAL_COL_ORDER);
        setColumnHeaders(inspectionContainer.COL_HEADERS_ENGLISH);
    }
    
    private void createDataRow() {
        setContainerDataSource(inspectionContainer);
    }
}
