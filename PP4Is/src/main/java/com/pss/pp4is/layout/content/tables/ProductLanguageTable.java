/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.tables;

import com.pss.pp4is.data.containers.ProductLanguageContainer;
import com.vaadin.ui.Table;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class ProductLanguageTable extends Table implements Serializable{

    private final ProductLanguageContainer productLanguageContainer;
    
    public ProductLanguageTable(ProductLanguageContainer productLanguageContainer) {
        this.productLanguageContainer = productLanguageContainer;
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
        setVisibleColumns(ProductLanguageContainer.NATURAL_COL_ORDER);
        setColumnCollapsed("productLanguageId", true);
        setColumnHeaders(ProductLanguageContainer.COL_HEADERS_ENGLISH);
        setColumnWidth("productLanguageId", 120);
    }
    
    private void createDataRow() {
        setContainerDataSource(productLanguageContainer);
    }
}
