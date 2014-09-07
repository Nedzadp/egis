/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout;

import com.pss.pp4is.data.models.User;
import com.pss.pp4is.system.CurrentUser;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.event.FieldEvents;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
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
    private final LayoutController layoutController;
    
    public UserLoginHeader(LayoutController layoutController) {
        this.layoutController = layoutController;
        initLayout();
        
    }
    
    private void initLayout() {
        addStyleName("header-login");
        setWidth("320px");
        
        loginLabel = new Label("Log in:");
        
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
                getLoginLabel().removeStyleName("login-label-blinker");
                getLoginLabel().addStyleName("login-label");
        
                getUsernameField().removeStyleName("login-fields-blinker");
                getPasswordField().removeStyleName("login-fields-blinker");
            }
        });
         
         passwordField.addTextChangeListener(new TextChangeListener() {
            @Override
            public void textChange(FieldEvents.TextChangeEvent event) {
                getLoginLabel().removeStyleName("login-label-blinker");
                getLoginLabel().addStyleName("login-label");
        
                getUsernameField().removeStyleName("login-fields-blinker");
                getPasswordField().removeStyleName("login-fields-blinker");
            }
        });
        
         passwordField.addShortcutListener(new ShortcutListener("Enter pressed", ShortcutAction.KeyCode.ENTER, null) {
            @Override
            public void handleAction(Object sender, Object target) {
                user = CurrentUser.isAuthenticated(usernameField.getValue(), passwordField.getValue());
                if(user == null) {
                    Notification.show("Login", "User name or password is not correct. Please try it again.", Notification.Type.WARNING_MESSAGE);
                    getLoginLabel().removeStyleName("login-label");
                    getLoginLabel().addStyleName("login-label-action");

                    getUsernameField().addStyleName("login-fields");
                    getPasswordField().addStyleName("login-fields");
                    
                    getUsernameField().focus();
                    
                } else {
                     Notification.show("Welcome!", "System will automaticly log you out after a long inactivity. You can reset the clock by clicking on it.", Notification.Type.HUMANIZED_MESSAGE);
                     layoutController.refreshLayout();
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

    public void refreshLayout() {
        
        HorizontalLayout userInformation = new HorizontalLayout();
        
        Image userIcon = new Image(null, new ThemeResource("img/user-icon2.png"));
        userInformation.addComponent(userIcon);
        
        Label usernameLabel = new Label();
        usernameLabel.addStyleName("username-label");
        usernameLabel.setCaption(getUser().getUsername());
        userInformation.addComponent(usernameLabel);
        
        userInformation.addStyleName("user-information");
        addComponent(userInformation);
        setComponentAlignment(userInformation, Alignment.TOP_RIGHT);
       
    }
}
