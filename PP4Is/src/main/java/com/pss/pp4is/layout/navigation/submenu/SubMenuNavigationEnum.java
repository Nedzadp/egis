/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu;

import com.pss.pp4is.layout.navigation.submenu.links.SubMenuHomeNavigationLink;
import com.pss.pp4is.layout.navigation.submenu.links.SubMenuSecondNavigationLink;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nedzad
 */
public enum SubMenuNavigationEnum {
    SUB_MENU_HOME_WELCOME(1,1, SubMenuHomeNavigationLink.class),
    SUB_MENU_SECOND_LINK(2,2, SubMenuSecondNavigationLink.class);
    
    private final int rootMenu;
    private final int row;
    private final Class<? extends CustomSubmenuLink> link;
	
    private SubMenuNavigationEnum(int rootMenu,int row, Class<? extends CustomSubmenuLink> link) {
        this.rootMenu = rootMenu;
        this.row = row;
        this.link = link;
    }

    public int getRootMenu() {
        return rootMenu;
    }
    
    public int getRow() {
        return row;
    }

    public Class<? extends CustomSubmenuLink> getLink() {
        return link;
    }
	
    public  CustomSubmenuLink getInstance() {
        CustomSubmenuLink object = null;

        try {
            object =  link.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return object;
    }
    
    public static List<SubMenuNavigationEnum> getSubmenusByRootMenu(int rootMenu) {
        List<SubMenuNavigationEnum> subMenus = new ArrayList<SubMenuNavigationEnum>();
        
        for(SubMenuNavigationEnum subMenu : SubMenuNavigationEnum.values()) {
            if(subMenu.getRootMenu() == rootMenu) {
                subMenus.add(subMenu);
            }
        }
        
        return subMenus;
    }
    
}
