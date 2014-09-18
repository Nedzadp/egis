/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content.window;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 *
 * @author Nedzad
 */
public class ExitWindow extends Window{

    private final LayoutController layoutController;
    
    public ExitWindow(LayoutController layoutController) {
        this.layoutController = layoutController;
        setCaption(this.layoutController.getI18n().translate("Log out window"));
        initLayout();
        
    }
    
    private void initLayout() {
        center();
        setModal(true);
        setClosable(true);
        setHeight("200px");
        setWidth("300px");
        addStyleName("exit-window");
        setResizable(false);
        VerticalLayout layout = new VerticalLayout();
        layout.setSpacing(true);
        layout.setMargin(true);
        layout.addComponent(new Label(layoutController.getI18n().translate("Do you really want to log out from PP4I system?")));
        
        HorizontalLayout answerButtons = new HorizontalLayout();
        answerButtons.setMargin(true);
        answerButtons.setSpacing(true);
        
        answerButtons.addComponent(new Button(layoutController.getI18n().translate("Yes"), new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                close();
                DataController.updateUserActivity(layoutController.getUser());
                layoutController.getCustomLayout().removeAllComponents();
                layoutController.setUser(null);
                layoutController.getCustomLayout().init();
            }
        }));

        answerButtons.addComponent(new Button(layoutController.getI18n().translate("No"), new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                close();
            }
        }));
        
        layout.addComponent(answerButtons);
        
        setContent(layout);
    }
}
