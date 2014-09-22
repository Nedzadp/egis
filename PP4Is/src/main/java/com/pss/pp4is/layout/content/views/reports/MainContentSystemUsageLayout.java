/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.reports;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.data.containers.SystemUsageContainer;
import com.pss.pp4is.layout.content.CustomVerticalLayout;
import com.pss.pp4is.layout.content.tables.SystemUsageTable;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

/**
 *
 * @author Nedzad
 */
public class MainContentSystemUsageLayout extends CustomVerticalLayout{

    private SystemUsageTable systemUsageTable;
    private CustomChartComponent customChartComponent;

    @Override
    public void initLayout() {
        setMargin(true);
        setSpacing(true);
        
        
        
        SystemUsageContainer systemUsageContainer = DataController.getFilteredSystemUsage(null, null, null);
        
        systemUsageTable = new SystemUsageTable(systemUsageContainer);
        
        
        ChartUtils chartUtils = new ChartUtils();
        
        DataController.getChartData(null,null,null,chartUtils);
        
        customChartComponent = new CustomChartComponent(chartUtils);
        
        customChartComponent.show();
        
        Button filterButton = new Button(getLayoutController().getI18n().translate("Filter"), new ThemeResource("img/filter.png"));
        filterButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
               UI.getCurrent().addWindow(addFilter());
            }
        });
        
        
        Label spacer = new Label(" ");
        spacer.setHeight("10px");
        addComponent(spacer);
        
        addComponent(filterButton);
        
        addComponent(systemUsageTable);
        
        addComponent(customChartComponent);
        
    }
    
    private UserActivityFilterPopup addFilter() {
       return new UserActivityFilterPopup(null,null,null,systemUsageTable, this);
    }

    public CustomChartComponent getCustomChartComponent() {
        return customChartComponent;
    }

    public void setCustomChartComponent(CustomChartComponent customChartComponent) {
        this.customChartComponent = customChartComponent;
    }
}