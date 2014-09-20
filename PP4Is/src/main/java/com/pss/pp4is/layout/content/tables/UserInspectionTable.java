/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.tables;

import com.pss.pp4is.data.containers.UserInspectionContainer;
import com.pss.pp4is.data.containers.UserProductContainer;
import com.vaadin.ui.Table;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class UserInspectionTable extends Table implements Serializable{

    private final UserInspectionContainer userInspectionContainer;
    
    public UserInspectionTable(UserInspectionContainer userInspectionContainer) {
        this.userInspectionContainer = userInspectionContainer;
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
        setVisibleColumns(UserInspectionContainer.NATURAL_COL_ORDER);
        setColumnHeaders(UserInspectionContainer.COL_HEADERS_ENGLISH);
        
    }
    
    private void createDataRow() {
        setContainerDataSource(userInspectionContainer);
    }
}
