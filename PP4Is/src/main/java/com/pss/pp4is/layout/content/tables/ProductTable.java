/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.tables;

import com.pss.pp4is.data.containers.ProductContainer;
import com.vaadin.ui.Table;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class ProductTable extends Table implements Serializable{

    private final ProductContainer products;
    
    public ProductTable(ProductContainer products) {
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
        setPageLength(10);
        createDataRow();
        setVisibleColumns(ProductContainer.NATURAL_COL_ORDER);
        setColumnCollapsed("productId", true);
        setColumnHeaders(ProductContainer.COL_HEADERS_ENGLISH);
        setColumnWidth("productId", 120);
    }
    
    private void createDataRow() {
        setContainerDataSource(products);
    }

}
