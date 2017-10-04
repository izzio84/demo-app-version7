package org.test.sette;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("org.test.sette.MyAppWidgetset")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Panel panel = new Panel("Panel");
        panel.setHeight("2000px");
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSizeFull();
        layout.setSpacing(true);
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener(e -> {
            layout.addComponent(new Label("Thanks " + name.getValue()
                    + ", it works!"));
        });

        List<String> planets = new ArrayList<>();
        planets.add("a");
        planets.add("b");
        planets.add("c");
        planets.add("d");
        planets.add("e");
        planets.add("f");
        planets.add("g");
        planets.add("h");
        planets.add("i");
        planets.add("l");
        planets.add("m");

        ComboBox select = new ComboBox("Select or Add a Planet");
        for (String string : planets) {
            select.addItem(string);
        }

        layout.addComponents(name, button, select);
        layout.setComponentAlignment(select, Alignment.BOTTOM_CENTER);
        panel.setContent(layout);
        setContent(panel);
    }

}
