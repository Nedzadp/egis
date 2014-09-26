/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout;

import com.github.wolfie.refresher.Refresher;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

/**
 *
 * @author Nedzad
 */
public class TimerButton extends Button implements Refresher.RefreshListener {

    private final LayoutController layoutController;

    public TimerButton(LayoutController layoutController) {
        this.layoutController = layoutController;
        addStyleName(ValoTheme.BUTTON_LINK);
        //addStyleName("restart-clock-button");
        addStyleName("restart-clock-button-new");
        setDescription("Reset the clock by clicking on it.");
    }

    @Override
    public void refresh(Refresher source) {
        String seconds = "";
        if(layoutController.getSeconds() < 10) {
            seconds +="0";
        }
        seconds += layoutController.getSeconds().toString();
        setCaption(layoutController.getMinutes().toString()+" : "+seconds);
    }
}
