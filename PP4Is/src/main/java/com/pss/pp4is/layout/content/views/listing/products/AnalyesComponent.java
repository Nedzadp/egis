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
public class AnalyesComponent extends HorizontalLayout{

    
    public void initLayout(Integer analyses,String color) {
       if(analyses.equals(0)) {
            addStyleName("analyses-listing-container-empty");
            HorizontalLayout layout = new HorizontalLayout();
            layout.addStyleName("analyses-listing-empty");

            Image image = new Image(null, new ThemeResource("img/empty.png"));
            image.addStyleName("analyses-empty-data");
            layout.addComponent(image);

            ImageComponent imageComponent = new ImageComponent("arrow3.png", "5");
            addComponent(layout);
            addComponent(imageComponent);
        } else if(!analyses.equals(0) && color.equals("green")) {
            addStyleName("analyses-listing-container");
            HorizontalLayout layout = new HorizontalLayout();
            layout.addStyleName("analyses-listing");

            Label number = new Label(analyses.toString());
            number.addStyleName("listing-label");
            addComponent(number);

            ImageComponent imageComponent = new ImageComponent("arrow-green.png", "5");
            addComponent(layout);
            addComponent(imageComponent);
        } else if(!analyses.equals(0) && color.equals("pink")) {
            addStyleName("analyses-listing-container-pink");
            HorizontalLayout layout = new HorizontalLayout();
            layout.addStyleName("analyses-listing-pink");

            Label number = new Label(analyses.toString());
            number.addStyleName("listing-label");
            addComponent(number);

            ImageComponent imageComponent = new ImageComponent("arrow-pink.png", "5");
            addComponent(layout);
            addComponent(imageComponent);
        }
    }
}
