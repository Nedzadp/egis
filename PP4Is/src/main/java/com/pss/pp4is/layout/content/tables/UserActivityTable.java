/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.tables;

import com.pss.pp4is.data.containers.UserActivityContainer;
import com.vaadin.ui.Table;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class UserActivityTable extends Table implements Serializable{

    private final UserActivityContainer userActivityContainer;
    
    public UserActivityTable(UserActivityContainer userActivityContainer) {
        this.userActivityContainer = userActivityContainer;
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
        setVisibleColumns(UserActivityContainer.NATURAL_COL_ORDER);
        setColumnCollapsed("id", true);
        setColumnHeaders(UserActivityContainer.COL_HEADERS_ENGLISH);
        setColumnWidth("id", 90);
    }
    
    private void createDataRow() {
        setContainerDataSource(userActivityContainer);
    }
}
