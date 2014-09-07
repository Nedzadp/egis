/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout;

import com.github.wolfie.refresher.Refresher;
import com.github.wolfie.refresher.Refresher.RefreshListener;
import com.vaadin.ui.Label;

/**
 *
 * @author Nedzad
 */
public class CountdownTimerLabel extends Label implements RefreshListener{

    
    
    public CountdownTimerLabel(String caption) {
        setCaption(caption);
    }

    
    
    @Override
    public void refresh(Refresher source) {
        
    }
    
}
