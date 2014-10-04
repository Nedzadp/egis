/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.tables;

import com.pss.pp4is.data.containers.ListingContainer;
import com.vaadin.ui.Table;
import com.vaadin.ui.themes.ValoTheme;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class ListingTable extends Table implements Serializable{

    private final ListingContainer listingContainer;
    
    public ListingTable(ListingContainer listingContainer) {
        this.listingContainer = listingContainer;
        initTable();
    }
    
    private void initTable() {
        addStyleName(ValoTheme.TABLE_BORDERLESS);
        addStyleName(ValoTheme.TABLE_NO_HEADER);
        addStyleName(ValoTheme.TABLE_NO_VERTICAL_LINES);
        addStyleName("custom-table");
        setColumnCollapsingAllowed(true);
        setColumnReorderingAllowed(true);
        setSelectable(true);
        setImmediate(true);
        setNullSelectionAllowed(false);
        createDataRow();
        setVisibleColumns(ListingContainer.NATURAL_COL_ORDER);
        setColumnHeaders(ListingContainer.COL_HEADERS_ENGLISH);
      
    }
    
    private void createDataRow() {
        setContainerDataSource(listingContainer);
    }
}