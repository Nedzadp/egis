/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout;

import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.MenuBar.Command;

/**
 *
 * @author Nedzad
 */
public abstract class AbstractCommand implements Command{

    private LayoutController layoutController; 
    
    public AbstractCommand(LayoutController layoutController) {
        this.layoutController = layoutController;
    }

    public LayoutController getLayoutController() {
        return layoutController;
    }
}
