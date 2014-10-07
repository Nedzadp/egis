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
public class CertificatesComponent extends HorizontalLayout{

    
    public void initLayout(Integer certificates,String color) {
        if(certificates.equals(0)) {
            addStyleName("certificates-listing-container-empty");
            HorizontalLayout layout = new HorizontalLayout();
            layout.addStyleName("certificates-listing-empty");

            Image image = new Image(null, new ThemeResource("img/empty.png"));
            image.addStyleName("certificates-empty-data");
            layout.addComponent(image);

            ImageComponent imageComponent = new ImageComponent("arrow3.png", "6");
            addComponent(layout);
            addComponent(imageComponent);
        } else if(!certificates.equals(0) && color.equals("green")) {
            addStyleName("certificates-listing-container");
            HorizontalLayout layout = new HorizontalLayout();
            layout.addStyleName("certificates-listing");

            Label number = new Label(certificates.toString());
            number.addStyleName("listing-label-certificates");
            addComponent(number);

            ImageComponent imageComponent = new ImageComponent("arrow-green.png", "6");
            addComponent(layout);
            addComponent(imageComponent);
            
        } else if(!certificates.equals(0) && color.equals("pink")) {
            addStyleName("certificates-listing-container-pink");
            HorizontalLayout layout = new HorizontalLayout();
            layout.addStyleName("certificates-listing-pink");

            Label number = new Label(certificates.toString());
            number.addStyleName("listing-label-certificates");
            addComponent(number);

            ImageComponent imageComponent = new ImageComponent("arrow-pink.png", "6");
            addComponent(layout);
            addComponent(imageComponent);
        }
     
    }
}
