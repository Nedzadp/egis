/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content;

import com.pss.pp4is.layout.content.form.LeftFormLayoutBottom;
import com.pss.pp4is.layout.content.form.LeftFormLayoutTop;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Nedzad
 */
public class LeftMainContentComponent extends  VerticalLayout{

    private LeftFormLayoutTop formLayoutTop;
     private LeftFormLayoutBottom formLayoutBottom;
    
    public LeftMainContentComponent() {
        
    }
    
    public void initLayout() {
        addStyleName("left-panel");
        
        Label header = new Label("Product details");
        header.addStyleName("header-text");
        addComponent(header);
        
        HorizontalLayout mainHorizontalLine = new HorizontalLayout();
        mainHorizontalLine.setHeight("3px");
        mainHorizontalLine.addStyleName("text-hrline");
        addComponent(mainHorizontalLine);
        
        formLayoutTop = new LeftFormLayoutTop();
        addComponent(formLayoutTop);
    }

    public LeftFormLayoutTop getFormLayoutTop() {
        return formLayoutTop;
    }

    public LeftFormLayoutBottom getFormLayoutBottom() {
        return formLayoutBottom;
    }

    
    
    public void initSecondLayout() {
        addStyleName("left-panel");
        
        Label header = new Label("Master details");
        header.addStyleName("header-text");
        addComponent(header);
        
        HorizontalLayout mainHorizontalLine = new HorizontalLayout();
        mainHorizontalLine.setHeight("3px");
        mainHorizontalLine.addStyleName("text-hrline");
        addComponent(mainHorizontalLine);
        
        formLayoutBottom = new LeftFormLayoutBottom();
        addComponent(formLayoutBottom);
    }


    
}
