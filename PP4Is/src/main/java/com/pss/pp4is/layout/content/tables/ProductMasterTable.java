/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.tables;

import com.pss.pp4is.data.containers.ProductMasterContainer;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class ProductMasterTable extends Table implements Serializable{

    private final ProductMasterContainer products;
    
    public ProductMasterTable(ProductMasterContainer products) {
        this.products = products;
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
        setVisibleColumns(ProductMasterContainer.NATURAL_COL_ORDER);
        setColumnHeaders(ProductMasterContainer.COL_HEADERS_ENGLISH);
    }
    
    private void createDataRow() {
        setContainerDataSource(products);
    }

}