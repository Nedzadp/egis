/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout;

import com.pss.pp4is.data.models.User;
import com.pss.pp4is.system.CurrentUser;
import com.vaadin.event.FieldEvents;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.Page;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

/**
 *
 * @author Nedzad
 */
public class UserLoginHeader extends HorizontalLayout{

    private Label loginLabel;
    private TextField usernameField;
    private PasswordField passwordField;
    private User user;
    
    public UserLoginHeader() {
        initLayout();
    }
    
    private void initLayout() {
        addStyleName("header-login");
        setWidth("320px");
        
        loginLabel = new Label("Log in");
        
        loginLabel.setWidth("40px");
        loginLabel.addStyleName("login-label");
        
        addComponent(loginLabel);
        setExpandRatio(loginLabel, 0.4f);
        usernameField = new TextField();
        usernameField.setWidth("125px");
        usernameField.setInputPrompt("username");
       
        
        addComponent(usernameField);
        setExpandRatio(usernameField, 1.25f);
        
        passwordField  = new PasswordField();
        passwordField.setWidth("125px");
       
        passwordField.setInputPrompt("password");
        addComponent(passwordField);
        setExpandRatio(passwordField, 1.25f);
        
         usernameField.addTextChangeListener(new TextChangeListener() {
            @Override
            public void textChange(FieldEvents.TextChangeEvent event) {
                getLoginLabel().removeStyleName("login-label-action");
                getLoginLabel().addStyleName("login-label");
        
                getUsernameField().removeStyleName("login-fields");
                getPasswordField().removeStyleName("login-fields");
            }
        });
         
         passwordField.addTextChangeListener(new TextChangeListener() {
            @Override
            public void textChange(FieldEvents.TextChangeEvent event) {
                getLoginLabel().removeStyleName("login-label-action");
                getLoginLabel().addStyleName("login-label");
        
                getUsernameField().removeStyleName("login-fields");
                getPasswordField().removeStyleName("login-fields");
            }
        });
        
         passwordField.addShortcutListener(new ShortcutListener("Enter pressed", ShortcutAction.KeyCode.ENTER, null) {
            @Override
            public void handleAction(Object sender, Object target) {
                user = CurrentUser.isAuthenticated(usernameField.getValue(), passwordField.getValue());
                if(user == null) {
                    Notification.show("Login", "Login failed for username "+usernameField.getValue()+ ".", Notification.Type.WARNING_MESSAGE);
                    getLoginLabel().removeStyleName("login-label");
                    getLoginLabel().addStyleName("login-label-action");

                    getUsernameField().addStyleName("login-fields");
                    getPasswordField().addStyleName("login-fields");
                    
                    getUsernameField().focus();
                    
                } else {
                     Notification.show("Login", "Welcome "+user.getFirstName()+".", Notification.Type.TRAY_NOTIFICATION);
                }
                
            }
        });
         
    }

    public User getUser() {
        return user;
    }
    
    public Label getLoginLabel() {
        return loginLabel;
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }
}
