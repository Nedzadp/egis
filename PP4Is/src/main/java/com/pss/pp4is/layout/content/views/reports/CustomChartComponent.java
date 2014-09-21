/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.reports;

import com.google.gwt.thirdparty.guava.common.collect.Ordering;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.dussan.vaadin.dcharts.DCharts;
import org.dussan.vaadin.dcharts.base.elements.XYaxis;
import org.dussan.vaadin.dcharts.base.elements.XYseries;
import org.dussan.vaadin.dcharts.data.DataSeries;
import org.dussan.vaadin.dcharts.data.Ticks;
import org.dussan.vaadin.dcharts.metadata.LegendPlacements;
import org.dussan.vaadin.dcharts.metadata.TooltipAxes;
import org.dussan.vaadin.dcharts.metadata.locations.TooltipLocations;
import org.dussan.vaadin.dcharts.metadata.renderers.AxisRenderers;
import org.dussan.vaadin.dcharts.metadata.renderers.SeriesRenderers;
import org.dussan.vaadin.dcharts.options.Axes;
import org.dussan.vaadin.dcharts.options.Highlighter;
import org.dussan.vaadin.dcharts.options.Legend;
import org.dussan.vaadin.dcharts.options.Options;
import org.dussan.vaadin.dcharts.options.Series;
import org.dussan.vaadin.dcharts.options.SeriesDefaults;

/**
 *
 * @author Nedzad
 */
public class CustomChartComponent extends DCharts{

    private final ChartUtils chartUtils;
    
    public CustomChartComponent(ChartUtils chartUtils) {
        this.chartUtils = chartUtils;
        initChart();
    }
    
    private void initChart() {
        DataSeries dataSeries = new DataSeries();
        Series series = new Series();
        
        for(Map.Entry<String, Map<String,Integer>> mapEntry : chartUtils.getMap().entrySet()) {
           
           Object[] data = new Object[chartUtils.getTicks().size()];
           Arrays.fill(data, 0);
           
           for(Map.Entry<String,Integer> mapEntry2 : mapEntry.getValue().entrySet()){
               int tickCounter = 0;
               for(String tick : chartUtils.getTicks()) {
                   if(tick.equals(mapEntry2.getKey())) {
                       data[tickCounter] = mapEntry2.getValue();
                   }
                   tickCounter++;
               }
           }
           
           dataSeries.add(data);
           
           series.addSeries(new XYseries().setLabel(mapEntry.getKey()));
            
        }
        
        SeriesDefaults seriesDefaults = new SeriesDefaults()
                .setFillToZero(true)
                .setRenderer(SeriesRenderers.BAR);

       

        Legend legend = new Legend().setShow(true).setPlacement(LegendPlacements.OUTSIDE_GRID);

        Highlighter highlighter = new Highlighter()
                .setShow(true)
                .setShowTooltip(true)
                .setTooltipAlwaysVisible(true)
                .setKeepTooltipInsideChart(true)
                .setTooltipLocation(TooltipLocations.NORTH)
                .setTooltipAxes(TooltipAxes.XY_BAR);
        
        Axes axes = new Axes()
	.addAxis(
		new XYaxis()
			.setRenderer(AxisRenderers.CATEGORY)
			.setTicks(
				new Ticks()
					.add(chartUtils.getTicks().toArray())));
	

        Options options = new Options()
                .setSeriesDefaults(seriesDefaults)
                .setSeries(series)
                .setLegend(legend)
                .setHighlighter(highlighter)
                .setAxes(axes);
        
        setDataSeries(dataSeries);
        setOptions(options);
    }
    
    
}
