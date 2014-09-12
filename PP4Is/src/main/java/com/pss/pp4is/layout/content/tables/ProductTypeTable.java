/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.tables;

import com.pss.pp4is.data.containers.ProductLanguageContainer;
import com.pss.pp4is.data.containers.ProductTypeContainer;
import com.vaadin.ui.Table;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class ProductTypeTable extends Table implements Serializable{

    private final ProductTypeContainer productTypeContainer;
    
    public ProductTypeTable(ProductTypeContainer productTypeContainer) {
        this.productTypeContainer = productTypeContainer;
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
        setVisibleColumns(ProductTypeContainer.NATURAL_COL_ORDER);
        setColumnCollapsed("productTypeId", true);
        setColumnHeaders(ProductTypeContainer.COL_HEADERS_ENGLISH);
        setColumnWidth("productTypeId", 90);
    }
    
    private void createDataRow() {
        setContainerDataSource(productTypeContainer);
    }
}
