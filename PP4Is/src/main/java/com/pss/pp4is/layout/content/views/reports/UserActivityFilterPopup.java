/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.reports;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.data.containers.UserActivityContainer;
import com.pss.pp4is.layout.content.tables.UserActivityTable;
import com.vaadin.data.Property;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 *
 * @author Nedzad
 */
public class UserActivityFilterPopup extends Window {

    private UserComboBox userSelect;
    private UserActivityTable userActivityTable;
    private String username;
    private DateField  fromDateField;
    private DateField toDateField;
    
    public UserActivityFilterPopup(UserActivityTable userActivityTable) {
        super("User activity filter window");
        this.userActivityTable = userActivityTable;
        initLayout();
    }
    
    private void initLayout() {
        center();
        setModal(true);
        setClosable(true);
        setHeight("270px");
        setWidth("360px");
        addStyleName("exit-window");
        setResizable(false);
        VerticalLayout layout = new VerticalLayout();
        layout.setSpacing(true);
        layout.setMargin(true);
        
        FormLayout formLayout = new FormLayout();
        userSelect = new UserComboBox();
        formLayout.addComponent(userSelect);
        userSelect.addValueChangeListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                username = event.getProperty().getValue().toString();
            }
        });
        
        fromDateField = new DateField("From date");
        fromDateField.setWidth("180px");
        fromDateField.setDateFormat("yyyy-MM-dd HH:mm");
        formLayout.addComponent(fromDateField);
        toDateField = new DateField("To date");
        toDateField.setDateFormat("yyyy-MM-dd HH:mm");
        toDateField.setWidth("180px");
        formLayout.addComponent(toDateField);
        layout.addComponent(formLayout);
        
        HorizontalLayout buttonLayout = new HorizontalLayout();
        Label horizontalSpacer = new Label(" ");
        horizontalSpacer.setWidth("60px");
        buttonLayout.addComponent(horizontalSpacer);
        buttonLayout.setSpacing(true);
        buttonLayout.addComponent(new Button("Apply", new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                if(username != null) {
                    userActivityTable.removeAllItems();
                    userActivityTable.setContainerDataSource(DataController.getFilteredActivities(username,fromDateField.getValue(),toDateField.getValue()));
                    userActivityTable.setVisibleColumns(UserActivityContainer.NATURAL_COL_ORDER);
                    userActivityTable.setColumnCollapsed("id", true);
                    userActivityTable.setColumnHeaders(UserActivityContainer.COL_HEADERS_ENGLISH);
                } else {
                    Notification.show("Error", "User is not selected", Notification.Type.WARNING_MESSAGE);
                }
            }
        }));
        
        buttonLayout.addComponent(new Button("Close", new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                close();
            }
        }));
        
        layout.addComponent(buttonLayout);
        setContent(layout);
    }
    
}
