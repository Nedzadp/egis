/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.tables;

import com.pss.pp4is.data.containers.SystemUsageContainer;
import com.vaadin.ui.Table;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class SystemUsageTable extends Table implements Serializable{

    private final SystemUsageContainer systemUsageContainer;        
    
    public SystemUsageTable(SystemUsageContainer systemUsageContainer) {
        this.systemUsageContainer = systemUsageContainer;
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
        setVisibleColumns(SystemUsageContainer.NATURAL_COL_ORDER);
        setColumnHeaders(SystemUsageContainer.COL_HEADERS_ENGLISH);
        
    }
    
    private void createDataRow() {
        setContainerDataSource(systemUsageContainer);
    }
}

