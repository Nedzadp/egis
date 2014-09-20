/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation;

import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.BaseTheme;

/**
 *
 * @author Nedzad
 */
public abstract class CustomButtonLink extends Button{

    private LayoutController layoutController;
    protected Integer customButtonLinkId;
    
    public CustomButtonLink() {
        addStyleName(BaseTheme.BUTTON_LINK);
        addStyleName("main-menu-button");
        addClickListener(new ClickListener() {		
                @Override
                public void buttonClick(ClickEvent event) {
                    handleClick(event);
                }
            });
	}
    
    public void setLayoutController(LayoutController layoutController) {
        this.layoutController = layoutController;
    }

    public LayoutController getLayoutController() {
        return layoutController;
    }

    public boolean equals(CustomButtonLink cbl) {
        return this.customButtonLinkId.equals(cbl.getCustomButtonLinkId());
    }
    
    
    public abstract void handleClick(ClickEvent event);
    
    public abstract void addCaption();
    
    public  void setCustomButtonLinkId(Integer id){
        this.customButtonLinkId = id;
    }
    
    public Integer getCustomButtonLinkId() {
        return this.customButtonLinkId;
    }
    
}
