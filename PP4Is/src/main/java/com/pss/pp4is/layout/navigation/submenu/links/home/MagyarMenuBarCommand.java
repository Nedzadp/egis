/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.navigation.submenu.links.home;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.layout.AbstractCommand;
import com.pss.pp4is.system.LanguageEnum;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.MenuBar;

/**
 *
 * @author Nedzad
 */
public class MagyarMenuBarCommand extends AbstractCommand {

    public MagyarMenuBarCommand(LayoutController layoutController) {
        super(layoutController);
    }

    @Override
    public void menuSelected(MenuBar.MenuItem selectedItem) {
        
        getLayoutController().getI18n().setLanguageEnum(LanguageEnum.HUNGARIAN);
        if(getLayoutController().getUser()==null) {
            getLayoutController().refreshLanguageLayout();
        } else {
            getLayoutController().refreshLanguageNewLayoutAuthenticated();
            getLayoutController().getMenuSelected().getCommand().menuSelected(getLayoutController().getMenuSelected());
            DataController.updateUserLanguage(getLayoutController().getUser(), getLayoutController().getI18n().getLanguageEnum().getLang());
        }
        getLayoutController().getComboBox().setValue(getLayoutController().getI18n().getLanguageEnum().getLang());
    }
}
