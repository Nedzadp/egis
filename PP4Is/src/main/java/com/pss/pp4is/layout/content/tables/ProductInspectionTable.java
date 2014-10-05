/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.tables;

import com.pss.pp4is.data.containers.InspectionContainer;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.Table;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class ProductInspectionTable extends Table implements Serializable{

    private final InspectionContainer inspectionContainer;
    private final LayoutController layoutController;
    
    public ProductInspectionTable(LayoutController layoutController,InspectionContainer inspectionContainer) {
        this.layoutController = layoutController;
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
        setPageLength(5);
        createDataRow();
        setColumnCollapsed("inspectionId", true);
        setColumnCollapsed("path", true);
        setColumnCollapsed("inspector", true);
        setColumnCollapsed("cikkNum", true);
        setColumnCollapsed("naploNum", true);
        setColumnCollapsed("taskaNum", true);
        setVisibleColumns(InspectionContainer.NATURAL_COL_ORDER);
        setColumnHeaders(inspectionContainer.getCOL_HEADERS_ENGLISH(layoutController));
    }
    
    private void createDataRow() {
        setContainerDataSource(inspectionContainer);
    }
}
