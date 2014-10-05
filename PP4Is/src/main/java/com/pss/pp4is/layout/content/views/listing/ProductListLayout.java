/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.listing;

import com.pss.pp4is.data.models.NewProductListing;
import com.pss.pp4is.layout.content.views.listing.products.AnalyesComponent;
import com.pss.pp4is.layout.content.views.listing.products.CertificatesComponent;
import com.pss.pp4is.layout.content.views.listing.products.InspectedImagesComponent;
import com.pss.pp4is.layout.content.views.listing.products.InspectionComponent;
import com.pss.pp4is.layout.content.views.listing.products.MasterImageComponent;
import com.pss.pp4is.layout.content.views.listing.products.ProductNameComponent;
import com.vaadin.ui.HorizontalLayout;

/**
 *
 * @author Nedzad
 */
public class  ProductListLayout extends HorizontalLayout {

    private final NewProductListing productListing;
    private ProductNameComponent productNameComponent;
    
    public ProductListLayout(NewProductListing productListing) {
        this.productListing = productListing;
        initLayout();
        
    }
    
    private void initLayout() {
        addStyleName("product-list");
        
        addComponent(productNameComponent = new ProductNameComponent(productListing.getProductName()));
        
        addComponent(new InspectionComponent(productListing.getInspections()));
        
        addComponent(new MasterImageComponent(productListing.getMasterImages()));
        
        addComponent(new InspectedImagesComponent(productListing.getInspectedImages(), productListing.getInspectedImagesColor()));
       
        addComponent(new AnalyesComponent(productListing.getAnalyses(), productListing.getAnalysesColor()));
        
        addComponent(new CertificatesComponent(productListing.getCertificates(), productListing.getCertificatesColor()));
    }

    public NewProductListing getProductListing() {
        return productListing;
    }

    public ProductNameComponent getProductNameComponent() {
        return productNameComponent;
    }
}
