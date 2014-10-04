/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.listing.products;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;

/**
 *
 * @author Nedzad
 */
public class InspectionComponent extends HorizontalLayout{

    private final Integer inspections;
    
    public InspectionComponent(Integer inspections) {
        this.inspections = inspections;
        initLayout();
    }
    
    private void initLayout() {
        if(!inspections.equals(0)) {
            addStyleName("inspections-listing-container");
            HorizontalLayout layout = new HorizontalLayout();
            layout.addStyleName("inspections-listing");


            Label number = new Label(inspections.toString());
            number.addStyleName("listing-label");
            addComponent(number);

            ImageComponent imageComponent = new ImageComponent("arrow-blue5.png", "2");
            addComponent(layout);
            addComponent(imageComponent);
        } else {
            addStyleName("inspections-listing-container-empty");
            HorizontalLayout layout = new HorizontalLayout();
            layout.addStyleName("inspections-listing-empty");

            Image image = new Image(null, new ThemeResource("img/empty.png"));
            image.addStyleName("inspections-empty-data");
            layout.addComponent(image);

            ImageComponent imageComponent = new ImageComponent("arrow3.png", "2");
            addComponent(layout);
            addComponent(imageComponent);
        }
    }
    
}
