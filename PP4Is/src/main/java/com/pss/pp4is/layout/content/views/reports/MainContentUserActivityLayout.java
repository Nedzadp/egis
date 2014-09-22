/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.reports;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.layout.content.CustomVerticalLayout;
import com.pss.pp4is.layout.content.tables.UserActivityTable;
import com.pss.pp4is.layout.content.tables.UserInspectionTable;
import com.pss.pp4is.layout.content.tables.UserProductTable;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

/**
 *
 * @author Nedzad
 */
public class MainContentUserActivityLayout extends CustomVerticalLayout{

    private UserActivityTable userActivityTable;
    private UserProductTable userProductTable;
    private UserInspectionTable userInspectionTable;

    @Override
    public void initLayout() {
        setMargin(true);
        setSpacing(true);
        
        
        userActivityTable = new UserActivityTable(DataController.getUserActivities());
        userActivityTable.setCaption(getLayoutController().getI18n().translate("User activities"));
        Label spacer = new Label(" ");
        spacer.setHeight("10px");
        addComponent(spacer);

        userProductTable = new UserProductTable(DataController.getFilteredUserProductActivities(null, null, null));
        userProductTable.setCaption(getLayoutController().getI18n().translate("User product activities"));
        
        userInspectionTable = new UserInspectionTable(DataController.getFilteredUserInspectionActivities(null, null, null));
        userInspectionTable.setCaption(getLayoutController().getI18n().translate("User inspection activities"));
        
        Button filterButton = new Button(getLayoutController().getI18n().translate("Filter"), new ThemeResource("img/filter.png"));
        filterButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
               UI.getCurrent().addWindow(new UserActivityFilterPopup(userActivityTable,userProductTable,userInspectionTable,null,null));
            }
        });
        addComponent(filterButton);
        addComponent(spacer);
        addComponent(userActivityTable);
        addComponent(spacer);
        addComponent(userProductTable);
        addComponent(spacer);
        addComponent(userInspectionTable);
        
    }
}