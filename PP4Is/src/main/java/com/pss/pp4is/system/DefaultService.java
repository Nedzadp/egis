/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.system;

import com.pss.pp4is.layout.content.MainContentComponent;

/**
 *
 * @author Nedzad
 */
public class DefaultService implements IService{
    private  MainContentComponent mainContentComponent;

    public DefaultService() {
        
    }

    @Override
    public MainContentComponent getMainContentComponent() {
        return this.mainContentComponent;
    }
    
}
