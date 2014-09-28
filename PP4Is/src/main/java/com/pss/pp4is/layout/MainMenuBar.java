/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout;

import com.pss.pp4is.layout.navigation.submenu.links.help.AboutMenuBarCommand;
import com.pss.pp4is.layout.navigation.submenu.links.help.ImageMenuBarCommand;
import com.pss.pp4is.layout.navigation.submenu.links.help.InformationMenuBarCommand;
import com.pss.pp4is.layout.navigation.submenu.links.help.ListMenuBarCommand;
import com.pss.pp4is.layout.navigation.submenu.links.help.ReportMenuBarCommand;
import com.pss.pp4is.layout.navigation.submenu.links.home.EnglishMenuBarCommand;
import com.pss.pp4is.layout.navigation.submenu.links.home.ExitMenuBarCommand;
import com.pss.pp4is.layout.navigation.submenu.links.home.LoginMenuBarCommand;
import com.pss.pp4is.layout.navigation.submenu.links.home.MagyarMenuBarCommand;
import com.pss.pp4is.layout.navigation.submenu.links.home.RestartClockMenuBarCommand;
import com.pss.pp4is.layout.navigation.submenu.links.home.TranslationMenuBarCommand;
import com.pss.pp4is.layout.navigation.submenu.links.home.WelcomeMenuBarCommand;
import com.pss.pp4is.layout.navigation.submenu.links.lists.DocumentCompaniesMenuBarCommand;
import com.pss.pp4is.layout.navigation.submenu.links.lists.DocumentLanguageMenuBarCommand;
import com.pss.pp4is.layout.navigation.submenu.links.lists.DocumentTypeMenuBarCommand;
import com.pss.pp4is.layout.navigation.submenu.links.lists.InspectionProfileMenuBarCommand;
import com.pss.pp4is.layout.navigation.submenu.links.lists.ProductInspectionMenuBarCommand;
import com.pss.pp4is.layout.navigation.submenu.links.lists.UserMenuBarCommand;
import com.pss.pp4is.layout.navigation.submenu.links.reports.SystemUsageMenuBarCommand;
import com.pss.pp4is.layout.navigation.submenu.links.reports.UserActivitiesMenuBarCommand;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.MenuBar;

/**
 *
 * @author Nedzad
 */
public class MainMenuBar extends MenuBar {

    private final LayoutController layoutController;
    
    public MainMenuBar(LayoutController layoutController) {
        this.layoutController = layoutController;
        setWidth("1024px");
        setHeight("28px");
        setAutoOpen(true);
    }

    void initWelcomeMenu() {
        MenuItem menuItem = addItem(layoutController.getI18n().translate("PP4I SYSTEM"), null);
        
        menuItem.addItem(layoutController.getI18n().translate("WELCOME"), new WelcomeMenuBarCommand(layoutController));
        menuItem.addItem(layoutController.getI18n().translate("ENGLISH"), new EnglishMenuBarCommand(layoutController));
        menuItem.addItem(layoutController.getI18n().translate("MAGYAR"), new MagyarMenuBarCommand(layoutController));
        menuItem.addItem(layoutController.getI18n().translate("LOGIN"), new LoginMenuBarCommand(layoutController));
    }

    public void initAuthenticatedMenuBar() {
        MenuItem menuItemSystem = addItem(layoutController.getI18n().translate("PP4I SYSTEM"), null);
        MenuItem selectedItem = menuItemSystem.addItem(layoutController.getI18n().translate("WELCOME"), new WelcomeMenuBarCommand(layoutController));
        if(layoutController.getMenuSelected()==null) {
            layoutController.setMenuSelected(selectedItem);
        }
        
        menuItemSystem.addItem(layoutController.getI18n().translate("ENGLISH"), new EnglishMenuBarCommand(layoutController));
        menuItemSystem.addItem(layoutController.getI18n().translate("MAGYAR"), new MagyarMenuBarCommand(layoutController));
        menuItemSystem.addItem(layoutController.getI18n().translate("RESTART CLOCK"), new RestartClockMenuBarCommand(layoutController));
        menuItemSystem.addItem(layoutController.getI18n().translate("EXIT"), new ExitMenuBarCommand(layoutController));
        menuItemSystem.addItem(layoutController.getI18n().translate("TRANSLATION"), new TranslationMenuBarCommand(layoutController));
        
        MenuItem menuItemLists = addItem(layoutController.getI18n().translate("LISTS"), null);
       
        menuItemLists.addItem(layoutController.getI18n().translate("Products and inspections".toUpperCase()), new ProductInspectionMenuBarCommand(layoutController));
        menuItemLists.addItem(layoutController.getI18n().translate("Document languages".toUpperCase()), new DocumentLanguageMenuBarCommand(layoutController));
        menuItemLists.addItem(layoutController.getI18n().translate("Document types".toUpperCase()), new DocumentTypeMenuBarCommand(layoutController));
        menuItemLists.addItem(layoutController.getI18n().translate("Document print companies".toUpperCase()), new DocumentCompaniesMenuBarCommand(layoutController));
        menuItemLists.addItem(layoutController.getI18n().translate("Inspection profiles".toUpperCase()), new InspectionProfileMenuBarCommand(layoutController));
        menuItemLists.addItem(layoutController.getI18n().translate("Users".toUpperCase()), new UserMenuBarCommand(layoutController));
        
        MenuItem menuItemReports = addItem(layoutController.getI18n().translate("REPORTS"), null);
       
        menuItemReports.addItem(layoutController.getI18n().translate("System usage".toUpperCase()), new SystemUsageMenuBarCommand(layoutController));
        menuItemReports.addItem(layoutController.getI18n().translate("User activities".toUpperCase()), new UserActivitiesMenuBarCommand(layoutController));
        
        MenuItem menuItemHelp = addItem(layoutController.getI18n().translate("HELP"), null);
       
        menuItemHelp.addItem(layoutController.getI18n().translate("Information".toUpperCase()), new InformationMenuBarCommand(layoutController));
        menuItemHelp.addItem(layoutController.getI18n().translate("Lists".toUpperCase()), new ListMenuBarCommand(layoutController));
        menuItemHelp.addItem(layoutController.getI18n().translate("Images".toUpperCase()), new ImageMenuBarCommand(layoutController));
        menuItemHelp.addItem(layoutController.getI18n().translate("Reports".toUpperCase()), new ReportMenuBarCommand(layoutController));
        menuItemHelp.addItem(layoutController.getI18n().translate("About".toUpperCase()), new AboutMenuBarCommand(layoutController));
           
        
    }
    
}
