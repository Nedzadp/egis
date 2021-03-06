/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views;

import com.pss.pp4is.layout.content.CustomVerticalLayout;
import com.vaadin.ui.CustomLayout;


/**
 *
 * @author Nedzad
 */
public class MainContentHomeLayout extends CustomVerticalLayout{

    @Override
    public void initLayout() {
        setMargin(false);
        setSpacing(false);
        if(getLayoutController().getI18n().getLanguageEnum().getLang().equals("eng")) {
            addComponent(new CustomLayout("welcome_eng"));
        } else if(getLayoutController().getI18n().getLanguageEnum().getLang().equals("hun")) {
            addComponent(new CustomLayout("welcome_hun"));
        }
    }
}
