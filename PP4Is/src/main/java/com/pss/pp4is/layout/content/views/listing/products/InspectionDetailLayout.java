/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.listing.products;

import com.pss.pp4is.data.models.Inspection;
import com.pss.pp4is.data.models.NewProductListing;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Nedzad
 */
public class InspectionDetailLayout extends VerticalLayout{

    private final LayoutController layoutController;
    private final NewProductListing productListing;
    private Label inspectorLabel;
    private Label starDateLabel;
    private Label endDateLabel;
    private Label articleNumberLabel;
    private Label diaryNumberLabel;
    private Label bagNumberLabel;
    private Label stateLabel;
    private Label idLabel;
    
    public InspectionDetailLayout(LayoutController layoutController,NewProductListing productListing) {
        this.layoutController = layoutController;
        this.productListing = productListing;
        initLayout();
    }
    
    private void initLayout() {
       addStyleName("inspection-detail-layout");
       
       HorizontalLayout headerLayout = new HorizontalLayout();
       headerLayout.addStyleName("inspection-detail-header-layout");
       Label headerText = new Label(layoutController.getI18n().translate("Inspection details"));
       headerText.addStyleName("header-label");
       headerLayout.addComponent(headerText);
       
       VerticalLayout dataLayout = new VerticalLayout();
       dataLayout.addStyleName("data-layout");
       
       dataLayout.addComponent(new DataLabelLayout(new Label(layoutController.getI18n().translate("Inspector: ")), inspectorLabel = new Label("-")));
       dataLayout.addComponent(new DataLabelLayout(new Label(layoutController.getI18n().translate("Start date: ")),starDateLabel = new Label("-")));
       dataLayout.addComponent(new DataLabelLayout(new Label(layoutController.getI18n().translate("End date: ")), endDateLabel = new Label("-")));
       dataLayout.addComponent(new DataLabelLayout(new Label(layoutController.getI18n().translate("Article number: ")),articleNumberLabel = new Label("-")));
       dataLayout.addComponent(new DataLabelLayout(new Label(layoutController.getI18n().translate("Diary number: ")), diaryNumberLabel = new Label("-")));
       dataLayout.addComponent(new DataLabelLayout(new Label(layoutController.getI18n().translate("Bag number: ")), bagNumberLabel = new Label("-")));
       dataLayout.addComponent(new DataLabelLayout(new Label(layoutController.getI18n().translate("State: ")), stateLabel = new Label("-")));
       dataLayout.addComponent(new DataLabelLayout(new Label(layoutController.getI18n().translate("ID: ")), idLabel = new Label("-")));
       
       
       addComponent(headerLayout);
       addComponent(dataLayout);
       
       
    }

    void refreshLayout(Inspection inspection) {
       inspectorLabel.setValue(inspection.getInspector());
       starDateLabel.setValue(inspection.getInspectionDate());
       articleNumberLabel.setValue(inspection.getCikkNum());
       diaryNumberLabel.setValue(inspection.getNaploNum());
       bagNumberLabel.setValue(inspection.getTaskaNum());
       stateLabel.setValue(inspection.getClosed().equals("X")?layoutController.getI18n().translate("Closed"):layoutController.getI18n().translate("Open"));
       idLabel.setValue(inspection.getInspectionId().toString());
    }
}

