/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.reports;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.layout.content.CustomPanelLayout;
import com.pss.pp4is.layout.content.tables.UserActivityTable;
import com.pss.pp4is.layout.content.tables.UserInspectionTable;
import com.pss.pp4is.layout.content.tables.UserProductTable;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Nedzad
 */
public class MainContentUserActivityLayout extends CustomPanelLayout{

    private UserActivityTable userActivityTable;
    private UserProductTable userProductTable;
    private UserInspectionTable userInspectionTable;
    private HorizontalLayout filterLayout;
    private Button filterButton;
    private VerticalLayout layout;

    public MainContentUserActivityLayout(LayoutController layoutController) {
        super(layoutController);
    }
    
    
    
    @Override
    public void initLayout() {
       layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);
        
        
        userActivityTable = new UserActivityTable(DataController.getUserActivities());
        userActivityTable.setCaption(getLayoutController().getI18n().translate("User activities"));
        
        

        userProductTable = new UserProductTable(DataController.getFilteredUserProductActivities(null, null, null));
        userProductTable.setCaption(getLayoutController().getI18n().translate("User product activities"));
        
        userInspectionTable = new UserInspectionTable(DataController.getFilteredUserInspectionActivities(null, null, null));
        userInspectionTable.setCaption(getLayoutController().getI18n().translate("User inspection activities"));
        
         filterButton = new Button(getLayoutController().getI18n().translate("Filter"), new ThemeResource("img/filter.png"));
        filterButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
               UI.getCurrent().addWindow(addFilter());
            }
        });
        
        Label spacer = new Label(" ");
        spacer.setHeight("10px");
        layout.addComponent(spacer);
        addFilterLayout();
       layout.addComponent(userActivityTable);
        layout.addComponent(userProductTable);
        layout.addComponent(userInspectionTable);
        
        setContent(layout);
        
    }
    private UserActivityFilterPopup addFilter() {
       return new UserActivityFilterPopup(userActivityTable,userProductTable,userInspectionTable,null,null,getLayoutController(),this);
    }
    public void repaint() {
        layout.removeAllComponents();
        Label spacer = new Label(" ");
        spacer.setHeight("10px");
        layout.addComponent(spacer);
        addFilterLayout();
        layout.addComponent(userActivityTable);
        layout.addComponent(userProductTable);
        layout.addComponent(userInspectionTable);
    }
    private void addFilterLayout(){
        filterLayout = new HorizontalLayout();
        
        filterLayout.setSpacing(true);
        
        filterLayout.addComponent(filterButton);
        filterLayout.setComponentAlignment(filterButton, Alignment.MIDDLE_CENTER);
        
        VerticalLayout filterData = new VerticalLayout();
        Panel panel = new Panel();
        if(getLayoutController().getUserLabel()!=null) {
            panel.setCaption("Filter data");
            filterData.addComponent(new Label("Users: "+getLayoutController().getUserLabel()));
            filterData.addComponent(new Label("From date: "+getLayoutController().getFromDateLabel()));
            filterData.addComponent(new Label("To date: "+getLayoutController().getToDateLabel()));
        }
        panel.setContent(filterData);

        filterLayout.addComponent(panel);
        
        layout.addComponent(filterLayout);
    }
}