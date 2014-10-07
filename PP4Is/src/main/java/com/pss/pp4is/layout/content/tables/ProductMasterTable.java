/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.tables;

import com.pss.pp4is.data.containers.ProductMasterContainer;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.Table;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class ProductMasterTable extends Table implements Serializable{

    private final LayoutController layoutController;
    private final ProductMasterContainer products;
    
    public ProductMasterTable(LayoutController layoutController, ProductMasterContainer products) {
        this.layoutController = layoutController;
        this.products = products;
        initTable();
    }
    
    private void initTable() {
       setColumnCollapsingAllowed(true);
        setColumnReorderingAllowed(true);
        setSelectable(true);
        setImmediate(true);
        setNullSelectionAllowed(false);
        setSizeFull();
        setPageLength(0);
        createDataRow();
        setVisibleColumns(ProductMasterContainer.NATURAL_COL_ORDER);
        setColumnCollapsed("masterId", true);
        setColumnCollapsed("leaflet", true);
        setColumnCollapsed("braille", true);
        setColumnCollapsed("falt", true);
        setColumnHeaders(products.getCOL_HEADERS_ENGLISH(layoutController));
        setColumnWidth("name", 270);
        setColumnWidth("type", 71);
        setColumnWidth("pdf", 75);
        setColumnWidth("active", 100);
        
    }
    
    private void createDataRow() {
        setContainerDataSource(products);
    }

}
