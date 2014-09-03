/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation;

import com.pss.pp4is.layout.navigation.links.MainMenuHomeNavigationLink;
import com.pss.pp4is.layout.navigation.links.MainMenuSecondNavigationLink;

/**
 *
 * @author Nedzad
 */
public enum MainMenuNavigationEnum {
    MAIN_MENU_HOME_LINK(1, MainMenuHomeNavigationLink.class),
    MAIN_MENU_SECOND_LINK(2, MainMenuSecondNavigationLink.class);
    
    private final int row;
    private final Class<? extends CustomButtonLink> link;
	
    private MainMenuNavigationEnum(int row, Class<? extends CustomButtonLink> link) {
            this.row = row;
            this.link = link;
    }
    
    public int getRow() {
        return row;
    }
	
    public  CustomButtonLink getInstance() {
        CustomButtonLink object = null;

        try {
            object =  link.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return object;
    }
}
