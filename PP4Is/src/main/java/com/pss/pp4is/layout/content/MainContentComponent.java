/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.layout.content;

import com.pss.pp4is.data.models.ListingMiddleContent;
import com.pss.pp4is.data.models.MiddleContentBlue;
import com.pss.pp4is.data.models.RightSideListing;
import com.pss.pp4is.data.models.SecondMiddleContent;
import com.pss.pp4is.data.models.SecondSideListing;
import com.pss.pp4is.layout.content.views.listing.MainContentNewProductInspectionLayout;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.event.LayoutEvents;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Nedzad
 */
public class MainContentComponent extends  VerticalLayout{
    
    private final LayoutController layoutController;
    public MainContentComponent(LayoutController layoutController) {
        this.layoutController = layoutController;
    }
    
    public final void initLayout() {
        if(layoutController.getI18n().getLanguageEnum().getLang().equals("eng")) {
            addComponent(new CustomLayout("home_eng"));
        } else if(layoutController.getI18n().getLanguageEnum().getLang().equals("hun")) {
            addComponent(new CustomLayout("home_hun"));
        }
        
        
        
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        MainContentNewProductInspectionLayout inspectionLayout = new MainContentNewProductInspectionLayout(layoutController);
        inspectionLayout.initLayout();
        horizontalLayout.addComponent(inspectionLayout);
       // horizontalLayout.addStyleName("mainContainer");
        
        final AbsoluteLayout leftSideLayout = new AbsoluteLayout();
        leftSideLayout.setWidth("200");
        leftSideLayout.setHeight("200");
        leftSideLayout.addStyleName("left-side-layout");
        final VerticalLayout rightSideLayout = new VerticalLayout();
        rightSideLayout.addStyleName("right-side-layout");
        // first row
        final ListingMiddleContent middleContent = new ListingMiddleContent(2);
        middleContent.addLayoutClickListener(new LayoutEvents.LayoutClickListener() {

           @Override
           public void layoutClick(LayoutEvents.LayoutClickEvent event) {
               
               Notification.show(event.getComponent().getStyleName()+" Hello layout client X,Y: "+event.getClientX()+" "+event.getClientY()+" relative: "+event.getRelativeX()+" "+event.getRelativeY());
               AbsoluteLayout layout = new AbsoluteLayout();
               rightSideLayout.removeAllComponents();
               Float top = leftSideLayout.getPosition(middleContent).getTopValue();
               layout.setWidth("200");
               layout.setHeight("200");
               Button b1 = new Button("test");
               layout.addComponent(b1, "top: "+top.toString()+"px");
               rightSideLayout.addComponent(layout);
           }
        });
         
        leftSideLayout.addComponent(middleContent,"top: 40px");
       
        // second row
        final ListingMiddleContent middleContent2 = new ListingMiddleContent(2);
        middleContent2.addLayoutClickListener(new LayoutEvents.LayoutClickListener() {

           @Override
           public void layoutClick(LayoutEvents.LayoutClickEvent event) {
               
               Notification.show("Hello layout client X,Y: "+event.getClientX()+" "+event.getClientY()+" relative: "+event.getRelativeX()+" "+event.getRelativeY());
               AbsoluteLayout layout = new AbsoluteLayout();
               rightSideLayout.removeAllComponents();
               layout.setWidth("200");
               layout.setHeight("200");
               Float top = leftSideLayout.getPosition(middleContent2).getTopValue();
               Button b1 = new Button("test");
               layout.addComponent(b1, "top: "+top.toString()+"px");
               rightSideLayout.addComponent(layout);
           }
        });
        Float top = leftSideLayout.getPosition(middleContent).getTopValue();
        top += 60;
        leftSideLayout.addComponent(middleContent2,"top: "+top.toString()+"px");
        
        // second row
        final ListingMiddleContent middleContent3 = new ListingMiddleContent(2);
        middleContent3.addLayoutClickListener(new LayoutEvents.LayoutClickListener() {

           @Override
           public void layoutClick(LayoutEvents.LayoutClickEvent event) {
               
                AbsoluteLayout layout = new AbsoluteLayout();
               rightSideLayout.removeAllComponents();
               layout.setWidth("200");
               layout.setHeight("200");
               Float top = leftSideLayout.getPosition(middleContent3).getTopValue();
               Button b1 = new Button("test");
               layout.addComponent(b1, "top: "+top.toString()+"px");
               rightSideLayout.addComponent(layout);
           }
        });
        Float top2 = leftSideLayout.getPosition(middleContent2).getTopValue();
        top2 += 60;
        leftSideLayout.addComponent(middleContent3,"top: "+top2.toString()+"px");
        
        
        //horizontalLayout.addComponent(leftSideLayout);
        
       // horizontalLayout.addComponent(rightSideLayout);
        
        
        addComponent(horizontalLayout);
        
        
        
        
      /*
        ListingContainer listingContainer = new ListingContainer();
        ListingModel listingModel = new ListingModel();
        listingModel.setListingMiddleContent(new ListingMiddleContent(5));
        listingModel.setValue("5");
        listingModel.setListingMiddleContent2(new RightSideListing(5));
        
        listingContainer.addBean(listingModel);
        
        ListingTable listingTable = new ListingTable(listingContainer);
        
        addComponent(listingTable);
        
        */
    }
    
    public void initWelcomeLayout() {
        if(layoutController.getI18n().getLanguageEnum().getLang().equals("eng")) {
            addComponent(new CustomLayout("welcome_eng"));
        } else if(layoutController.getI18n().getLanguageEnum().getLang().equals("hun")) {
            addComponent(new CustomLayout("welcome_hun"));
        }
    }
}
