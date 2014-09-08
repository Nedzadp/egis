/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.tables;

import com.pss.pp4is.data.containers.ProductPrinterContainer;
import com.pss.pp4is.data.containers.ProductTypeContainer;
import com.vaadin.ui.Table;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class ProductPrinterTable extends Table implements Serializable{

    private final ProductPrinterContainer productPrinterContainer;
    
    public ProductPrinterTable(ProductPrinterContainer productPrinterContainer) {
        this.productPrinterContainer = productPrinterContainer;
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
        setVisibleColumns(ProductPrinterContainer.NATURAL_COL_ORDER);
        setColumnCollapsed("productPrinterId", true);
        setColumnHeaders(ProductPrinterContainer.COL_HEADERS_ENGLISH);
    }
    
    private void createDataRow() {
        setContainerDataSource(productPrinterContainer);
    }
}
