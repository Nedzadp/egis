/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu.links.home;

import com.github.wolfie.refresher.Refresher;
import com.pss.pp4is.layout.navigation.submenu.CustomSubmenuLink;
import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.Notification;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nedzad
 */
public class SubMenuLoginNavigationLink extends CustomSubmenuLink{

    public SubMenuLoginNavigationLink() {
        setCaption("Log in");
    }

    @Override
    public void handleClick(ClickEvent event) {
        getLayoutController().fixSelectedSubMenu(this);
        
        Notification note = new Notification(null,"Log in here, please!",Notification.Type.HUMANIZED_MESSAGE);
        note.setDelayMsec(4000);
        note.setPosition(Position.TOP_CENTER);
        note.setStyleName("mynotification");
        note.show(Page.getCurrent());

        
        getLayoutController().getUserLoginHeader().getLoginLabel().removeStyleName("login-label");
        getLayoutController().getUserLoginHeader().getLoginLabel().addStyleName("login-label-blinker");
        
        getLayoutController().getUserLoginHeader().getUsernameField().addStyleName("login-fields-blinker");
        getLayoutController().getUserLoginHeader().getPasswordField().addStyleName("login-fields-blinker");
        
        getLayoutController().getUserLoginHeader().getUsernameField().focus();
        
        new CustomThread().start();

        
    }
    
    private class CustomThread extends Thread {

        public CustomThread() {
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                getLayoutController().getUserLoginHeader().getLoginLabel().removeStyleName("login-label-blinker");
                getLayoutController().getUserLoginHeader().getUsernameField().removeStyleName("login-fields-blinker");
                getLayoutController().getUserLoginHeader().getPasswordField().removeStyleName("login-fields-blinker");
        
                getLayoutController().getUserLoginHeader().getLoginLabel().removeStyleName("login-label");
        
            } catch (InterruptedException ex) {
                Logger.getLogger(SubMenuLoginNavigationLink.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
        private class RefreshTimer implements Refresher.RefreshListener {

            public RefreshTimer() {
            }

            @Override
            public void refresh(Refresher source) {
                getLayoutController().getUserLoginHeader().getLoginLabel().removeStyleName("login-label-blinker");
                getLayoutController().getUserLoginHeader().getUsernameField().removeStyleName("login-fields-blinker");
                getLayoutController().getUserLoginHeader().getPasswordField().removeStyleName("login-fields-blinker");

                getLayoutController().getUserLoginHeader().getLoginLabel().removeStyleName("login-label");

            }
        }
    }
}
