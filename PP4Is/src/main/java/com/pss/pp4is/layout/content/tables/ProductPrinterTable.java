/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.tables;

import com.pss.pp4is.data.containers.ProductPrinterContainer;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.Table;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class ProductPrinterTable extends Table implements Serializable{

    private final ProductPrinterContainer productPrinterContainer;
    private final LayoutController layoutController;
    
    public ProductPrinterTable(LayoutController layoutController,ProductPrinterContainer productPrinterContainer) {
        this.layoutController = layoutController;
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
        setColumnHeaders(productPrinterContainer.getCOL_HEADERS_ENGLISH(layoutController));
        setColumnWidth("productPrinterId", 110);
    }
    
    private void createDataRow() {
        setContainerDataSource(productPrinterContainer);
    }
}
