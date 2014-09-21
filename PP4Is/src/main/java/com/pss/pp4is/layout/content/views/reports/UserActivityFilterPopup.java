/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.reports;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.data.containers.UserActivityContainer;
import com.pss.pp4is.data.containers.UserInspectionContainer;
import com.pss.pp4is.data.containers.UserProductContainer;
import com.pss.pp4is.layout.content.tables.UserActivityTable;
import com.pss.pp4is.layout.content.tables.UserInspectionTable;
import com.pss.pp4is.layout.content.tables.UserProductTable;
import com.vaadin.data.Property;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 *
 * @author Nedzad
 */
public class UserActivityFilterPopup extends Window {

    private UserComboBox userSelect;
    private final UserActivityTable userActivityTable;
    private final UserProductTable userProductTable;
    private final UserInspectionTable userInspectionTable;
    private String username;
    private DateField  fromDateField;
    private DateField toDateField;
    
    public UserActivityFilterPopup(UserActivityTable userActivityTable,UserProductTable userProductTable,UserInspectionTable userInspectionTable) {
        super("User activity filter window");
        this.userActivityTable = userActivityTable;
        this.userProductTable = userProductTable;
        this.userInspectionTable = userInspectionTable;
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
                username = null;
                if(event.getProperty().getValue() != null) {
                    username = event.getProperty().getValue().toString();
                } 
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
                if(userActivityTable!= null && userProductTable!=null && userInspectionTable!=null) {
                    userActivityTable.removeAllItems();
                    userActivityTable.setContainerDataSource(DataController.getFilteredActivities(username,fromDateField.getValue(),toDateField.getValue()));
                    userActivityTable.setVisibleColumns(UserActivityContainer.NATURAL_COL_ORDER);
                    userActivityTable.setColumnCollapsed("id", true);
                    userActivityTable.setColumnHeaders(UserActivityContainer.COL_HEADERS_ENGLISH);

                    userProductTable.removeAllItems();
                    userProductTable.setContainerDataSource(DataController.getFilteredUserProductActivities(username,fromDateField.getValue(),toDateField.getValue()));
                    userProductTable.setVisibleColumns(UserProductContainer.NATURAL_COL_ORDER);
                    userProductTable.setColumnHeaders(UserProductContainer.COL_HEADERS_ENGLISH);

                    userInspectionTable.removeAllItems();
                    userInspectionTable.setContainerDataSource(DataController.getFilteredUserInspectionActivities(username,fromDateField.getValue(),toDateField.getValue()));
                    userInspectionTable.setVisibleColumns(UserInspectionContainer.NATURAL_COL_ORDER);
                    userInspectionTable.setColumnHeaders(UserInspectionContainer.COL_HEADERS_ENGLISH);
                }
                close();
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
