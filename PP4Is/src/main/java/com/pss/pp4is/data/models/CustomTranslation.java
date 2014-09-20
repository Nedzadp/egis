/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.models;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.system.LanguageEnum;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;

/**
 *
 * @author Nedzad
 */
public class CustomTranslation extends HorizontalLayout{
    
    private final Integer translationId;
    private final String translation;
    private final LanguageEnum languageEnum;
    
    private TextField editField;
    private Button updateButton;
    
    public CustomTranslation(Integer translationId,String translation,LanguageEnum languageEnum) {
        this.translationId = translationId;
        this.translation = translation;
        this.languageEnum = languageEnum;
        initLayout();
    }
    
    private void initLayout() {
        setSpacing(true);
        setMargin(true);
        addComponent(editField = new TextField());
        editField.setWidth("100px");
        editField.setHeight("20px");
        
        if(translation!=null) {
            editField.setValue(translation);
        }
        addComponent(updateButton = new Button("save"));
        
        updateButton.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                if(editField.getValue() != null && !editField.getValue().isEmpty()) {
                    DataController.updateTranslation(translationId,languageEnum,editField.getValue());
                    Notification.show("Info", "Translation updated successfully", Notification.Type.TRAY_NOTIFICATION);
                } else {
                    Notification.show("Error", "Text field is empty", Notification.Type.ERROR_MESSAGE);
                }
            }
        });
    }

    public String getTranslation() {
        return translation;
    }
}
