/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.listing;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.layout.content.CustomPanelLayout;
import com.pss.pp4is.layout.content.tables.InspectionProfileTable;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Nedzad
 */
public class MainContentInspectionProfileLayout extends CustomPanelLayout{

    public MainContentInspectionProfileLayout(LayoutController layoutController) {
        super(layoutController);
    }
    
    @Override
    public void initLayout() {
        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);
        
        layout.addComponent(new Label(getLayoutController().getI18n().translate("Inspection profile listing")));
        
        InspectionProfileTable inspectionProfileTable = new InspectionProfileTable(getLayoutController(),DataController.getInspectionProfiles());
        
        layout.addComponent(inspectionProfileTable);
        
        addComponent(layout);
    }
}