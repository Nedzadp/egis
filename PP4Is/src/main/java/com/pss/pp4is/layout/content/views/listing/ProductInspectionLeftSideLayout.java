/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.listing;

import com.pss.pp4is.data.models.NewProductListing;
import com.pss.pp4is.layout.content.views.listing.products.RightSideAbsoluteContentComponent;
import com.pss.pp4is.layout.content.views.listing.products.RightSideContentLayout;
import com.pss.pp4is.system.LayoutController;
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

    private final LayoutController layoutController;
    private final RightSideAbsoluteContentComponent rightSideContentComponent;
    private final List<NewProductListing> productListings;
    private List<ProductListLayout> components;
    private ProductListLayout selected;
    
    public ProductInspectionLeftSideLayout(LayoutController layoutController,RightSideAbsoluteContentComponent rightSideContentComponent, List<NewProductListing> productListings) {
        this.layoutController = layoutController;
        this.rightSideContentComponent = rightSideContentComponent;
        this.productListings = productListings;
        initLayout();
    }
    
    private void initLayout() {
        setWidth("520");
        setHeight("800");
        
        components = new ArrayList<ProductListLayout>();
        
        for (NewProductListing productListing : productListings) {
            components.add(new ProductListLayout(productListing));
        }
        HorizontalLayout linesWithTitles = new HorizontalLayout();
       
        linesWithTitles.addStyleName("lines-with-titles");
        AbsoluteLayout titles = new AbsoluteLayout();
        titles.setWidth("150");
        titles.addStyleName("product-column-titles");
        
        Label title1 = new Label(layoutController.getI18n().translate("Certificates"));
        title1.addStyleName("product-column-title");
        title1.setWidth("150px");
        
        titles.addComponent(title1);
        
        Label title2 = new Label(layoutController.getI18n().translate("Image analyses"));
        title2.addStyleName("product-column-title");
        title2.setWidth("150px");
        
        titles.addComponent(title2,"top:15px");
        
        Label title3 = new Label(layoutController.getI18n().translate("Inspected images"));
        title3.addStyleName("product-column-title");
        title3.setWidth("150px");
        
        titles.addComponent(title3,"top:30px");
        
        Label title4 = new Label(layoutController.getI18n().translate("Master images"));
        title4.addStyleName("product-column-title");
        title4.setWidth("150px");
        
        titles.addComponent(title4,"top:45px");
        
        Label title5 = new Label(layoutController.getI18n().translate("Inspections"));
        title5.addStyleName("product-column-title");
        title5.setWidth("150px");
        
        titles.addComponent(title5,"top:60px");
        
        linesWithTitles.addComponent(titles);
        
        Image lines = new Image(null, new ThemeResource("img/column-lines6.png"));
        lines.addStyleName("line-image");
        linesWithTitles.addComponent(lines);
        
        addComponent(linesWithTitles,"left:103px;top:50px");
        
        Label productLabel = new Label(layoutController.getI18n().translate("Products"));
        productLabel.addStyleName("product-name-label-header");
        
        addComponent(productLabel,"top:125px;");
        
        for(int i= 0; i<components.size();i++) {
            final ProductListLayout productListing = components.get(i);
            if(i == 0) {
                addComponent(productListing,"top: 150px;");
            } else {
                Integer margin = i*30+150;
                addComponent(productListing,"top:"+margin.toString()+"px");
            }
            productListing.addLayoutClickListener(new LayoutEvents.LayoutClickListener() {

                @Override
                public void layoutClick(LayoutEvents.LayoutClickEvent event) {
                    productListing.recalculateData();
                    //css correction
                    if(selected != null && selected == productListing) {
                        rightSideContentComponent.removeAllComponents();
                        selected.removeStyleName("product-list-selected");
                        selected.addStyleName("product-list");
                        selected.getProductNameComponent().getImageLabel().removeStyleName("product-name-image-label-selected");
                        selected.getProductNameComponent().getImageLabel().addStyleName("product-name-image-label");
                        selected = null;
                        return;
                    }
                    
                    if(selected != null) {
                        selected.removeStyleName("product-list-selected");
                        selected.addStyleName("product-list");
                        selected.getProductNameComponent().getImageLabel().removeStyleName("product-name-image-label-selected");
                        selected.getProductNameComponent().getImageLabel().addStyleName("product-name-image-label");
                    }
                    
                    
                    productListing.removeStyleName("product-list");
                    productListing.addStyleName("product-list-selected");
                    productListing.getProductNameComponent().getImageLabel().removeStyleName("product-name-image-label");
                    productListing.getProductNameComponent().getImageLabel().addStyleName("product-name-image-label-selected");
                    //
                    
                    Float topMargin = getCurrentLayout().getPosition(productListing).getTopValue()-150;
                    RightSideContentLayout contentLayout = new RightSideContentLayout(layoutController , productListing.getProductListing());
                    rightSideContentComponent.removeAllComponents();
                    rightSideContentComponent.addComponent(contentLayout,"top: "+topMargin.toString()+"px;");
                    
                    selected = productListing;
                }
            });
        }
       
        
    }
    
    private ProductInspectionLeftSideLayout getCurrentLayout() {
        return this;
    }
}
