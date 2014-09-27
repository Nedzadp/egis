/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.tables;

import com.pss.pp4is.data.containers.InspectionProfileContainer;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.Table;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class InspectionProfileTable extends Table implements Serializable{

    private final InspectionProfileContainer inspectionProfileContainer;
    private final LayoutController layoutController;
    
    public InspectionProfileTable(LayoutController layoutController,InspectionProfileContainer inspectionProfileContainer) {
        this.layoutController = layoutController;
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
        setColumnHeaders(inspectionProfileContainer.getCOL_HEADERS_ENGLISH(layoutController));
        setColumnWidth("inspectionProfileId", 120);
    }
    
    private void createDataRow() {
        setContainerDataSource(inspectionProfileContainer);
    }
}
