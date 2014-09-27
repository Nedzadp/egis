/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.data.containers.InspectionContainer;
import com.pss.pp4is.data.containers.InspectionDetailContainer;
import com.pss.pp4is.data.containers.ProductMasterContainer;
import com.pss.pp4is.data.models.Inspection;
import com.pss.pp4is.data.models.Product;
import com.pss.pp4is.data.models.ProductMaster;
import com.pss.pp4is.layout.content.tables.InspectionDetailTable;
import com.pss.pp4is.layout.content.tables.ProductInspectionTable;
import com.pss.pp4is.layout.content.tables.ProductMasterTable;
import com.pss.pp4is.layout.content.tables.ProductTable;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Nedzad
 */
public class RightMainContentComponent extends  VerticalLayout{

    private ProductTable productTable;
    private ProductMasterTable productMasterTable;
    private ProductInspectionTable productInspectionTable;
    private InspectionDetailTable inspectionDetailTable;
    private LayoutController layoutController;
    
    public RightMainContentComponent(LayoutController layoutController) {
        this.layoutController = layoutController;
        setWidth("620px");
        addStyleName("right-panel");
    }
    public void initLayout(String headerString) {
        
        initHeader(headerString);
        
        productTable = new ProductTable(DataController.getProducts());
        addComponent(productTable);
    }

    public void initHeader(String headerString) {
        Label header = new Label(headerString);
        header.addStyleName("header-text");
        addComponent(header);
        
        HorizontalLayout mainHorizontalLine = new HorizontalLayout();
        mainHorizontalLine.setHeight("3px");
        mainHorizontalLine.addStyleName("text-hrline-right");
        addComponent(mainHorizontalLine);
    }
    
    public void addTable(Product product) {
        ProductMasterContainer container = DataController.getProductMaster(product);
        if(container != null){
            productMasterTable = new ProductMasterTable(container);
            addComponent(productMasterTable);
        }
    }
    
    public ProductTable getProductTable() {
        return productTable;
    }

    public ProductMasterTable getProductMasterTable() {
        return productMasterTable;
    }

    public void addInspectionTable(Product product) {
        InspectionContainer inspectionContainer = DataController.getProductInspections(product.getProductId());
        if(inspectionContainer != null) {
            productInspectionTable = new ProductInspectionTable(inspectionContainer);
            addComponent(productInspectionTable);
        }
    }

    public ProductInspectionTable getProductInspectionTable() {
        return productInspectionTable;
    }

    public void addInspectionDetailTable(Inspection inspection, ProductMaster productMaster) {
        InspectionDetailContainer  inspectionDetailContainer = DataController.getInspectionDetails(inspection.getInspectionId(),productMaster.getMasterId());
        if(inspectionDetailContainer != null) {
            inspectionDetailTable = new InspectionDetailTable(layoutController,inspectionDetailContainer);
            addComponent(inspectionDetailTable);
        }
    }

    public InspectionDetailTable getInspectionDetailTable() {
        return inspectionDetailTable;
    }

    public void addInspectionDetailTable(Product product) {
         InspectionDetailContainer  inspectionDetailContainer = DataController.getInspectionDetailsByProduct(product.getProductId());
        if(inspectionDetailContainer != null) {
            inspectionDetailTable = new InspectionDetailTable(layoutController,inspectionDetailContainer);
            addComponent(inspectionDetailTable);
        }
    }
    
    public void addInspectionDetailTable(ProductMaster productMaster, Inspection inspection) {
        InspectionDetailContainer  inspectionDetailContainer = DataController.getInspectionDetailsByMaster(productMaster.getMasterId(),inspection.getInspectionId());
        if(inspectionDetailContainer != null) {
            inspectionDetailTable = new InspectionDetailTable(layoutController,inspectionDetailContainer);
            addComponent(inspectionDetailTable);
        }
    }

    public void addInspectionTable(ProductMaster productMaster) {
        InspectionContainer inspectionContainer = DataController.getProductInspectionsByMaster(productMaster.getMasterId());
        if(inspectionContainer != null) {
            productInspectionTable = new ProductInspectionTable(inspectionContainer);
            addComponent(productInspectionTable);
        }
    }
}
