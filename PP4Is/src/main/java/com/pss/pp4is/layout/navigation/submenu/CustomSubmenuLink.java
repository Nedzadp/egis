/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu;

import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.BaseTheme;

/**
 *
 * @author Nedzad
 */
public abstract class CustomSubmenuLink extends  Button{
    private LayoutController layoutController;
    protected Integer customSubmenuLinkId;
    
     public CustomSubmenuLink() {
        addStyleName(BaseTheme.BUTTON_LINK);
        addStyleName("sub-menu-button");
        addClickListener(new Button.ClickListener() {		
                @Override
                public void buttonClick(Button.ClickEvent event) {
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
    
    public abstract void handleClick(Button.ClickEvent event);
    
    public abstract void addCaption();
    
    public abstract String getLinkCaption();

    public boolean equals(CustomSubmenuLink obj) {
        return this.getCustomSubmenuLinkId().equals(obj.getCustomSubmenuLinkId()); 
    }
    
    public void setCustomSubmenuLinkId(Integer customSubmenuLinkId) {
        this.customSubmenuLinkId = customSubmenuLinkId;
    }

    public Integer getCustomSubmenuLinkId() {
        return customSubmenuLinkId;
    }
}
