/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout;

import com.github.wolfie.refresher.Refresher;
import com.pss.pp4is.data.DataController;
import com.pss.pp4is.data.models.User;
import com.pss.pp4is.layout.content.window.ExitWindow;
import com.pss.pp4is.system.CurrentUser;
import com.pss.pp4is.system.LanguageEnum;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.event.FieldEvents;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;


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
    private CustomTimerTask customTimerTask;
    private HorizontalLayout content;
    private Label loggedInLabel;
    private Label autoLogoutLabel;
    
    public UserLoginHeader(LayoutController layoutController) {
        this.layoutController = layoutController;
        //initLayout();
        initNewLayout();
    }
    
    private void initContent() {
        setWidth("750px");
        setHeight("36px");
      
        content = new HorizontalLayout();
        
        content.removeAllComponents();
        
        addComponent(content);
        setComponentAlignment(content, Alignment.TOP_RIGHT);
    }
    
    private void initNewLayout() {
        
        initContent();
        content.setSpacing(true);
        loginLabel = new Label(layoutController.getI18n().translate("LOGIN:"));
        loginLabel.addStyleName("login-label-color");
        
        content.addComponent(loginLabel);
        usernameField = new TextField();
        usernameField.addStyleName(ValoTheme.TEXTFIELD_TINY);
        usernameField.setInputPrompt(layoutController.getI18n().translate("username"));
        usernameField.setHeight("21px");
        usernameField.addStyleName("username-border");
        content.addComponent(usernameField);
        
        passwordField  = new PasswordField();
        passwordField.addStyleName(ValoTheme.TEXTFIELD_TINY);
        passwordField.setInputPrompt(layoutController.getI18n().translate("password"));
        passwordField.setHeight("21px");
        passwordField.addStyleName("username-border");
        passwordField.addShortcutListener(new ShortcutListener("Enter pressed", ShortcutAction.KeyCode.ENTER, null) {
           @Override
           public void handleAction(Object sender, Object target) {
               login();
           }
        });
        content.addComponent(passwordField);
        
         usernameField.addTextChangeListener(new TextChangeListener() {
            @Override
            public void textChange(FieldEvents.TextChangeEvent event) {
                getLoginLabel().removeStyleName("login-label-blinker");
                getLoginLabel().addStyleName("login-label-color");
        
                getUsernameField().removeStyleName("login-fields-blinker");
                getPasswordField().removeStyleName("login-fields-blinker");
            }
        });
         
         Button loginButton = new Button(new ThemeResource("img/login.jpg"));
         loginButton.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
         loginButton.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_TOP);
         loginButton.addStyleName(ValoTheme.BUTTON_BORDERLESS);
         loginButton.addStyleName("logout-button-padding");
         loginButton.setWidth("23px");
         loginButton.setHeight("21px");
         loginButton.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                login();
            }
        });
         
        content.addComponent(loginButton);
    }
    
    private void login() {
        user = CurrentUser.isAuthenticated(usernameField.getValue(), passwordField.getValue());
                if(user == null) {
                    Notification notification = new Notification(layoutController.getI18n().translate("Login"), layoutController.getI18n().translate("User name or password is not correct. Please try it again."), Notification.Type.WARNING_MESSAGE);
                    notification.setDelayMsec(2000);
                    notification.show(Page.getCurrent());
                    
                    getLoginLabel().removeStyleName("login-label-color");
                    getLoginLabel().addStyleName("login-label-action");

                    getUsernameField().addStyleName("login-fields");
                    getPasswordField().addStyleName("login-fields");
                    
                    getUsernameField().focus();
                    
                } else {
                     layoutController.getI18n().setLanguageEnum(LanguageEnum.getUserLanguage(user));
                     layoutController.setUser(user);
                     layoutController.getComboBox().setValue(layoutController.getI18n().getLanguageEnum().getLang());
                     layoutController.getComboBox().setItemCaption(layoutController.getI18n().getLanguageEnum().getLang(), layoutController.getI18n().translate(layoutController.getI18n().getLanguageEnum().getFullLangName()));
                     
                     Notification notification = new Notification(layoutController.getI18n().translate("Welcome!"), layoutController.getI18n().translate("System will automaticly log you out after a long inactivity. You can reset the clock by clicking on it."), Notification.Type.HUMANIZED_MESSAGE);
                     notification.setDelayMsec(2000);
                     notification.show(Page.getCurrent());
                    //Notification.show(layoutController.getI18n().translate("Welcome!"), layoutController.getI18n().translate("System will automaticly log you out after a long inactivity. You can reset the clock by clicking on it."), Notification.Type.HUMANIZED_MESSAGE);
                     
                     UI.getCurrent().getSession().setAttribute("user", user);
                     DataController.insertUserActivity(layoutController.getUser());
                     layoutController.refreshNewLayout();
                     Notification notification2 = new Notification(layoutController.getI18n().translate("Welcome!"), layoutController.getI18n().translate("User activity logged in"), Notification.Type.TRAY_NOTIFICATION);
                     notification2.setDelayMsec(1);
                     notification2.show(Page.getCurrent());
                     //Notification.show(layoutController.getI18n().translate("Welcome!"), layoutController.getI18n().translate("User activity logged in"), Notification.Type.TRAY_NOTIFICATION);
                }
    }
    
    private void initLayout() {
        addStyleName("header-login");
        setWidth("340px");
        
        loginLabel = new Label(layoutController.getI18n().translate("Log in:"));
        loginLabel.setWidth("80px");
        if(layoutController.getI18n().getLanguageEnum().getLang().equals("hun")) {
            loginLabel.setWidth("80px");
        }
        
        addComponent(loginLabel);
        setComponentAlignment(loginLabel, Alignment.MIDDLE_RIGHT);
        if(layoutController.getI18n().getLanguageEnum().getLang().equals("hun")) {
            setExpandRatio(loginLabel, 0.5f);
        } else {
            setExpandRatio(loginLabel, 0.3f);
        }
        
        usernameField = new TextField();
        usernameField.setWidth("125px");
        usernameField.setInputPrompt(layoutController.getI18n().translate("username"));
       
        
        addComponent(usernameField);
        if(layoutController.getI18n().getLanguageEnum().getLang().equals("hun")) {
            setExpandRatio(usernameField, 0.8f); 
        } else {
            setExpandRatio(usernameField, 1f);
        }
       
        
        passwordField  = new PasswordField();
        passwordField.setWidth("125px");
       
        passwordField.setInputPrompt(layoutController.getI18n().translate("password"));
        addComponent(passwordField);
        setExpandRatio(passwordField, 0.8f);
        
         usernameField.addTextChangeListener(new TextChangeListener() {
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
                    Notification notification = new Notification(layoutController.getI18n().translate("Login"), layoutController.getI18n().translate("User name or password is not correct. Please try it again."), Notification.Type.WARNING_MESSAGE);
                    notification.setDelayMsec(1);
                    notification.show(Page.getCurrent());
                    
                   // Notification.show(layoutController.getI18n().translate("Login"), layoutController.getI18n().translate("User name or password is not correct. Please try it again."), Notification.Type.WARNING_MESSAGE);
                    getLoginLabel().removeStyleName("login-label");
                    getLoginLabel().addStyleName("login-label-action");

                    getUsernameField().addStyleName("login-fields");
                    getPasswordField().addStyleName("login-fields");
                    
                    getUsernameField().focus();
                    
                } else {
                     layoutController.getI18n().setLanguageEnum(LanguageEnum.getUserLanguage(user));
                     layoutController.getComboBox().setValue(layoutController.getI18n().getLanguageEnum().getLang());
                     Notification notification = new Notification(layoutController.getI18n().translate("Welcome!"), layoutController.getI18n().translate("System will automaticly log you out after a long inactivity. You can reset the clock by clicking on it."), Notification.Type.HUMANIZED_MESSAGE);
                     notification.setDelayMsec(1);
                     notification.show(Page.getCurrent());
                    //Notification.show(layoutController.getI18n().translate("Welcome!"), layoutController.getI18n().translate("System will automaticly log you out after a long inactivity. You can reset the clock by clicking on it."), Notification.Type.HUMANIZED_MESSAGE);
                     layoutController.setUser(user);
                     UI.getCurrent().getSession().setAttribute("user", user);
                     DataController.insertUserActivity(layoutController.getUser());
                     layoutController.refreshLayout();
                     Notification notification2 = new Notification(layoutController.getI18n().translate("Welcome!"), layoutController.getI18n().translate("User activity logged in"), Notification.Type.TRAY_NOTIFICATION);
                     notification2.setDelayMsec(1);
                     notification2.show(Page.getCurrent());
                     //Notification.show(layoutController.getI18n().translate("Welcome!"), layoutController.getI18n().translate("User activity logged in"), Notification.Type.TRAY_NOTIFICATION);
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
        userInformation.setSpacing(true);
        loggedInLabel = new Label();
        loggedInLabel.setValue(layoutController.getI18n().translate("LOGGED IN: "));
        loggedInLabel.addStyleName("label-color");
        userInformation.addComponent(loggedInLabel);
        
        Label usernameLabel = new Label(layoutController.getUser().getUsername().toUpperCase());
        usernameLabel.addStyleName("label-font");
        userInformation.addComponent(usernameLabel);
        
        Label spacer = new Label(" ");
        spacer.setWidth("20px");
        userInformation.addComponent(spacer);
        
        autoLogoutLabel = new Label();
        autoLogoutLabel.setValue(layoutController.getI18n().translate("AUTO LOG OUT TIME:"));
        autoLogoutLabel.addStyleName("label-color");
        
        userInformation.addComponent(autoLogoutLabel);
        
        layoutController.setSeconds(59);
        layoutController.setMinutes(DataController.getTimerMinutes()-1);
        
        layoutController.getTimerButton().setCaption(layoutController.getMinutes().toString()+":"+layoutController.getSeconds().toString());
        layoutController.getTimerButton().addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                resetClock();
            }
        });
        
        
        final Refresher refresher = new Refresher();
        refresher.addListener(layoutController.getTimerButton());
        addExtension(refresher);
        
        layoutController.runClock(customTimerTask = new CustomTimerTask(layoutController));
        layoutController.setCustomTimerTask(customTimerTask);
        
        userInformation.addComponent(layoutController.getTimerButton());
        
        Button logoutButton = new Button(new ThemeResource("img/logout.jpg"));
        logoutButton.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        logoutButton.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_TOP);
        logoutButton.addStyleName(ValoTheme.BUTTON_BORDERLESS);
        logoutButton.addStyleName("logout-button-padding");
        logoutButton.setWidth("23px");
        logoutButton.setHeight("21px");
        logoutButton.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                UI.getCurrent().addWindow(new ExitWindow(layoutController));
            }
        });
         
        userInformation.addComponent(logoutButton);
        
        addComponent(userInformation);
        setComponentAlignment(userInformation, Alignment.TOP_RIGHT);
    }
    
    public void resetClock() {
        
        Notification notification = new Notification(layoutController.getI18n().translate("Clock"), layoutController.getI18n().translate("Clock restarted successfully"), Notification.Type.TRAY_NOTIFICATION);
        notification.setDelayMsec(1);
        notification.show(Page.getCurrent());
        //Notification.show(layoutController.getI18n().translate("Clock"), layoutController.getI18n().translate("Clock restarted successfully"), Notification.Type.TRAY_NOTIFICATION);
        layoutController.setSeconds(59);
        layoutController.setMinutes(DataController.getTimerMinutes()-1);
        DataController.updateTimerUserActivity(layoutController.getUser());
    }

    public void refreshNewLayout() {
        initContent();
        
        loggedInLabel = new Label();
        loggedInLabel.setValue(layoutController.getI18n().translate("LOGGED IN: "));
        loggedInLabel.addStyleName("label-color");
       
        
        content.addComponent(loggedInLabel);
        content.setComponentAlignment(loggedInLabel, Alignment.MIDDLE_RIGHT);
        
        Label usernameLabel = new Label(layoutController.getUser().getUsername().toUpperCase());
        usernameLabel.addStyleName("label-font");
        
        
        content.addComponent(usernameLabel);
        content.setComponentAlignment(usernameLabel, Alignment.MIDDLE_RIGHT);
        Label spacer = new Label(" ");
        spacer.setWidth("20px");
        content.addComponent(spacer);
        
        autoLogoutLabel = new Label();
        autoLogoutLabel.setValue(layoutController.getI18n().translate("AUTO LOG OUT TIME:"));
        autoLogoutLabel.addStyleName("label-color");
        
        content.addComponent(autoLogoutLabel);
        content.setComponentAlignment(autoLogoutLabel, Alignment.MIDDLE_RIGHT);
        
        layoutController.setSeconds(59);
        layoutController.setMinutes(DataController.getTimerMinutes()-1);
        
        layoutController.getTimerButton().setCaption(layoutController.getMinutes().toString()+" : "+layoutController.getSeconds().toString());
        
        
        final Refresher refresher = new Refresher();
        refresher.addListener(layoutController.getTimerButton());
        addExtension(refresher);
        
        layoutController.runClock(customTimerTask = new CustomTimerTask(layoutController));
        layoutController.setCustomTimerTask(customTimerTask);
        
        content.addComponent(layoutController.getTimerButton());
        layoutController.getTimerButton().addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                resetClock();
            }
        });
        
        Button logoutButton = new Button(new ThemeResource("img/logout.jpg"));
        logoutButton.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        logoutButton.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_TOP);
        logoutButton.addStyleName(ValoTheme.BUTTON_BORDERLESS);
        logoutButton.setWidth("23px");
        logoutButton.setHeight("21px");
        logoutButton.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                UI.getCurrent().addWindow(new ExitWindow(layoutController));
            }
        });
         
         content.addComponent(logoutButton);
         content.setComponentAlignment(logoutButton, Alignment.MIDDLE_RIGHT);
    }

    public Label getAutoLogoutLabel() {
        return autoLogoutLabel;
    }

    public Label getLoggedInLabel() {
        return loggedInLabel;
    }

    public void refreshLabelTranslate() {
        if(autoLogoutLabel!=null){
            autoLogoutLabel.setValue("");
            loggedInLabel.setValue("");
            autoLogoutLabel.setValue(layoutController.getI18n().translate("AUTO LOG OUT TIME:"));
            loggedInLabel.setValue(layoutController.getI18n().translate("LOGGED IN: "));
            layoutController.getComboBox().setItemCaption("eng", layoutController.getI18n().translate("English"));
            layoutController.getComboBox().setItemCaption("hun", layoutController.getI18n().translate("Magyar"));
        }
    }
}
