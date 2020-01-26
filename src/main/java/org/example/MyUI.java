package org.example;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.PushStateNavigation;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.example.ViewNote.ViewNoteStudent;
import org.example.ViewStudent.StudentView;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@PushStateNavigation
public class MyUI extends UI {
Navigator navigator;
    @Override
    protected void init(VaadinRequest vaadinRequest) {

   Button note = new Button("note", e ->{
       getNavigator().navigateTo("noteStudent");
   });
        note.setStyleName(ValoTheme.BUTTON_LINK);
        note.setStyleName(ValoTheme.MENU_ITEM);

        Button chart = new Button("chart", e ->{
            getNavigator().navigateTo("chart");
        });
        chart.setStyleName(ValoTheme.BUTTON_LINK);
        chart.setStyleName(ValoTheme.MENU_ITEM);

        Button student= new Button("student", e ->{
            getNavigator().navigateTo("student");
        });
        student.setStyleName(ValoTheme.BUTTON_LINK);
        student.setStyleName(ValoTheme.MENU_ITEM);
        Label title= new Label("Menu");
        title.setStyleName(ValoTheme.MENU_TITLE);
        CssLayout menu = new CssLayout(title ,note, student, chart);
        menu.setStyleName(ValoTheme.MENU_ROOT);
        CssLayout container = new CssLayout();

        container.setSizeFull();

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSizeFull();
        horizontalLayout.addComponent(menu);
        horizontalLayout.addComponent(container);
        horizontalLayout.setExpandRatio(menu,1.0f);
        menu.setSizeFull();
        horizontalLayout.setExpandRatio(container,5.0F);
        horizontalLayout.setMargin(false);
        container.setSizeFull();
        horizontalLayout.setComponentAlignment(container, Alignment.TOP_CENTER);

        horizontalLayout.setSizeFull();

        setContent(horizontalLayout);
    navigator = new Navigator(this,container);
    navigator.addView("noteStudent", ViewNoteStudent.class);

    navigator.addView("student", StudentView.class);
        navigator.addView("", StudentView.class);
        navigator.addView("chart", Chartt.class);
    }

    @WebServlet( name = "MyUIServlet", asyncSupported = true, value="/*")
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
