/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.listing.products;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;

/**
 *
 * @author Nedzad
 */
public class InspectedImagesComponent extends HorizontalLayout{

    
    public void initLayout(Integer inspectedImages,String color) {
        if(inspectedImages.equals(0)) {
            addStyleName("inspected-listing-container-empty");
            HorizontalLayout layout = new HorizontalLayout();
            layout.addStyleName("inspected-listing-empty");

            Image image = new Image(null, new ThemeResource("img/empty.png"));
            image.addStyleName("inspected-empty-data");
            layout.addComponent(image);

            ImageComponent imageComponent = new ImageComponent("arrow3.png", "4");
            addComponent(layout);
            addComponent(imageComponent);
        } else if(!inspectedImages.equals(0) && color.equals("blue")) {
            addStyleName("inspected-listing-container");
            HorizontalLayout layout = new HorizontalLayout();
            layout.addStyleName("inspected-listing");

            Label number = new Label(inspectedImages.toString());
            number.addStyleName("listing-label");
            addComponent(number);

            ImageComponent imageComponent = new ImageComponent("arrow-blue5.png", "4");
            addComponent(layout);
            addComponent(imageComponent);
        } else if(!inspectedImages.equals(0) && color.equals("pink")) {
            addStyleName("inspected-listing-container-pink");
            HorizontalLayout layout = new HorizontalLayout();
            layout.addStyleName("inspected-listing-pink");

            Label number = new Label(inspectedImages.toString());
            number.addStyleName("listing-label");
            addComponent(number);

            ImageComponent imageComponent = new ImageComponent("arrow-pink.png", "4");
            addComponent(layout);
            addComponent(imageComponent);
        }
    }
}
