/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.reports;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.data.containers.SystemUsageContainer;
import com.pss.pp4is.layout.content.CustomPanelLayout;
import com.pss.pp4is.layout.content.tables.SystemUsageTable;
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
public class MainContentSystemUsageLayout extends CustomPanelLayout{

    private SystemUsageTable systemUsageTable;
    private CustomChartComponent customChartComponent;
    private HorizontalLayout filterLayout;
    private Button filterButton;
    private VerticalLayout layout;

    public MainContentSystemUsageLayout(LayoutController layoutController) {
        super(layoutController);
    }

    @Override
    public void initLayout() {
        layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);
        
        
        
        SystemUsageContainer systemUsageContainer = DataController.getFilteredSystemUsage(null, null, null);
        
        systemUsageTable = new SystemUsageTable(systemUsageContainer);
        systemUsageTable.setCaption(getLayoutController().getI18n().translate("System usage data"));
        
        ChartUtils chartUtils = new ChartUtils();
        
        DataController.getChartData(null,null,null,chartUtils);
        
        customChartComponent = new CustomChartComponent(chartUtils);
        customChartComponent.setCaption(getLayoutController().getI18n().translate("Inspection details data"));
        customChartComponent.show();
        
        filterButton = new Button(getLayoutController().getI18n().translate("Filter"), new ThemeResource("img/filter.png"));
        filterButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
               UI.getCurrent().addWindow(addFilter());
            }
        });
        
        addFilterLayout();
        
        layout.addComponent(systemUsageTable);
        
        layout.addComponent(customChartComponent);
        
        setContent(layout);
        
    }

    public VerticalLayout getLayout() {
        return layout;
    }
    
    
    private UserActivityFilterPopup addFilter() {
       return new UserActivityFilterPopup(null,null,null,systemUsageTable, this,getLayoutController(),null);
    }

    public CustomChartComponent getCustomChartComponent() {
        return customChartComponent;
    }

    public void setCustomChartComponent(CustomChartComponent customChartComponent) {
        this.customChartComponent = customChartComponent;
        this.customChartComponent.setCaption(getLayoutController().getI18n().translate("System usage data"));
    }

    public void repaint() {
        layout.removeAllComponents();
        Label spacer = new Label(" ");
        spacer.setHeight("10px");
        layout.addComponent(spacer);
        addFilterLayout();
        layout.addComponent(systemUsageTable);
    }
    
    private void addFilterLayout(){
        filterLayout = new HorizontalLayout();
        HorizontalFilter horizontalFilter = new HorizontalFilter(getLayoutController(),null,this);
        filterLayout.addComponent(horizontalFilter);
        /*
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
        */
        layout.addComponent(filterLayout);
    }

    public SystemUsageTable getSystemUsageTable() {
        return systemUsageTable;
    }
    
}