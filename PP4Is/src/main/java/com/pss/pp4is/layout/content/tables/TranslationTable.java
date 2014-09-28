/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.tables;

import com.pss.pp4is.data.containers.TranslationContainer;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.Table;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class TranslationTable extends Table implements Serializable{

    private final TranslationContainer  translationContainer;  
    private final LayoutController layoutController;
    
    public TranslationTable(LayoutController layoutController,TranslationContainer translationContainer) {
        this.layoutController = layoutController;
        this.translationContainer = translationContainer;
        initTable();
    }
    
    private void initTable() {
        setColumnCollapsingAllowed(true);
        setColumnReorderingAllowed(true);
        setSelectable(false);
        setImmediate(true);
        setNullSelectionAllowed(false);
        setSizeFull();
        setPageLength(10);
        createDataRow();
        setVisibleColumns(TranslationContainer.NATURAL_COL_ORDER);
        setColumnHeaders(translationContainer.getCOL_HEADERS_ENGLISH(layoutController));
        setColumnWidth("keyword", 300);
    }
    
    private void createDataRow() {
        setContainerDataSource(translationContainer);
    }
}
