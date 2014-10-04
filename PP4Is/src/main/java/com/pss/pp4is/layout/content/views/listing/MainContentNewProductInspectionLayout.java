/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.listing;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.data.models.NewProductListing;
import com.pss.pp4is.layout.content.CustomPanelLayout;
import com.pss.pp4is.layout.content.views.listing.products.RightSideContentComponent;
import com.pss.pp4is.layout.content.views.reports.HorizontalFilter;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.List;

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
        HorizontalLayout horizontalLayout = new HorizontalLayout();
       //DataController.getProductsListing()
        List<NewProductListing> listings = new ArrayList<NewProductListing>();
        
        NewProductListing listing1 = new NewProductListing();
        listing1.setProductId(1);
        listing1.setProductName("Product one");
        listing1.setInspections(2);
        listing1.setMasterImages(2);
        listing1.setInspectedImages(2);
        listing1.setInspectedImagesColor("blue");
        listing1.setAnalyses(1);
        listing1.setAnalysesColor("pink");
        listing1.setCertificates(1);
        listing1.setCertificatesColor("pink");
        
        NewProductListing listing2 = new NewProductListing();
        listing2.setProductId(1);
        listing2.setProductName("Product two");
        listing2.setInspections(2);
        listing2.setMasterImages(1);
        listing2.setInspectedImages(1);
        listing2.setInspectedImagesColor("pink");
        listing2.setAnalyses(0);
        listing2.setAnalysesColor(null);
        listing2.setCertificates(0);
        listing2.setCertificatesColor(null);
        
        NewProductListing listing3 = new NewProductListing();
        listing3.setProductId(1);
        listing3.setProductName("Product three");
        listing3.setInspections(2);
        listing3.setMasterImages(2);
        listing3.setInspectedImages(2);
        listing3.setInspectedImagesColor("blue");
        listing3.setAnalyses(2);
        listing3.setAnalysesColor("green");
        listing3.setCertificates(2);
        listing3.setCertificatesColor("green");
        
        listings.add(listing1);
        listings.add(listing2);
        listings.add(listing3);
        RightSideContentComponent rightSideContentComponent = new RightSideContentComponent();
        ProductInspectionLeftSideLayout leftSideLayout = new ProductInspectionLeftSideLayout(rightSideContentComponent, listings);
        
        
        
        
        
        horizontalLayout.addComponent(leftSideLayout);
        horizontalLayout.addComponent(rightSideContentComponent);
        
        addComponent(horizontalLayout);
    }
    
}
