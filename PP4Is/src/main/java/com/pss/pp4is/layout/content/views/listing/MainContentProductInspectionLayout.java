/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.listing;

import com.pss.pp4is.data.models.Inspection;
import com.pss.pp4is.data.models.InspectionDetail;
import com.pss.pp4is.data.models.Product;
import com.pss.pp4is.data.models.ProductMaster;
import com.pss.pp4is.layout.content.CustomVerticalLayout;
import com.pss.pp4is.layout.content.LeftMainContentComponent;
import com.pss.pp4is.layout.content.RightMainContentComponent;
import com.vaadin.data.Property;
import com.vaadin.ui.HorizontalLayout;

/**
 *
 * @author Nedzad
 */
public class MainContentProductInspectionLayout extends CustomVerticalLayout{

    private Inspection selectedInspection=null;
    private ProductMaster selectedProductMaster = null;
    
    @Override
    public void initLayout() {
        setMargin(true);
        setSpacing(true);
        
        HorizontalLayout firstRowLayout = new HorizontalLayout();
        
        final LeftMainContentComponent leftMainContentComponent = new LeftMainContentComponent();
        leftMainContentComponent.initLayout();
        
        
        final RightMainContentComponent rightMainContentComponent = new RightMainContentComponent();      
        rightMainContentComponent.initLayout(getLayoutController().getI18n().translate("Product"));
        firstRowLayout.addComponent(rightMainContentComponent);
        firstRowLayout.addComponent(leftMainContentComponent);
        
        HorizontalLayout secondRowLayout = new HorizontalLayout();
        final LeftMainContentComponent leftMainContentComponentSecondRow = new LeftMainContentComponent();
        leftMainContentComponentSecondRow.initSecondLayout(getLayoutController().getI18n().translate("Master image detail"));
        
        
        
        final RightMainContentComponent rightMainContentComponentSecondRow = new RightMainContentComponent();      
        rightMainContentComponentSecondRow.initHeader(getLayoutController().getI18n().translate("Master"));
        secondRowLayout.addComponent(rightMainContentComponentSecondRow);
        secondRowLayout.addComponent(leftMainContentComponentSecondRow);
        
        
        HorizontalLayout thirdRowLayout = new HorizontalLayout();
        final RightMainContentComponent rightMainContentComponentThirddRow = new RightMainContentComponent();        
        rightMainContentComponentThirddRow.initHeader(getLayoutController().getI18n().translate("Inspection"));
        thirdRowLayout.addComponent(rightMainContentComponentThirddRow);
        
        HorizontalLayout fourthRowLayout = new HorizontalLayout();
        
        
        final RightMainContentComponent rightMainContentComponentFourthRow = new RightMainContentComponent();        
        rightMainContentComponentFourthRow.initHeader(getLayoutController().getI18n().translate("Inspection details"));
        final LeftMainContentComponent leftMainContentComponentFourthRow = new LeftMainContentComponent();
        leftMainContentComponentFourthRow.setWidth("260px");
        leftMainContentComponentFourthRow.initSecondLayout(getLayoutController().getI18n().translate("Inspection detail master image"));
        
        fourthRowLayout.addComponent(rightMainContentComponentFourthRow);
        fourthRowLayout.addComponent(leftMainContentComponentFourthRow);
        
        rightMainContentComponent.getProductTable().addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                Product product = (Product)rightMainContentComponent.getProductTable().getValue();
                // update product details
                leftMainContentComponent.getFormLayoutTop().updateLayout(product);
                // update master table
                rightMainContentComponentSecondRow.removeAllComponents();
                rightMainContentComponentSecondRow.initHeader(getLayoutController().getI18n().translate("Master"));
                rightMainContentComponentSecondRow.addTable(product);
                // clear inspection details
                rightMainContentComponentFourthRow.removeAllComponents();
                rightMainContentComponentFourthRow.initHeader(getLayoutController().getI18n().translate("Inspection details"));
                
                if(rightMainContentComponentSecondRow.getProductMasterTable()!=null){
                    rightMainContentComponentSecondRow.getProductMasterTable().addValueChangeListener(new Property.ValueChangeListener() {
                            @Override
                            public void valueChange(Property.ValueChangeEvent event) {
                                ProductMaster productMaster = (ProductMaster)rightMainContentComponentSecondRow.getProductMasterTable().getValue();
                                leftMainContentComponentSecondRow.getFormLayoutBottom().updateImage(productMaster.getPath());
                                selectedProductMaster = productMaster;
                                if(selectedInspection != null) {
                                    rightMainContentComponentFourthRow.removeAllComponents();
                                    rightMainContentComponentFourthRow.initHeader(getLayoutController().getI18n().translate("Inspection details"));
                                    rightMainContentComponentFourthRow.addInspectionDetailTable(productMaster,selectedInspection);
                                }
                            }
                        });
                }
                
                // update inspections
                rightMainContentComponentThirddRow.removeAllComponents();
                rightMainContentComponentThirddRow.initHeader(getLayoutController().getI18n().translate("Inspection"));
                rightMainContentComponentThirddRow.addInspectionTable(product);
                
                if(rightMainContentComponentThirddRow.getProductInspectionTable() != null) {
                    rightMainContentComponentThirddRow.getProductInspectionTable().addValueChangeListener(new Property.ValueChangeListener() {

                        @Override
                        public void valueChange(Property.ValueChangeEvent event) {
                           Inspection inspection = (Inspection)rightMainContentComponentThirddRow.getProductInspectionTable().getValue();
                           selectedInspection = inspection; 
                           if(selectedProductMaster != null) {
                               rightMainContentComponentFourthRow.removeAllComponents();
                                    rightMainContentComponentFourthRow.initHeader(getLayoutController().getI18n().translate("Inspection details"));
                                    rightMainContentComponentFourthRow.addInspectionDetailTable(inspection,selectedProductMaster);
                           }
                        }
                    });
                }
                
                
                if(rightMainContentComponentFourthRow.getInspectionDetailTable() != null) {
                    rightMainContentComponentFourthRow.getInspectionDetailTable().addValueChangeListener(new Property.ValueChangeListener() {

                        @Override
                        public void valueChange(Property.ValueChangeEvent event) {
                            InspectionDetail inspectionDetail = (InspectionDetail)rightMainContentComponentFourthRow.getInspectionDetailTable().getValue();
                            leftMainContentComponentFourthRow.getFormLayoutBottom().updateImage(inspectionDetail.getVizsgalt_feltoltve_path());
                        }
                    });
                }
            }
        });
        addComponent(firstRowLayout);
        addComponent(secondRowLayout);
        addComponent(thirdRowLayout);
        addComponent(fourthRowLayout);
        
    }
    
}
