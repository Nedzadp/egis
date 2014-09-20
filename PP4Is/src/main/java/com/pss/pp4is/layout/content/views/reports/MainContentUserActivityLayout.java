/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.reports;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.layout.content.CustomVerticalLayout;
import com.pss.pp4is.layout.content.tables.UserActivityTable;
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
    

    @Override
    public void initLayout() {
        setMargin(true);
        setSpacing(true);
        
        addComponent(new Label(getLayoutController().getI18n().translate("User activities")));
        
        userActivityTable = new UserActivityTable(DataController.getUserActivities());
        
        Label spacer = new Label(" ");
        spacer.setHeight("10px");
        addComponent(spacer);

        userProductTable = new UserProductTable(DataController.getFilteredUserProductActivities(null, null, null));

        
        Button filterButton = new Button(getLayoutController().getI18n().translate("Filter"), new ThemeResource("img/filter.png"));
        filterButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
               UI.getCurrent().addWindow(new UserActivityFilterPopup(userActivityTable));
            }
        });
        addComponent(filterButton);
        addComponent(userActivityTable);
        addComponent(userProductTable);
        
    }
}