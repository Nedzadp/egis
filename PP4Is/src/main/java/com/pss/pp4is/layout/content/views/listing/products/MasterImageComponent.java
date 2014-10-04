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
public class MasterImageComponent extends HorizontalLayout{

    private final Integer masterImages;
    
    public MasterImageComponent(Integer masterImages) {
        this.masterImages = masterImages;
        initLayout();
    }
    
    private void initLayout() {
         if(!masterImages.equals(0)) {
          
            addStyleName("master-listing-container");
            HorizontalLayout layout = new HorizontalLayout();
            layout.addStyleName("master-listing");
        
       
            Label number = new Label(masterImages.toString());
            number.addStyleName("listing-label");
            addComponent(number);
       
            ImageComponent imageComponent = new ImageComponent("arrow-blue5.png", "3");
            addComponent(layout);
            addComponent(imageComponent);
        
        } else {
                addStyleName("master-listing-container-empty");
                HorizontalLayout layout = new HorizontalLayout();
                layout.addStyleName("master-listing-empty");
                
                Image image = new Image(null, new ThemeResource("img/empty.png"));
                image.addStyleName("master-empty-data");
                addComponent(image);
                
                ImageComponent imageComponent = new ImageComponent("arrow3.png", "3");
                addComponent(layout);
                addComponent(imageComponent);
        }
    }
}
