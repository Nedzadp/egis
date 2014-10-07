/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.listing;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.layout.content.CustomPanelLayout;
import com.pss.pp4is.layout.content.views.listing.products.RightSideAbsoluteContentComponent;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Nedzad
 */
public class MainContentNewProductInspectionLayout extends CustomPanelLayout{

    public MainContentNewProductInspectionLayout(LayoutController layoutController) {
        super(layoutController);
        
    }

    @Override
    public void initLayout() {
        addStyleName("main-container");
        VerticalLayout layout = new VerticalLayout();
        layout.setSpacing(true);
        
        layout.addComponent(new Label(getLayoutController().getI18n().translate("Product and inspection listing")));
        
        
        HorizontalLayout horizontalLayout = new HorizontalLayout();
       
        RightSideAbsoluteContentComponent rightSideContentComponent = new RightSideAbsoluteContentComponent();
        ProductInspectionLeftSideLayout leftSideLayout = new ProductInspectionLeftSideLayout(getLayoutController(),rightSideContentComponent, DataController.getProductsListing(null));
        
        
        horizontalLayout.addComponent(leftSideLayout);
        horizontalLayout.addComponent(rightSideContentComponent);
        
        layout.addComponent(horizontalLayout);
        
        addComponent(layout);
    }
    
}
