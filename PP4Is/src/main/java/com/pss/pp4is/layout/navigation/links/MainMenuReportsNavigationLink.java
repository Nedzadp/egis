/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.links;

import com.google.gwt.user.client.DOM;
import com.pss.pp4is.layout.navigation.CustomButtonLink;
import com.vaadin.ui.Notification;

/**
 *
 * @author Nedzad
 */
public class MainMenuReportsNavigationLink extends CustomButtonLink{

    public MainMenuReportsNavigationLink() {
        setCaption("Reports");
    }

    @Override
    public void handleClick(ClickEvent event) {
        getLayoutController().fixSelectedMenu(this);
        this.addStyleName("selected");
        getLayoutController().setCustomButtonLink(this);
        Notification.show("No implemented yet");
    }
 
    
    
}
