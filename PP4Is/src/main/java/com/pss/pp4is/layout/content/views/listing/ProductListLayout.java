/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.listing;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.data.models.NewProductListing;
import com.pss.pp4is.layout.content.views.listing.products.AnalyesComponent;
import com.pss.pp4is.layout.content.views.listing.products.CertificatesComponent;
import com.pss.pp4is.layout.content.views.listing.products.InspectedImagesComponent;
import com.pss.pp4is.layout.content.views.listing.products.InspectionComponent;
import com.pss.pp4is.layout.content.views.listing.products.MasterImageComponent;
import com.pss.pp4is.layout.content.views.listing.products.ProductNameComponent;
import com.vaadin.ui.HorizontalLayout;
import java.util.List;

/**
 *
 * @author Nedzad
 */
public class  ProductListLayout extends HorizontalLayout {

    private final NewProductListing productListing;
    private ProductNameComponent productNameComponent;
    private InspectionComponent inspectionComponent;
    private MasterImageComponent masterImageComponent;
    private InspectedImagesComponent inspectedImagesComponent;
    private AnalyesComponent analyesComponent;
    private CertificatesComponent certificatesComponent;
    
    public ProductListLayout(NewProductListing productListing) {
        this.productListing = productListing;
        addStyleName("product-list");
        initLayout();
    }
    
    private void initLayout() {
        
        
        addComponent(productNameComponent = new ProductNameComponent(productListing.getProductName()));
    
        addComponent(inspectionComponent = new InspectionComponent());
        inspectionComponent.initLayout(productListing.getInspections());
        
        addComponent(masterImageComponent = new MasterImageComponent());
        masterImageComponent.initLayout(productListing.getMasterImages());
        
        addComponent(inspectedImagesComponent = new InspectedImagesComponent());
        inspectedImagesComponent.initLayout(productListing.getInspectedImages(), productListing.getInspectedImagesColor());
        
        addComponent(analyesComponent = new AnalyesComponent());
        analyesComponent.initLayout(productListing.getAnalyses(), productListing.getAnalysesColor());
        
        addComponent(certificatesComponent = new CertificatesComponent());
        certificatesComponent.initLayout(productListing.getCertificates(), productListing.getCertificatesColor());
    }

    public InspectionComponent getInspectionComponent() {
        return inspectionComponent;
    }

    public MasterImageComponent getMasterImageComponent() {
        return masterImageComponent;
    }

    public InspectedImagesComponent getInspectedImagesComponent() {
        return inspectedImagesComponent;
    }

    public AnalyesComponent getAnalyesComponent() {
        return analyesComponent;
    }

    public CertificatesComponent getCertificatesComponent() {
        return certificatesComponent;
    }
    
    
    public NewProductListing getProductListing() {
        return productListing;
    }

    public ProductNameComponent getProductNameComponent() {
        return productNameComponent;
    }

    void recalculateData() {
        System.out.println("RECALCULATING");
        
        List<NewProductListing> listings = DataController.getProductsListing(this.getProductListing().getProductId());
        NewProductListing one = listings.get(0);
        
        getInspectionComponent().removeAllComponents();
        getInspectionComponent().initLayout(one.getInspections());
        
        getMasterImageComponent().removeAllComponents();
        getMasterImageComponent().initLayout(one.getMasterImages());
        
        getInspectedImagesComponent().removeAllComponents();
        getInspectedImagesComponent().initLayout(one.getInspectedImages(), one.getInspectedImagesColor());
        
        getAnalyesComponent().removeAllComponents();
        getAnalyesComponent().initLayout(one.getAnalyses(), one.getAnalysesColor());
        
        getCertificatesComponent().removeAllComponents();
        getCertificatesComponent().initLayout(one.getCertificates(), one.getCertificatesColor());
    }
}
