/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.reports;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.data.containers.SystemUsageContainer;
import com.pss.pp4is.data.containers.UserActivityContainer;
import com.pss.pp4is.data.containers.UserInspectionContainer;
import com.pss.pp4is.data.containers.UserProductContainer;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.data.Property;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Nedzad
 */
public class HorizontalFilter extends HorizontalLayout{

    private UserComboBox userSelect;
    private String username;
    private DateField  fromDateField;
    private DateField toDateField;
    private final LayoutController layoutController;
    private final MainContentUserActivityLayout activityLayout;
    private final MainContentSystemUsageLayout systemUsageLayout;
    
    public HorizontalFilter(LayoutController layoutController, MainContentUserActivityLayout activityLayout, MainContentSystemUsageLayout systemUsageLayout) {
        this.layoutController = layoutController;
        this.activityLayout = activityLayout;
        this.systemUsageLayout = systemUsageLayout;
        initLayout();
    }
    
    private void initLayout() {
        addStyleName("filter-layout");
        setWidth("915px");
        setHeight("140px");
    
        VerticalLayout leftSide = new VerticalLayout();
        
        leftSide.setWidth("807px");
        Label filterOptionLabel = new Label(layoutController.getI18n().translate("Filter options"));
        filterOptionLabel.addStyleName("filter-bold-label");
        leftSide.addComponent(filterOptionLabel);
        
        Label horizontalSpacer = new Label("");
        horizontalSpacer.addStyleName("horizontal-filter-line");
        horizontalSpacer.setWidth("780px");
        horizontalSpacer.setHeight("1px");
        leftSide.addComponent(horizontalSpacer);
        
        HorizontalLayout fieldsLayout = new HorizontalLayout();
        fieldsLayout.setHeight("100px");
        fieldsLayout.setWidth("780px");
        
        // user select left layout
        HorizontalLayout userSelectLayout = new HorizontalLayout();
        userSelectLayout.setWidth("360px");
        userSelectLayout.setHeight("100px");
        
        Label usersLabel = new Label(layoutController.getI18n().translate("Users: "));
        usersLabel.setWidth("100px");
        userSelectLayout.addComponent(usersLabel);
        userSelectLayout.setExpandRatio(usersLabel, 0.1f);
        userSelectLayout.addComponent(userSelect = new UserComboBox());
        userSelect.setWidth("280px");
        userSelect.addValueChangeListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                username = null;
                if(event.getProperty().getValue() != null) {
                    username = event.getProperty().getValue().toString();
                } 
            }
        });
        // end of user select left layout
        
        
        // right dates layout
        VerticalLayout rightFieldsLayout = new  VerticalLayout();
        
        rightFieldsLayout.setWidth("360px");
        rightFieldsLayout.setHeight("80px");
        
        HorizontalLayout fromDateFieldLayout = new HorizontalLayout();
        fromDateFieldLayout.setWidth("360px");
        fromDateFieldLayout.setHeight("30px");
        fromDateField = new DateField();
        fromDateField.addStyleName(ValoTheme.DATEFIELD_TINY);
        fromDateField.setWidth("260px");
        fromDateField.setDateFormat("yyyy-MM-dd HH:mm");
        Label fromDateLabel = new Label(layoutController.getI18n().translate("From date: "));
        fromDateLabel.setWidth("100px");
        fromDateFieldLayout.addComponent(fromDateLabel);
        fromDateFieldLayout.addComponent(fromDateField);
        fromDateFieldLayout.setExpandRatio(fromDateLabel, 0.1f);
        rightFieldsLayout.addComponent(fromDateFieldLayout);
        // end right dates layout
        
        HorizontalLayout toDateFieldLayout = new HorizontalLayout();
        toDateFieldLayout.setWidth("360px");
        toDateFieldLayout.setHeight("30px");
        toDateField = new DateField();
        toDateField.addStyleName(ValoTheme.DATEFIELD_TINY);
        toDateField.setDateFormat("yyyy-MM-dd HH:mm");
        toDateField.setValue(new Timestamp(new Date().getTime()));
        toDateField.setResolution(Resolution.SECOND);
        toDateField.setWidth("260px");
        Label toDateLabel = new Label(layoutController.getI18n().translate("To date: "));
        toDateLabel.setWidth("100px");
        toDateFieldLayout.addComponent(toDateLabel);
        toDateFieldLayout.addComponent(toDateField);
        toDateFieldLayout.setExpandRatio(toDateLabel, 0.1f);
        rightFieldsLayout.addComponent(toDateFieldLayout);
       
        HorizontalLayout fieldsSpacer = new HorizontalLayout();
        fieldsSpacer.setWidth("10px");
        Label horizontalFieldSpacer = new Label("");
        horizontalFieldSpacer.setWidth("1px");
        horizontalFieldSpacer.setHeight("85px");
        horizontalFieldSpacer.addStyleName("horizontal-filter-line");
        fieldsSpacer.addComponent(horizontalFieldSpacer);
        
        fieldsLayout.addComponent(userSelectLayout);
        fieldsLayout.setExpandRatio(userSelectLayout, 0.9f);
        
        fieldsLayout.addComponent(fieldsSpacer);
        fieldsLayout.setExpandRatio(fieldsSpacer, 0.03f);
        
        fieldsLayout.addComponent(rightFieldsLayout);
        fieldsLayout.setExpandRatio(rightFieldsLayout, 0.9f);
        
        leftSide.addComponent(fieldsLayout);
        
        VerticalLayout rightSide = new VerticalLayout();
        rightSide.setWidth("100px");
        rightSide.setHeight("132px");
        rightSide.addStyleName("right-border");
        
        Button applyFilter = new Button(layoutController.getI18n().translate("Apply"), new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                applyFilter(username,fromDateField.getValue(),toDateField.getValue());
            }
        });
        applyFilter.addStyleName(ValoTheme.BUTTON_SMALL);
        
        Button clearFilter = new Button(layoutController.getI18n().translate("Clear"), new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                userSelect.setValue(null);
                username = null;
                fromDateField.setValue(null);
                toDateField.setValue(new Timestamp(new Date().getTime()));
                applyFilter(username,fromDateField.getValue(),toDateField.getValue());
            }
        });
        clearFilter.addStyleName(ValoTheme.BUTTON_SMALL);
        clearFilter.setWidth("65px");
        rightSide.setSpacing(true);
        rightSide.setMargin(true);
        rightSide.addComponent(applyFilter);
        rightSide.addComponent(clearFilter);
        
        
        addComponent(leftSide);
        setExpandRatio(leftSide, 1f);
        addComponent(rightSide);
        setExpandRatio(rightSide, 0.16f);
    }
    
    private void applyFilter(String user, Date fromDate, Date toDate) {
        
        if(activityLayout!=null) {
            activityLayout.getUserActivityTable().removeAllItems();
            activityLayout.getUserActivityTable().setContainerDataSource(DataController.getFilteredActivities(user,fromDate,toDate));
            activityLayout.getUserActivityTable().setVisibleColumns(UserActivityContainer.NATURAL_COL_ORDER);
            activityLayout.getUserActivityTable().setColumnCollapsed("id", true);
            activityLayout.getUserActivityTable().setColumnHeaders(UserActivityContainer.COL_HEADERS_ENGLISH);

            activityLayout.getUserProductTable().removeAllItems();
            activityLayout.getUserProductTable().setContainerDataSource(DataController.getFilteredUserProductActivities(user,fromDate,toDate));
            activityLayout.getUserProductTable().setVisibleColumns(UserProductContainer.NATURAL_COL_ORDER);
            activityLayout.getUserProductTable().setColumnHeaders(UserProductContainer.COL_HEADERS_ENGLISH);

            activityLayout.getUserInspectionTable().removeAllItems();
            activityLayout.getUserInspectionTable().setContainerDataSource(DataController.getFilteredUserInspectionActivities(user,fromDate,toDate));
            activityLayout.getUserInspectionTable().setVisibleColumns(UserInspectionContainer.NATURAL_COL_ORDER);
            activityLayout.getUserInspectionTable().setColumnHeaders(UserInspectionContainer.COL_HEADERS_ENGLISH);

            activityLayout.repaint();
        }
        if(systemUsageLayout != null) {
            systemUsageLayout.getSystemUsageTable().removeAllItems();
            systemUsageLayout.getSystemUsageTable().setContainerDataSource(DataController.getFilteredSystemUsage(user,fromDate,toDate));
            systemUsageLayout.getSystemUsageTable().setVisibleColumns(SystemUsageContainer.NATURAL_COL_ORDER);
            systemUsageLayout.getSystemUsageTable().setColumnCollapsed("id", true);
            systemUsageLayout.getSystemUsageTable().setColumnHeaders(SystemUsageContainer.COL_HEADERS_ENGLISH);

            systemUsageLayout.getLayout().removeComponent(systemUsageLayout.getSystemUsageTable());
            systemUsageLayout.getLayout().removeComponent(systemUsageLayout.getCustomChartComponent());
            ChartUtils chartUtils = new ChartUtils();

            DataController.getChartData(user,fromDate,toDate,chartUtils);

            CustomChartComponent chartComponent = new CustomChartComponent(chartUtils);
            systemUsageLayout.setCustomChartComponent(chartComponent);
            chartComponent.show();
            
            systemUsageLayout.getLayout().addComponent(systemUsageLayout.getSystemUsageTable());
            systemUsageLayout.getLayout().addComponent(systemUsageLayout.getCustomChartComponent());
            
        }
    }
    
    
}
