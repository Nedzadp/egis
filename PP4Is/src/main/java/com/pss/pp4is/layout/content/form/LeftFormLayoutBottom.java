/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.form;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.VerticalLayout;
/**
 *
 * @author Nedzad
 */
public class LeftFormLayoutBottom extends VerticalLayout{
    private Embedded image;
    
    public LeftFormLayoutBottom() {
        setMargin(true);
        initFormLayout();
    }
    
    public void initFormLayout() {
        removeAllComponents();
        image =new Embedded(null, new ThemeResource("images/no-image.jpg"));
        image.setWidth( "230px" ); 
        image.setHeight( "170px" );
        addComponent(image);
        setComponentAlignment(image, Alignment.BOTTOM_CENTER);
    
    }

    public void updateImage(String path) {
        removeAllComponents();
        if(path!=null && !path.isEmpty()){
            image = new Embedded( null, new ThemeResource( path ) );
            image.setWidth( "230px" ); 
            image.setHeight( "170px" );
            addComponent(image);
            setComponentAlignment(image, Alignment.BOTTOM_CENTER);

        } else {
            initFormLayout();
        } 
            
    }

    
}
