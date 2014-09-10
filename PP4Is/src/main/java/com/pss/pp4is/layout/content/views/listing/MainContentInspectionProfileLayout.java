/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.listing;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.layout.content.CustomVerticalLayout;
import com.pss.pp4is.layout.content.tables.InspectionProfileTable;
import com.vaadin.ui.Label;

/**
 *
 * @author Nedzad
 */
public class MainContentInspectionProfileLayout extends CustomVerticalLayout{

    public MainContentInspectionProfileLayout() {
        initLayout();
    }
    
    private void initLayout() {
        setMargin(true);
        setSpacing(true);
        
        addComponent(new Label("Inspection profile listing"));
        
        InspectionProfileTable inspectionProfileTable = new InspectionProfileTable(DataController.getInspectionProfiles());
        
        addComponent(inspectionProfileTable);
        
    }
}