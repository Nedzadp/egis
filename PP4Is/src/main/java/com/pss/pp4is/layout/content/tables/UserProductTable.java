/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.tables;

import com.pss.pp4is.data.containers.UserProductContainer;
import com.vaadin.ui.Table;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class UserProductTable extends Table implements Serializable{

    private final UserProductContainer userProductContainer;
    
    public UserProductTable(UserProductContainer userProductContainer) {
        this.userProductContainer = userProductContainer;
        initTable();
    }
    
    private void initTable() {
        setColumnCollapsingAllowed(true);
        setColumnReorderingAllowed(true);
        setSelectable(true);
        setImmediate(true);
        setNullSelectionAllowed(false);
        setSizeFull();
        setPageLength(7);
        createDataRow();
        setVisibleColumns(UserProductContainer.NATURAL_COL_ORDER);
        setColumnHeaders(UserProductContainer.COL_HEADERS_ENGLISH);
        
    }
    
    private void createDataRow() {
        setContainerDataSource(userProductContainer);
    }
}
