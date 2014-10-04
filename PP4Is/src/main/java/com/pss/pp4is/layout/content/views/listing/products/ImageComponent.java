/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.listing.products;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Image;

/**
 *
 * @author Nedzad
 */
public class ImageComponent extends Image{

    public ImageComponent(String imageName, String zIndex) {
        super(null, new ThemeResource("img/"+imageName));
        addStyleName("image-"+zIndex);
    }
}
