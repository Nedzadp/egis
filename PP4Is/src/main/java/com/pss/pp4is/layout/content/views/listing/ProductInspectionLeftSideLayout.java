/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.listing;

import com.pss.pp4is.data.models.NewProductListing;
import com.pss.pp4is.layout.content.views.listing.products.RightSideContentComponent;
import com.vaadin.event.LayoutEvents;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
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
public class ProductInspectionLeftSideLayout extends AbsoluteLayout{

    private final RightSideContentComponent rightSideContentComponent;
    private final List<NewProductListing> productListings;
    private List<ProductListLayout> components;
    
    public ProductInspectionLeftSideLayout(RightSideContentComponent rightSideContentComponent, List<NewProductListing> productListings) {
        this.rightSideContentComponent = rightSideContentComponent;
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
        AbsoluteLayout linesWithTitles = new AbsoluteLayout();
        linesWithTitles.setWidth("500");
        linesWithTitles.setHeight("140");
        linesWithTitles.addStyleName("lines-with-titles");
        VerticalLayout titles = new VerticalLayout();
        Label title1 = new Label("Certificates");
        title1.addStyleName("product-column-title");
        titles.addComponent(title1);
        Label title2 = new Label("Image analyses");
        title2.addStyleName("product-column-title");
        titles.addComponent(title2);
        Label title3 = new Label("Inspected images");
        title3.addStyleName("product-column-title");
        titles.addComponent(title3);
        
        Label title4 = new Label("Master images");
        title4.addStyleName("product-column-title");
        titles.addComponent(title4);
        Label title5 = new Label("Inspections");
        title5.addStyleName("product-column-title");
        titles.addComponent(title5);
        
        linesWithTitles.addComponent(titles);
        
        Image lines = new Image(null, new ThemeResource("img/lines-2.png"));
        linesWithTitles.addComponent(lines,"left:110px; top:12px");
        
        addComponent(linesWithTitles,"left:145px;");
        
        
        
        for(int i= 0; i<components.size();i++) {
            final ProductListLayout productListing = components.get(i);
            if(i == 0) {
                addComponent(productListing,"top: 135px;");
            } else {
                Integer margin = i*28+135;
                addComponent(productListing,"top:"+margin.toString()+"px");
            }
            productListing.addLayoutClickListener(new LayoutEvents.LayoutClickListener() {

                @Override
                public void layoutClick(LayoutEvents.LayoutClickEvent event) {
                   Float topMargin = getCurrentLayout().getPosition(productListing).getTopValue();
                }
            });
        }
       
        
    }
    
    private ProductInspectionLeftSideLayout getCurrentLayout() {
        return this;
    }
}
