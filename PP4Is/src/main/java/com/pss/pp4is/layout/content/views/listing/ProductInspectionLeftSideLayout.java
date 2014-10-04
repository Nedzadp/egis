/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.listing;

import com.pss.pp4is.data.models.NewProductListing;
import com.vaadin.ui.AbsoluteLayout;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nedzad
 */
public class ProductInspectionLeftSideLayout extends AbsoluteLayout{

    private final List<NewProductListing> productListings;
    private List<ProductListLayout> components;
    
    public ProductInspectionLeftSideLayout(List<NewProductListing> productListings) {
        this.productListings = productListings;
        initLayout();
    }
    
    private void initLayout() {
        setWidth("550");
        setHeight("800");
        
        components = new ArrayList<ProductListLayout>();
        
        for (NewProductListing productListing : productListings) {
            components.add(new ProductListLayout(productListing));
        }
        
        for(int i= 0; i<components.size();i++) {
            if(i == 0) {
                addComponent(components.get(i));
            } else {
                Integer margin = i*28;
                addComponent(components.get(i),"top:"+margin.toString()+"px");
            }
        }
       
        
    }
    
}
