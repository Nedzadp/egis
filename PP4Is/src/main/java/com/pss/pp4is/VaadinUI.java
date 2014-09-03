/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is;

import com.vaadin.data.Item;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.BaseTheme;

/**
 *
 * @author Nedzad
 */
public class VaadinUI extends  VerticalLayout{

    public VaadinUI() {
    
            final VerticalLayout layout = new VerticalLayout();
        //layout.setMargin(true);
        layout.setSizeFull();
        
        VerticalLayout layout2 = new VerticalLayout();
        
        
        layout.addComponent(layout2);
        
        layout2.addStyleName("vertical-custom-layout");
       
        HorizontalLayout hLayout = new HorizontalLayout();
        //
        hLayout.setWidth("100%");
        hLayout.setMargin(true);
        
        HorizontalLayout leftHLayout = new HorizontalLayout();
        leftHLayout.setWidth("120px");
        
        Embedded flagOne = new Embedded("", new ThemeResource("images/hungary-flag.png"));
        leftHLayout.addComponent(flagOne);
       
        Embedded flagTwo = new Embedded("", new ThemeResource("images/united-kingdom-flag.png"));
        leftHLayout.addComponent(flagTwo);
        
        Embedded flagThree = new Embedded("", new ThemeResource("images/germany-flag.png"));
        leftHLayout.addComponent(flagThree);
        
        hLayout.addComponent(leftHLayout);
        hLayout.setComponentAlignment(leftHLayout, Alignment.TOP_LEFT);
        
        layout2.addComponent(hLayout);
        
        HorizontalLayout rightHLayout = new HorizontalLayout();
        rightHLayout.setMargin(true);
        rightHLayout.setWidth("350px");
        hLayout.addComponent(rightHLayout);
        hLayout.setComponentAlignment(rightHLayout, Alignment.TOP_RIGHT);
        
        TextField username = new TextField();
        username.setInputPrompt("username");
        username.addStyleName("align-right");
        rightHLayout.addComponent(username);
        PasswordField password = new PasswordField();
        password.setInputPrompt("password");
        rightHLayout.addComponent(password);
        
        HorizontalLayout hrLine = new HorizontalLayout();
        hrLine.setHeight("10px");
        hrLine.addStyleName("hrline2");
        layout2.addComponent(hrLine);
        
        HorizontalLayout hrLine2 = new HorizontalLayout();
        hrLine2.setWidth("300px");
        hrLine2.addStyleName("hrline");
        
        hrLine.addComponent(hrLine2);
        hrLine.setComponentAlignment(hrLine2, Alignment.TOP_LEFT);
        
        Resource res = new ThemeResource("images/logo.jpg");
        // Display the image without caption
        Image image = new Image(null, res);
        layout2.addComponent(image);
        
        
        HorizontalLayout mainMenuBar = new HorizontalLayout();
        
        Button mainMenu1 = new Button("Main menu bar");
        mainMenuBar.addComponent(mainMenu1);
        mainMenu1.addStyleName(BaseTheme.BUTTON_LINK);
        mainMenu1.addStyleName("main-menu-button");
        
        Button mainMenu2 = new Button("Main menu bar 2");
        mainMenuBar.addComponent(mainMenu2);
        mainMenu2.addStyleName(BaseTheme.BUTTON_LINK);
        mainMenu2.addStyleName("main-menu-button");
        
        Button mainMenu3 = new Button("Main menu bar 3");
        mainMenuBar.addComponent(mainMenu3);
        mainMenu3.addStyleName(BaseTheme.BUTTON_LINK);
        mainMenu3.addStyleName("main-menu-button");
        
        layout2.addComponent(mainMenuBar);
        
        
        HorizontalLayout subMenuFirstLayout = new HorizontalLayout();
        subMenuFirstLayout.addStyleName("submenu");
        
        
        HorizontalLayout subMenuLayout = new HorizontalLayout();
        subMenuFirstLayout.addComponent(subMenuLayout);
        layout2.addComponent(subMenuFirstLayout);
        
        Button mainMenu4 = new Button("Sub menu");
        subMenuLayout.addComponent(mainMenu4);
        mainMenu4.addStyleName(BaseTheme.BUTTON_LINK);
        mainMenu4.addStyleName("sub-menu-button");
        
        Button mainMenu5 = new Button("Sub menu 2");
        subMenuLayout.addComponent(mainMenu5);
        mainMenu5.addStyleName(BaseTheme.BUTTON_LINK);
        mainMenu5.addStyleName("sub-menu-button");
        
        Button mainMenu6 = new Button("Sub menu 3");
        subMenuLayout.addComponent(mainMenu6);
        mainMenu6.addStyleName(BaseTheme.BUTTON_LINK);
        mainMenu6.addStyleName("sub-menu-button");
        
        Button mainMenu7 = new Button("Sub menu 4");
        subMenuLayout.addComponent(mainMenu7);
        mainMenu7.addStyleName(BaseTheme.BUTTON_LINK);
        mainMenu7.addStyleName("sub-menu-button");
        
        
        
        
        HorizontalLayout mainContentLayout = new HorizontalLayout();
        mainContentLayout.setHeight("100%");
        layout2.addComponent(mainContentLayout);
        mainContentLayout.setMargin(true);
        mainContentLayout.setSpacing(true);
        // content 
        // left
        VerticalLayout mainContentLayoutLeft = new VerticalLayout();
        mainContentLayout.addComponent(mainContentLayoutLeft);
        
        mainContentLayoutLeft.addStyleName("left-panel");
        FormLayout formLayout = new FormLayout();
        formLayout.setCaption("Header 1");
        
        mainContentLayoutLeft.addComponent(formLayout);
        NativeSelect select1 = new NativeSelect();
        select1.addItem("Testing");
        formLayout.addComponent(select1);
        
        VerticalLayout mainContentLayoutRight = new VerticalLayout();
        mainContentLayout.addComponent(mainContentLayoutRight);
        
        mainContentLayoutRight.addStyleName("right-panel");
       
        Table table = new Table("The Brightest Stars");

        // Define two columns for the built-in container
        table.addContainerProperty("Name", String.class, null);
        table.addContainerProperty("Mag",  Float.class, null);

        // Add a row the hard way
        Object newItemId = table.addItem();
        Item row1 = table.getItem(newItemId);
        row1.getItemProperty("Name").setValue("Sirius");
        row1.getItemProperty("Mag").setValue(-1.46f);

        // Add a few other rows using shorthand addItem()
        table.addItem(new Object[]{"Canopus",        -0.72f}, 2);
        table.addItem(new Object[]{"Arcturus",       -0.04f}, 3);
        table.addItem(new Object[]{"Alpha Centauri", -0.01f}, 4);


        // Show exactly the currently contained rows (items)
        table.setPageLength(table.size());
        
        mainContentLayoutRight.addComponent(table);
        
      
        HorizontalLayout mainContentLayout2 = new HorizontalLayout();
        mainContentLayout2.setHeight("100%");
        layout2.addComponent(mainContentLayout2);
        mainContentLayout2.setMargin(true);
        mainContentLayout2.setSpacing(true);
        // content 
        // left
        VerticalLayout mainContentLayoutLeft2 = new VerticalLayout();
        mainContentLayout2.addComponent(mainContentLayoutLeft2);
        
        mainContentLayoutLeft2.addStyleName("left-panel");
        FormLayout formLayout2 = new FormLayout();
        formLayout2.setCaption("Header 1");
        
        mainContentLayoutLeft2.addComponent(formLayout2);
        NativeSelect select2 = new NativeSelect();
        select2.addItem("Testing");
        formLayout2.addComponent(select2);
        
        VerticalLayout mainContentLayoutRight2 = new VerticalLayout();
        mainContentLayout2.addComponent(mainContentLayoutRight2);
        
        mainContentLayoutRight2.addStyleName("right-panel");
       
        Table table2 = new Table("The Brightest Stars");

        // Define two columns for the built-in container
        table2.addContainerProperty("Name", String.class, null);
        table2.addContainerProperty("Mag",  Float.class, null);

        // Add a row the hard way
        Object newItemId2 = table2.addItem();
        Item row2 = table2.getItem(newItemId2);
        row2.getItemProperty("Name").setValue("Sirius");
        row2.getItemProperty("Mag").setValue(-1.46f);

        // Add a few other rows using shorthand addItem()
        table2.addItem(new Object[]{"Canopus",        -0.72f}, 2);
        table2.addItem(new Object[]{"Arcturus",       -0.04f}, 3);
        table2.addItem(new Object[]{"Alpha Centauri", -0.01f}, 4);


        // Show exactly the currently contained rows (items)
        table2.setPageLength(table2.size());
        
        mainContentLayoutRight2.addComponent(table2);

    }
    
}
