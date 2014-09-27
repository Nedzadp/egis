/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.system;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.data.models.User;
import com.pss.pp4is.layout.AbstractCommand;
import com.pss.pp4is.layout.CustomLayout;
import com.pss.pp4is.layout.CustomTimerTask;
import com.pss.pp4is.layout.MainMenuBar;
import com.pss.pp4is.layout.TimerButton;
import com.pss.pp4is.layout.UserLoginHeader;
import com.pss.pp4is.layout.content.MainContentComponent;
import com.pss.pp4is.layout.navigation.CustomButtonLink;
import com.pss.pp4is.layout.navigation.MainMenuNavigationEnum;
import com.pss.pp4is.layout.navigation.MainMenuNavigationLayout;
import com.pss.pp4is.layout.navigation.submenu.CustomSubmenuLink;
import com.pss.pp4is.layout.navigation.submenu.SubMenuNavigationEnum;
import com.pss.pp4is.layout.navigation.submenu.SubMenuNavigationLayout;
import com.vaadin.server.Page;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import java.io.Serializable;
import java.util.List;
import java.util.Timer;

/**
 *
 * @author Nedzad
 */
public class LayoutController implements Serializable{

    private CustomLayout customLayout;
    private CustomButtonLink customButtonLink;
    private CustomSubmenuLink customSubmenuLink;
    private UserLoginHeader userLoginHeader;
    private MainMenuNavigationLayout mainMenuNavigationLayout;
    private SubMenuNavigationLayout subMenuNavigationLayout;
    private MainContentComponent mainContentComponent;
    private User user;
    private I18n i18n;
    private final Timer clockTimer;
    
    private Integer minutes;
    private Integer seconds;
    int delay = 1000;
    int period = 1000;
    private final TimerButton timerButton;
    private CustomTimerTask customTimerTask;
    
    private CustomButtonLink currentRootLinkSelected;
    private CustomSubmenuLink currentSubmenuLinkSelected;
    private ComboBox comboBox;
    
    private String userLabel = null;
    private String fromDateLabel = null;
    private String toDateLabel = null;
    private MenuItem menuSelected;
    
    private MainMenuBar mainMenuBar;
    
    public LayoutController() {
        user = null;
        clockTimer = new Timer();
        timerButton = new TimerButton(this);
    }

    public MenuItem getMenuSelected() {
        return menuSelected;
    }

    public void setMenuSelected(MenuItem menuSelected) {
        this.menuSelected = menuSelected;
    }

    public void setCurrentRootLinkSelected(CustomButtonLink currentRootLinkSelected) {
        this.currentRootLinkSelected = currentRootLinkSelected;
    }

    public CustomButtonLink getCurrentRootLinkSelected() {
        return currentRootLinkSelected;
    }

    public void setCurrentSubmenuLinkSelected(CustomSubmenuLink currentSubmenuLinkSelected) {
        this.currentSubmenuLinkSelected = currentSubmenuLinkSelected;
    }

    public CustomSubmenuLink getCurrentSubmenuLinkSelected() {
        return currentSubmenuLinkSelected;
    }
    
    public void setCustomTimerTask(CustomTimerTask customTimerTask) {
        this.customTimerTask = customTimerTask;
    }

    public CustomTimerTask getCustomTimerTask() {
        return customTimerTask;
    }    
    public TimerButton getTimerButton() {
        return timerButton;
    }
    
    public Integer getMinutes() {
        return minutes;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }
    
    public Timer getClockTimer() {
        return clockTimer;
    }
    
    public void runClock(CustomTimerTask clockTimerTask) {
        getClockTimer().scheduleAtFixedRate(clockTimerTask, delay, period);
    }
    
    public void setI18n(I18n i18n) {
        this.i18n = i18n;
    }

    public I18n getI18n() {
        return i18n;
    }
    
    public void setCustomLayout(CustomLayout customLayout) {
        this.customLayout = customLayout;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public CustomLayout getCustomLayout() {
        return customLayout;
    }

    public MainMenuNavigationLayout getMainMenuNavigationLayout() {
        return mainMenuNavigationLayout;
    }

    public void setMainMenuNavigationLayout(MainMenuNavigationLayout mainMenuNavigationLayout) {
        this.mainMenuNavigationLayout = mainMenuNavigationLayout;
    }

    public SubMenuNavigationLayout getSubMenuNavigationLayout() {
        return subMenuNavigationLayout;
    }

    public void setSubMenuNavigationLayout(SubMenuNavigationLayout subMenuNavigationLayout) {
        this.subMenuNavigationLayout = subMenuNavigationLayout;
    }

    public MainContentComponent getMainContentComponent() {
        return mainContentComponent;
    }

    public void setMainContentComponent(MainContentComponent mainContentComponent) {
        this.mainContentComponent = mainContentComponent;
    }

    public void setCustomButtonLink(CustomButtonLink customButtonLink) {
        this.customButtonLink = customButtonLink;
    }

    public CustomButtonLink getCustomButtonLink() {
        return customButtonLink;
    }
    
    public void fixSelectedMenu(CustomButtonLink customButtonLink) {
        if(getCustomButtonLink() != null) {
            getCustomButtonLink().removeStyleName("selected");
        }
        
        setCustomButtonLink(customButtonLink);
        
        getCustomButtonLink().addStyleName("selected");
        
        setCurrentRootLinkSelected(getCustomButtonLink());
    }
    public void buildSubMenu(int rootMainMenu,HorizontalLayout menu, boolean authenticated) {
        menu.removeAllComponents();
        boolean check = true;
        List<SubMenuNavigationEnum> subMenus = SubMenuNavigationEnum.getSubmenusByRootMenu(rootMainMenu,authenticated);
        for(SubMenuNavigationEnum subMenu : subMenus) {
            if(subMenu.equals(SubMenuNavigationEnum.SUB_MENU_TRANSLATION)) {
                continue;
            }
            CustomSubmenuLink link = subMenu.getInstance();
            link.setLayoutController(this);
            link.addCaption();
            link.setCustomSubmenuLinkId(subMenu.getRow()*10);
            
            if(check && getCurrentSubmenuLinkSelected()==null) {
                check = false;
                fixSelectedSubMenu(link);
            }
            if(link.equals(getCurrentSubmenuLinkSelected())) {
                fixSelectedSubMenu(link);
            }
            
            menu.addComponent(link);
        }
        if(rootMainMenu == MainMenuNavigationEnum.MAIN_MENU_HOME_LINK.getRow() && authenticated && getUser().isSuperUser()) {
            boolean check2 = true;
            CustomSubmenuLink link = SubMenuNavigationEnum.SUB_MENU_TRANSLATION.getInstance();
            link.setLayoutController(this);
            link.addCaption();
            link.setCustomSubmenuLinkId(SubMenuNavigationEnum.SUB_MENU_TRANSLATION.getRow()*10);
            
            if(check2 && getCurrentSubmenuLinkSelected()==null) {
                check2 = false;
                fixSelectedSubMenu(link);
            }
            if(link.equals(getCurrentSubmenuLinkSelected())) {
                fixSelectedSubMenu(link);
            }
            
            menu.addComponent(link);
        }
    }


    public CustomSubmenuLink getCustomSubmenuLink() {
        return customSubmenuLink;
    }
    
    private void setCustomSubmenuLink(CustomSubmenuLink customSubmenuLink) {
        this.customSubmenuLink = customSubmenuLink;
    }
    
    public void fixSelectedSubMenu(CustomSubmenuLink customSubmenuLink) {
        
        if(getCustomSubmenuLink()!=null) {   
            getCustomSubmenuLink().removeStyleName("sub-menu-selected");
        }
        setCustomSubmenuLink(customSubmenuLink);
        getCustomSubmenuLink().addStyleName("sub-menu-selected");
        if(!getCustomSubmenuLink().getCustomSubmenuLinkId().equals(SubMenuNavigationEnum.SUB_MENU_ENGLISH.getRow()*10) || !getCustomSubmenuLink().getCustomSubmenuLinkId().equals(SubMenuNavigationEnum.SUB_MENU_MAGYAR.getRow()*10)){
            setCurrentSubmenuLinkSelected(getCustomSubmenuLink());
        }
    }

    public void setUserLogin(UserLoginHeader userLoginHeader) {
       this.userLoginHeader = userLoginHeader;
    }

    public UserLoginHeader getUserLoginHeader() {
        return userLoginHeader;
    }
    
    public void refreshLayout() {
        getUserLoginHeader().removeAllComponents();
        getMainMenuNavigationLayout().removeAllComponents();
        getSubMenuNavigationLayout().removeAllComponents();
        getMainContentComponent().removeAllComponents();
        getMainContentComponent().initWelcomeLayout();
        getUserLoginHeader().refreshLayout();
        getMainMenuNavigationLayout().initLayoutForAuthenticatedUser();
        getSubMenuNavigationLayout().initLayoutForAuthenticatedUser();
    }
    
     public void refreshLanguageLayoutAuthenticated() {
        getMainMenuNavigationLayout().removeAllComponents();
        getSubMenuNavigationLayout().removeAllComponents();
        getMainContentComponent().removeAllComponents();
        getMainMenuNavigationLayout().initLayoutForAuthenticatedUser();
        getSubMenuNavigationLayout().initLayoutForAuthenticatedUserWithLanguage();
    }
    
    
    public void refreshLanguageLayout() {
        getCustomLayout().removeAllComponents();
        getCustomLayout().initNewStyle();
    }
    
    
    public void showNotification() {
        Notification notification = new Notification(getI18n().translate("Warning"), getI18n().translate("Click on the clock to restart it, please. Otherwise system will log you out within a minute."), Notification.Type.WARNING_MESSAGE);
        notification.setDelayMsec(1);
        notification.show(Page.getCurrent());
        //Notification.show(getI18n().translate("Warning"), getI18n().translate("Click on the clock to restart it, please. Otherwise system will log you out within a minute."), Notification.Type.WARNING_MESSAGE);
    }
    
    public void automaticallyLogout() {
        DataController.updateUserActivity(getUser());
        setUser(null);
        setCurrentRootLinkSelected(null);
        setCurrentSubmenuLinkSelected(null);
        getCustomTimerTask().cancel();
        setCustomButtonLink(null);
        setCustomButtonLink(null);
        getCustomLayout().removeAllComponents();
        getCustomLayout().initNewStyle();
        Notification notification = new Notification(getI18n().translate("Timer"),getI18n().translate("You have been automatically logged out!"), Notification.Type.WARNING_MESSAGE);
        notification.setDelayMsec(1);
        notification.show(Page.getCurrent());
        //Notification.show(getI18n().translate("Timer"),getI18n().translate("You have been automatically logged out!"), Notification.Type.WARNING_MESSAGE);
    }

    public void setLanguageComboBox(ComboBox comboBox) {
        this.comboBox = comboBox;
    }

    public ComboBox getComboBox() {
        return comboBox;
    }
    public void setUserLabel(String userLabel) {
        this.userLabel = userLabel;
    }

    public String getUserLabel() {
        return userLabel;
    }

    public void setFromDateLabel(String fromDateLabel) {
        this.fromDateLabel = fromDateLabel;
    }

    public String getFromDateLabel() {
        return fromDateLabel;
    }

    public void setToDateLabel(String toDateLabel) {
        this.toDateLabel = toDateLabel;
    }

    public String getToDateLabel() {
        return toDateLabel;
    }

    public void refreshNewLayout() {
        getUserLoginHeader().removeAllComponents();
        getUserLoginHeader().refreshNewLayout();
        getMainMenuBar().removeItems();
        getMainMenuBar().initAuthenticatedMenuBar();
        getMainContentComponent().removeAllComponents();
        getMainContentComponent().initWelcomeLayout();
    }

    public void setMainMenuBar(MainMenuBar mainMenuBar) {
        this.mainMenuBar = mainMenuBar;
    }

    public MainMenuBar getMainMenuBar() {
        return mainMenuBar;
    }

    public void setMainContentPanel(Panel mainContentPanel) {
        this.mainContentPanel = mainContentPanel;
    }

    public Panel getMainContentPanel() {
        return mainContentPanel;
    }
    
    private  Panel mainContentPanel;

    public void refreshLanguageNewLayoutAuthenticated() {
        getMainMenuBar().removeItems();
        getMainMenuBar().initAuthenticatedMenuBar();
        getUserLoginHeader().refreshLabelTranslate();
    }
}
