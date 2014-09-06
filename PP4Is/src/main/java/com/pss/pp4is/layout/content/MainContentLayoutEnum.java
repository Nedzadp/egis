/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content;

import com.pss.pp4is.layout.content.views.MainContentHomeLayout;

/**
 *
 * @author Nedzad
 */
public enum MainContentLayoutEnum {
    WELCOME_CONTENT_LAYOUT(1,1, MainContentHomeLayout.class);

    private final int subMenu;
    private final int row;
    private final Class<? extends CustomVerticalLayout> view;
	
    private MainContentLayoutEnum(int subMenu,int row, Class<? extends CustomVerticalLayout> view) {
        this.subMenu = subMenu;
        this.row = row;
        this.view = view;
    }
    
    public int getRow() {
        return row;
    }

    public int getSubMenu() {
        return subMenu;
    }
    
    public  CustomVerticalLayout getInstance() {
        CustomVerticalLayout object = null;
        try {
            object =  view.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return object;
    }
    
    public static CustomVerticalLayout getInstanceBySubMenu(int subMenu) {
        for(MainContentLayoutEnum layout: MainContentLayoutEnum.values()){
            if(layout.getSubMenu() == subMenu) {
                return layout.getInstance();
            }
        }
        return null;
    }
}
