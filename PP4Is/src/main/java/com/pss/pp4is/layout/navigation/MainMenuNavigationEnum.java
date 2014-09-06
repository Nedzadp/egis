/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation;

import com.pss.pp4is.layout.navigation.links.MainMenuHomeNavigationLink;
import com.pss.pp4is.layout.navigation.links.MainMenuListsNavigationLink;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nedzad
 */
public enum MainMenuNavigationEnum {
    MAIN_MENU_HOME_LINK(1, MainMenuHomeNavigationLink.class, null),
    MAIN_MENU_SECOND_LINK(2, MainMenuListsNavigationLink.class,true);
    

    
    private final int row;
    private final Class<? extends CustomButtonLink> link;
    private final Boolean isAuthenticatedUser;
	
    private MainMenuNavigationEnum(int row, Class<? extends CustomButtonLink> link, Boolean isAuthenticatedUser) {
        this.row = row;
        this.link = link;
        this.isAuthenticatedUser = isAuthenticatedUser;
    }
    
    public int getRow() {
        return row;
    }

    public Boolean isIsAuthenticatedUser() {
        return isAuthenticatedUser;
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
    
    public static Iterable<MainMenuNavigationEnum> getValuesForAnonymousUser() {
        List<MainMenuNavigationEnum> values = new ArrayList<MainMenuNavigationEnum>();
        
        for(MainMenuNavigationEnum menu : MainMenuNavigationEnum.values()) {
            if( menu.isAuthenticatedUser == null) {
                values.add(menu);  
            } else {
                if(!menu.isAuthenticatedUser) {
                    values.add(menu);    
                }
            }
        }
        
        return values;
    }
    public static Iterable<MainMenuNavigationEnum> getValuesForAuthenticatedUser() {
        List<MainMenuNavigationEnum> values = new ArrayList<MainMenuNavigationEnum>();
        
        for(MainMenuNavigationEnum menu : MainMenuNavigationEnum.values()) {
            if(menu.isAuthenticatedUser == null || menu.isAuthenticatedUser ) {
                values.add(menu);
            }
        }
        
        return values;
    }
}
