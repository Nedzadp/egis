/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views;

import com.pss.pp4is.data.models.Product;
import com.pss.pp4is.data.models.ProductMaster;
import com.pss.pp4is.layout.content.CustomVerticalLayout;
import com.pss.pp4is.layout.content.LeftMainContentComponent;
import com.pss.pp4is.layout.content.RightMainContentComponent;
import com.vaadin.data.Property;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.HorizontalLayout;


/**
 *
 * @author Nedzad
 */
public class MainContentHomeLayout extends CustomVerticalLayout{

    public MainContentHomeLayout() {
        initLayout();
    }
    
    private void initLayout() {
        setMargin(false);
        setSpacing(false);
        
        addComponent(new CustomLayout("welcome"));
        
        HorizontalLayout firstRowLayout = new HorizontalLayout();
        
        final LeftMainContentComponent leftMainContentComponent = new LeftMainContentComponent();
        leftMainContentComponent.initLayout();
        
        
        final RightMainContentComponent rightMainContentComponent = new RightMainContentComponent();      
        rightMainContentComponent.initLayout("Product");
        firstRowLayout.addComponent(rightMainContentComponent);
        firstRowLayout.addComponent(leftMainContentComponent);
        
        HorizontalLayout secondRowLayout = new HorizontalLayout();
        final LeftMainContentComponent leftMainContentComponentSecondRow = new LeftMainContentComponent();
        leftMainContentComponentSecondRow.initSecondLayout();
        
        
        
        final RightMainContentComponent rightMainContentComponentSecondRow = new RightMainContentComponent();      
        rightMainContentComponentSecondRow.initHeader("Master");
        secondRowLayout.addComponent(rightMainContentComponentSecondRow);
        secondRowLayout.addComponent(leftMainContentComponentSecondRow);
        
        rightMainContentComponent.getProductTable().addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                Product product = (Product)rightMainContentComponent.getProductTable().getValue();
                leftMainContentComponent.getFormLayoutTop().updateLayout(product);
                
                rightMainContentComponentSecondRow.removeAllComponents();
                rightMainContentComponentSecondRow.initHeader("Master");
                rightMainContentComponentSecondRow.addTable(product);
                if(rightMainContentComponentSecondRow.getProductMasterTable()!=null){
                    rightMainContentComponentSecondRow.getProductMasterTable().addValueChangeListener(new Property.ValueChangeListener() {
                            @Override
                            public void valueChange(Property.ValueChangeEvent event) {
                                ProductMaster productMaster = (ProductMaster)rightMainContentComponentSecondRow.getProductMasterTable().getValue();
                                leftMainContentComponentSecondRow.getFormLayoutBottom().updateImage(productMaster);
                            }
                        });
                }

            }
        });
               
        //addComponent(firstRowLayout);
        //addComponent(secondRowLayout);
        
    }
}
