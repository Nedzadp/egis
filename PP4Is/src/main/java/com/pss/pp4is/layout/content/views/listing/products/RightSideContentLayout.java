/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.listing.products;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.data.containers.InspectionContainer;
import com.pss.pp4is.data.containers.InspectionDetailContainer;
import com.pss.pp4is.data.containers.ProductMasterContainer;
import com.pss.pp4is.data.models.Inspection;
import com.pss.pp4is.data.models.InspectionDetail;
import com.pss.pp4is.data.models.NewProductListing;
import com.pss.pp4is.data.models.ProductMaster;
import com.pss.pp4is.layout.content.tables.InspectionDetailTable;
import com.pss.pp4is.layout.content.tables.ProductInspectionTable;
import com.pss.pp4is.layout.content.tables.ProductMasterTable;
import com.pss.pp4is.layout.content.window.ExitWindow;
import com.pss.pp4is.layout.content.window.ImageWindow;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.data.Property;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 *
 * @author Nedzad
 */
public class RightSideContentLayout extends VerticalLayout {
    
    
    private final LayoutController layoutController;
    private final NewProductListing productListing;
    private ProductInspectionTable productInspectionTable;
    private ProductMasterTable productMasterTable;
    private FirstRowRightLayout productDetailLayout;
    private InspectionDetailTable inspectionDetailTable;
    
    private Inspection selectedInspection=null;
    private ProductMaster selectedProductMaster = null;
    
    public RightSideContentLayout(LayoutController layoutController,NewProductListing productListing) {
        this.layoutController = layoutController;
        this.productListing = productListing;
        initLayout();
    }
    
    private void initLayout() {
        productDetailLayout = new FirstRowRightLayout(layoutController,productListing);
        addComponent(productDetailLayout);
        
        InspectionContainer inspectionContainer = DataController.getProductInspections(productListing.getProductId());
        if(inspectionContainer != null) {
            productInspectionTable = new ProductInspectionTable(layoutController,inspectionContainer);
            productInspectionTable.setStyleName("inspection-table");
            productInspectionTable.addStyleName(ValoTheme.TABLE_NO_HORIZONTAL_LINES);
            productInspectionTable.addStyleName(ValoTheme.TABLE_NO_VERTICAL_LINES);
            productInspectionTable.addStyleName(ValoTheme.TABLE_NO_STRIPES);
            addComponent(productInspectionTable);
            productInspectionTable.addValueChangeListener(new Property.ValueChangeListener() {
                @Override
                public void valueChange(Property.ValueChangeEvent event) {
                    Inspection inspection = (Inspection)productInspectionTable.getValue();
                    productDetailLayout.getInspectionDetailLayout().refreshLayout(inspection);
                    selectedInspection = inspection;
                    if(selectedProductMaster != null) {
                        addInspectionDetailTable(inspection);
                    }
                }
            });
        }
        
        ProductMasterContainer container = DataController.getProductMaster(layoutController,productListing.getProductId());
        if(container != null){
            productMasterTable = new ProductMasterTable(layoutController,container);
            productMasterTable.setStyleName("master-table");
            productMasterTable.addStyleName(ValoTheme.TABLE_NO_HORIZONTAL_LINES);
            productMasterTable.addStyleName(ValoTheme.TABLE_NO_VERTICAL_LINES);
            productMasterTable.addStyleName(ValoTheme.TABLE_NO_STRIPES);
            addComponent(productMasterTable);
            
            productMasterTable.addValueChangeListener(new Property.ValueChangeListener() {
                @Override
                public void valueChange(Property.ValueChangeEvent event) {
                    ProductMaster productMaster = (ProductMaster)productMasterTable.getValue();
                    selectedProductMaster = productMaster;
                    if(selectedInspection != null) {
                        addInspectionDetailTable(productMaster);
                    }
                }
            });
            productMasterTable.addItemClickListener(new ItemClickEvent.ItemClickListener() {

                @Override
                public void itemClick(ItemClickEvent event) {
                    
                    if(event.isDoubleClick()) {
                        String path = event.getItem().getItemProperty("path").getValue().toString();
                        System.out.println(path);
                        UI.getCurrent().addWindow(new ImageWindow(layoutController,path));
                    }
                }
            });
        }
    }
    
    private void addInspectionDetailTable(ProductMaster productMaster) {
        InspectionDetailContainer  inspectionDetailContainer = DataController.getInspectionDetailsByMaster(layoutController,productMaster.getMasterId(),selectedInspection.getInspectionId());
        if(inspectionDetailContainer != null) {
            if(inspectionDetailTable==null) {
                inspectionDetailTable = new InspectionDetailTable(layoutController,inspectionDetailContainer);
                inspectionDetailTable.setStyleName("inspection-detail-table");
                inspectionDetailTable.addStyleName(ValoTheme.TABLE_NO_HORIZONTAL_LINES);
                inspectionDetailTable.addStyleName(ValoTheme.TABLE_NO_VERTICAL_LINES);
                inspectionDetailTable.addStyleName(ValoTheme.TABLE_NO_STRIPES);
                addComponent(inspectionDetailTable);
                inspectionDetailTable.addItemClickListener(new ItemClickEvent.ItemClickListener() {

                    @Override
                    public void itemClick(ItemClickEvent event) {
                       if(event.isDoubleClick()) { 
                        String path = event.getItem().getItemProperty("vizsgalt_feltoltve_path").getValue().toString();
                        System.out.println(path);
                        UI.getCurrent().addWindow(new ImageWindow(layoutController, path));
                       }
                    }
                });
                    
            } else {
                inspectionDetailTable.refreshTable(inspectionDetailContainer);
            }
        }
    }
    
    private void addInspectionDetailTable(Inspection inspection) {
        productMasterTable.removeStyleName("master-table");
        productMasterTable.setStyleName("master-table2");
        productMasterTable.addStyleName(ValoTheme.TABLE_NO_HORIZONTAL_LINES);
        productMasterTable.addStyleName(ValoTheme.TABLE_NO_VERTICAL_LINES);
        productMasterTable.addStyleName(ValoTheme.TABLE_NO_STRIPES);
        InspectionDetailContainer  inspectionDetailContainer = DataController.getInspectionDetailsByMaster(layoutController,selectedProductMaster.getMasterId(),inspection.getInspectionId());
        if(inspectionDetailContainer != null) {
            if(inspectionDetailTable==null) {
                inspectionDetailTable = new InspectionDetailTable(layoutController,inspectionDetailContainer);
                inspectionDetailTable.setStyleName("inspection-detail-table");
                inspectionDetailTable.addStyleName(ValoTheme.TABLE_NO_HORIZONTAL_LINES);
                inspectionDetailTable.addStyleName(ValoTheme.TABLE_NO_VERTICAL_LINES);
                inspectionDetailTable.addStyleName(ValoTheme.TABLE_NO_STRIPES);
                addComponent(inspectionDetailTable);
                inspectionDetailTable.addItemClickListener(new ItemClickEvent.ItemClickListener() {

                    @Override
                    public void itemClick(ItemClickEvent event) {
                      if(event.isDoubleClick()) { 
                        String path = event.getItem().getItemProperty("vizsgalt_feltoltve_path").getValue().toString();
                        System.out.println(path);
                        UI.getCurrent().addWindow(new ImageWindow(layoutController, path));
                       }
                    }
                });
            } else {
                inspectionDetailTable.refreshTable(inspectionDetailContainer);
                
            }
        }
    }
    
    
}
