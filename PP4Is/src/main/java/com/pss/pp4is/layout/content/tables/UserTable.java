/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.tables;

import com.pss.pp4is.data.containers.ProductTypeContainer;
import com.pss.pp4is.data.containers.UserContainer;
import com.vaadin.ui.Table;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class UserTable extends Table implements Serializable{

    private final UserContainer userContainer;
    
    public UserTable(UserContainer userContainer) {
        this.userContainer = userContainer;
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
        setVisibleColumns(UserContainer.NATURAL_COL_ORDER);
        setColumnCollapsed("userId", true);
        setColumnCollapsed("password", true);
        setColumnHeaders(UserContainer.COL_HEADERS_ENGLISH);
    }
    
    private void createDataRow() {
        setContainerDataSource(userContainer);
    }
}
