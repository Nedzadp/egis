/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout;

import com.github.wolfie.refresher.Refresher;
import com.github.wolfie.refresher.Refresher.RefreshListener;
import com.pss.pp4is.data.DataController;
import com.pss.pp4is.data.models.User;
import com.pss.pp4is.layout.content.window.ExitWindow;
import com.pss.pp4is.system.CurrentUser;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.event.FieldEvents;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.event.MouseEvents;
import com.vaadin.event.MouseEvents.ClickListener;
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
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.BaseTheme;
import java.util.Timer;
import java.util.TimerTask;


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
    
    private Timer timer;
    private Integer seconds;
    private Integer minutes;
    private TimerButton timerButton;
    
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
                     layoutController.setUser(user);
                     UI.getCurrent().getSession().setAttribute("user", user);
                     DataController.insertUserActivity(layoutController.getUser());
                     layoutController.refreshLayout();
                     Notification.show("Welcome!", "User activity logged in", Notification.Type.TRAY_NOTIFICATION);
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
        
        Label usernameLabel = new Label();
        usernameLabel.addStyleName("username-label");
        usernameLabel.setCaption(getUser().getUsername());
        userInformation.addComponent(usernameLabel);
        
        Image logout = new Image(null, new ThemeResource("img/logout.png"));
        logout.addStyleName("logout-icon");
        logout.addClickListener(new ClickListener() {
            @Override
            public void click(MouseEvents.ClickEvent event) {
               UI.getCurrent().addWindow(new ExitWindow(layoutController));
            }
        });
        
        userInformation.addComponent(logout);
        
        
        seconds = 59;
        minutes = DataController.getTimerMinutes()-1;
     
        int delay = 1000;
        int period = 1000;
        
        timerButton = new TimerButton();
        timerButton.setCaption(minutes.toString()+" : "+seconds.toString());
        timerButton.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
               resetClock();
            }
        });
        
        final Refresher refresher = new Refresher();
        refresher.addListener(timerButton);
        addExtension(refresher);
        
        userInformation.addComponent(timerButton);
        
        timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {


            
        @Override
        public void run() {
            seconds--;
            if (seconds == 0 && minutes>0) {
                minutes--;
                seconds = 59;
            }
            if(minutes == 0 && seconds == 0) {
                timer.cancel();
                automaticallyLogout();
            }
        }
    }, delay, period);
        
        addComponent(userInformation);
        setComponentAlignment(userInformation, Alignment.TOP_RIGHT);
    }
   
    private void automaticallyLogout() {
        DataController.updateUserActivity(layoutController.getUser());
        layoutController.getCustomLayout().removeAllComponents();
        layoutController.getCustomLayout().init();
        Notification.show("Timer","You have been automatically logged out!", Notification.Type.WARNING_MESSAGE);
    }
    
    private class TimerButton extends Button implements RefreshListener {

        public TimerButton() {
            addStyleName(BaseTheme.BUTTON_LINK);
            addStyleName("restart-clock-button");
            setDescription("Reset the clock by clicking on it.");
        }

        @Override
        public void refresh(Refresher source) {
            
            setCaption(minutes.toString()+" : "+seconds.toString());
        }
    }
    
    public void resetClock() {
        Notification.show("Clock", "Clock restarted successfully", Notification.Type.TRAY_NOTIFICATION);
        seconds = 59;
        minutes = DataController.getTimerMinutes()-1;
        DataController.updateTimerUserActivity(layoutController.getUser());
    }
}
