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
        addComponent(systemUsageTable);
        
        ChartUtils chartUtils = new ChartUtils();
        
        DataController.getChartData(null,null,null,chartUtils);
        
        customChartComponent = new CustomChartComponent(chartUtils);
        
        customChartComponent.show();
        
        addComponent(customChartComponent);
        
    }
}