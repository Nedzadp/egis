/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.reports;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Nedzad
 */
public class ChartUtils {
    
    private final Set<String> ticks;
    private final Map<String, Map<String,Integer>> map;

    public ChartUtils() {
        ticks = new LinkedHashSet<String>();
        map = new LinkedHashMap<String,Map<String,Integer>>();
    }

    public Set<String> getTicks() {
        return ticks;
    }

    public Map<String, Map<String, Integer>> getMap() {
        return map;
    }
    
    
    
}
