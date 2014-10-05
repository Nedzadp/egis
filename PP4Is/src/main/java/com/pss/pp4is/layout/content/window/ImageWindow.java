/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.window;

import com.pss.pp4is.system.LayoutController;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 *
 * @author Nedzad
 */
public class ImageWindow extends Window{

    private final LayoutController layoutController;
    private final String imgPath;
    
    public ImageWindow(LayoutController layoutController, String imgPath) {
        this.layoutController = layoutController;
        this.imgPath = imgPath;
        setCaption(this.layoutController.getI18n().translate("Image preview"));
        initLayout();
        
    }
    
    private void initLayout() {
        center();
        setModal(true);
        setClosable(true);
        
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(new Image(null, new ThemeResource(imgPath)));
        
        setContent(verticalLayout);
    }
}
