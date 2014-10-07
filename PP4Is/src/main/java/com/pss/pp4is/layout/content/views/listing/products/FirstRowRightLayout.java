/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.listing.products;

import com.pss.pp4is.data.models.NewProductListing;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.HorizontalLayout;

/**
 *
 * @author Nedzad
 */
public class FirstRowRightLayout extends HorizontalLayout{

    private final LayoutController layoutController;
    private final NewProductListing productListing;
    private InspectionDetailLayout inspectionDetailLayout;
    
    public FirstRowRightLayout(LayoutController layoutController, NewProductListing productListing) {
        this.layoutController = layoutController;
        this.productListing = productListing;
        initLayout();
    }
    
    private void initLayout() {
        ProductDetailLayout productDetailLayout = new ProductDetailLayout(layoutController,productListing);
        addComponent(productDetailLayout);
        
        inspectionDetailLayout = new InspectionDetailLayout(layoutController,productListing);
        addComponent(inspectionDetailLayout);
    }

    public InspectionDetailLayout getInspectionDetailLayout() {
        return inspectionDetailLayout;
    }

}
