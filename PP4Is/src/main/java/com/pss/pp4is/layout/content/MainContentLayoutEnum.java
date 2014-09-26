/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content;

import com.pss.pp4is.layout.content.views.MainContentHomeLayout;
import com.pss.pp4is.layout.content.views.MainContentTranslationLayout;
import com.pss.pp4is.layout.content.views.help.MainContentAboutLayout;
import com.pss.pp4is.layout.content.views.help.MainContentImagesLayout;
import com.pss.pp4is.layout.content.views.help.MainContentInformationLayout;
import com.pss.pp4is.layout.content.views.help.MainContentListsLayout;
import com.pss.pp4is.layout.content.views.help.MainContentReportsLayout;
import com.pss.pp4is.layout.content.views.listing.MainContentInspectionProfileLayout;
import com.pss.pp4is.layout.content.views.listing.MainContentProductInspectionLayout;
import com.pss.pp4is.layout.content.views.listing.MainContentProductLanguageLayout;
import com.pss.pp4is.layout.content.views.listing.MainContentProductPrinterLayout;
import com.pss.pp4is.layout.content.views.listing.MainContentProductTypeLayout;
import com.pss.pp4is.layout.content.views.listing.MainContentUserLayout;
import com.pss.pp4is.layout.content.views.reports.MainContentSystemUsageLayout;
import com.pss.pp4is.layout.content.views.reports.MainContentUserActivityLayout;

/**
 *
 * @author Nedzad
 */
public enum MainContentLayoutEnum {
    WELCOME_CONTENT_LAYOUT(1,1, MainContentHomeLayout.class),
    // help sub links
    INFORMATION_LAYOUT(15,2,MainContentInformationLayout.class),
    LISTS_LAYOUT(16,3,MainContentListsLayout.class),
    IMAGES_LAYOUT(17,4,MainContentImagesLayout.class),
    REPORTS_LAYOUT(18,5,MainContentReportsLayout.class),
    ABOUT_LAYOUT(19,6,MainContentAboutLayout.class),
    // listings

    // reports
    USER_ACTIVITIES(14,13, MainContentUserActivityLayout.class),
    SYSTEM_USAGE(13,14, MainContentSystemUsageLayout.class)
    ;

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
            System.out.println(e.getLocalizedMessage());
        } catch (IllegalAccessException e) {
            System.out.println(e.getLocalizedMessage());
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
