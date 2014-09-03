/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.data.containers.ProductMasterContainer;
import com.pss.pp4is.data.models.Product;
import com.pss.pp4is.layout.content.tables.ProductMasterTable;
import com.pss.pp4is.layout.content.tables.ProductTable;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Nedzad
 */
public class RightMainContentComponent extends  VerticalLayout{

    private ProductTable productTable;
    private ProductMasterTable productMasterTable;
    private DataController dataController;
    
    public RightMainContentComponent() {
        dataController = new DataController();
        addStyleName("right-panel");
    }
    public void initLayout(String headerString) {
        
        initHeader(headerString);
        
        productTable = new ProductTable(dataController.getProducts());
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
        ProductMasterContainer container = dataController.getProductMaster(product);
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

    public DataController getDataController() {
        return dataController;
    }
}
