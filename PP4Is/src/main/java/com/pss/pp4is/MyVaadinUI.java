package com.pss.pp4is;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.data.models.User;
import com.pss.pp4is.layout.CustomLayout;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import javax.servlet.annotation.WebServlet;

@Theme("pp4istheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI
{
    private LayoutController layoutController;
    private CustomLayout customLayout;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.pss.pp4is.AppWidgetSet", heartbeatInterval = 300)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout layout  = new VerticalLayout();
        layout.setSizeFull();
        layoutController = new LayoutController();
        customLayout = new CustomLayout(layoutController);
        layoutController.setCustomLayout(customLayout);
        layout.addComponent(customLayout);
        setContent(layout);
        User user = null;
        user = (User) UI.getCurrent().getSession().getAttribute("user");
       
        addDetachListener(new DetachListener() {
            @Override
            public void detach(DetachEvent event) {
                System.out.print("Detach");
                DataController.updateUserActivity((User) UI.getCurrent().getSession().getAttribute("user"));
            }
        });
    }

 
}
