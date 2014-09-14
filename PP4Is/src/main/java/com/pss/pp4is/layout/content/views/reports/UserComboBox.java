/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.views.reports;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.data.containers.UserContainer;
import com.pss.pp4is.data.models.User;
import com.vaadin.shared.ui.combobox.FilteringMode;
import com.vaadin.ui.ComboBox;

/**
 *
 * @author Nedzad
 */
public class UserComboBox extends ComboBox{

    public UserComboBox() {
        initLayout();
    }
    
    private void initLayout() {
        setCaption("User");
        setNullSelectionAllowed(true);
        setFilteringMode(FilteringMode.CONTAINS);
        setTextInputAllowed(false);
        setNullSelectionItemId("select");
        UserContainer userContainer = DataController.getUsers();
        for(User user : userContainer.getItemIds()) {
            addItem(user.getUsername());
        }
            
    }
}
