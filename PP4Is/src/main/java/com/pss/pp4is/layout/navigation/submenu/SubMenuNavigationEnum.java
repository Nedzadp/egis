/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu;

import com.pss.pp4is.layout.navigation.submenu.links.SubMenuDocumentCompaniesNavigationLink;
import com.pss.pp4is.layout.navigation.submenu.links.SubMenuDocumentTypeNavigationLink;
import com.pss.pp4is.layout.navigation.submenu.links.SubMenuEnglishNavigationLink;
import com.pss.pp4is.layout.navigation.submenu.links.SubMenuExitNavigationLink;
import com.pss.pp4is.layout.navigation.submenu.links.SubMenuHomeNavigationLink;
import com.pss.pp4is.layout.navigation.submenu.links.SubMenuInspectionProfilesNavigationLink;
import com.pss.pp4is.layout.navigation.submenu.links.SubMenuLoginNavigationLink;
import com.pss.pp4is.layout.navigation.submenu.links.SubMenuMagyarNavigationLink;
import com.pss.pp4is.layout.navigation.submenu.links.SubMenuProductsInspectionsNavigationLink;
import com.pss.pp4is.layout.navigation.submenu.links.SubMenuRestartClockNavigationLink;
import com.pss.pp4is.layout.navigation.submenu.links.SubMenuUsersNavigationLink;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nedzad
 */
public enum SubMenuNavigationEnum {
    // sub menus of first main menu, rootMenu = 1
// sub menus of first main menu, rootMenu = 1
    SUB_MENU_HOME_WELCOME(1,1, SubMenuHomeNavigationLink.class, null),
    SUB_MENU_ENGLISH(1,2, SubMenuEnglishNavigationLink.class,null),
    SUB_MENU_MAGYAR(1,3, SubMenuMagyarNavigationLink.class,null),
    SUB_MENU_LOGIN(1,4, SubMenuLoginNavigationLink.class, false),
    SUB_MENU_RESTART_CLOCK(1,5, SubMenuRestartClockNavigationLink.class,true),
    SUB_MENU_EXIT(1,6, SubMenuExitNavigationLink.class,true),
    // sub menus of second main menu, rootMenu = 2
    SUB_MENU_PRODUCTS_INSPECTIONS(2,7, SubMenuProductsInspectionsNavigationLink.class,true),
    SUB_MENU_DOCUMENT_LANGUAGES(2,8, SubMenuDocumentTypeNavigationLink.class,true),
    SUB_MENU_DOCUMENT_TYPES(2,9, SubMenuDocumentTypeNavigationLink.class,true),
    SUB_MENU_DOCUMENT_PRINT_COMPANIES(2,10, SubMenuDocumentCompaniesNavigationLink.class,true),
    SUB_MENU_INSPECTION_PROFILES(2,11, SubMenuInspectionProfilesNavigationLink.class,true),
    SUB_MENU_USERS(2,12, SubMenuUsersNavigationLink.class,true)
    ;
    
    private final int rootMenu;
    private final int row;
    private final Class<? extends CustomSubmenuLink> link;
    private final Boolean authenticated;
    
    private SubMenuNavigationEnum(int rootMenu,int row, Class<? extends CustomSubmenuLink> link, Boolean authenticated) {
        this.rootMenu = rootMenu;
        this.row = row;
        this.link = link;
        this.authenticated = authenticated;
    }

    public int getRootMenu() {
        return rootMenu;
    }
    
    public int getRow() {
        return row;
    }

    public Boolean isAuthenticated() {
        return authenticated;
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
    
    public static List<SubMenuNavigationEnum> getSubmenusByRootMenu(int rootMenu, boolean authenticated) {
        List<SubMenuNavigationEnum> subMenus = new ArrayList<SubMenuNavigationEnum>();
        
        for(SubMenuNavigationEnum subMenu : SubMenuNavigationEnum.values()) {
            if(subMenu.getRootMenu() == rootMenu) {
                if(subMenu.isAuthenticated()==null) {
                    subMenus.add(subMenu);
                } else if(subMenu.isAuthenticated().equals(authenticated)) {
                    subMenus.add(subMenu);
                }
            }
        }
        
        return subMenus;
    }
    
}
