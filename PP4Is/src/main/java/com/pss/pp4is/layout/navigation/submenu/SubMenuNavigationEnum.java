/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu;

import com.pss.pp4is.layout.navigation.submenu.links.SubMenuEnglishNavigationLink;
import com.pss.pp4is.layout.navigation.submenu.links.SubMenuHomeNavigationLink;
import com.pss.pp4is.layout.navigation.submenu.links.SubMenuLoginNavigationLink;
import com.pss.pp4is.layout.navigation.submenu.links.SubMenuMagyarNavigationLink;
import com.pss.pp4is.layout.navigation.submenu.links.SubMenuSecondNavigationLink;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nedzad
 */
public enum SubMenuNavigationEnum {
    SUB_MENU_HOME_WELCOME(1,1, SubMenuHomeNavigationLink.class, null),
    SUB_MENU_ENGLISH(1,2, SubMenuEnglishNavigationLink.class,null),
    SUB_MENU_MAGYAR(1,3, SubMenuMagyarNavigationLink.class,null),
    SUB_MENU_LOGIN(1,4, SubMenuLoginNavigationLink.class, false),
    SUB_MENU_RESTART_CLOCK(2,5, SubMenuSecondNavigationLink.class,true);
    
    private final int rootMenu;
    private final int row;
    private final Class<? extends CustomSubmenuLink> link;
    private final Boolean isAuthenticated;
    
    private SubMenuNavigationEnum(int rootMenu,int row, Class<? extends CustomSubmenuLink> link, Boolean isAuthenticated) {
        this.rootMenu = rootMenu;
        this.row = row;
        this.link = link;
        this.isAuthenticated = isAuthenticated;
    }

    public int getRootMenu() {
        return rootMenu;
    }
    
    public int getRow() {
        return row;
    }

    public Boolean isIsAuthenticated() {
        return isAuthenticated;
    }

    public Class<? extends CustomSubmenuLink> getLink() {
        return link;
    }
	
    public  CustomSubmenuLink getInstance() {
        CustomSubmenuLink object = null;

        try {
            object =  link.newInstance();
        } catch (InstantiationException e) {
            System.out.println(e.getLocalizedMessage());
        } catch (IllegalAccessException e) {
            System.out.println(e.getLocalizedMessage());
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
    
    public static List<SubMenuNavigationEnum> getAuthenticatedSubmenusByRootMenu(int rootMenu) {
        List<SubMenuNavigationEnum> subMenus = new ArrayList<SubMenuNavigationEnum>();
        
        for(SubMenuNavigationEnum subMenu : SubMenuNavigationEnum.values()) {
            if(subMenu.getRootMenu() == rootMenu) {
                subMenus.add(subMenu);
            }
        }
        
        return subMenus;
    }
    
}
