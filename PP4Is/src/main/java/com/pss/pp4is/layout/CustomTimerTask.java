/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout;

import com.pss.pp4is.system.LayoutController;
import java.io.Serializable;
import java.util.TimerTask;

/**
 *
 * @author Nedzad
 */
public class CustomTimerTask  extends TimerTask implements Serializable{

    private final LayoutController layoutController;
    
    public CustomTimerTask(LayoutController layoutController) {
        this.layoutController = layoutController;
    }
    
    @Override
    public void run() {
        layoutController.setSeconds(layoutController.getSeconds()-1);
        if(layoutController.getSeconds() == 0 && layoutController.getMinutes() == 1) {
            layoutController.showNotification();
        }
        if (layoutController.getSeconds() == 0 && layoutController.getMinutes()>0) {
            layoutController.setMinutes(layoutController.getMinutes()-1);
            layoutController.setSeconds(59);
        }
        if(layoutController.getSeconds() == 0 && layoutController.getMinutes() == 0) {
           
            layoutController.automaticallyLogout();
        }
    }
}