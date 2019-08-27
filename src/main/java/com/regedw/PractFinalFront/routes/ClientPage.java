package com.regedw.PractFinalFront.routes;

import com.regedw.PractFinalFront.Producto;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;



@Route("def")
public class ClientPage extends VerticalLayout {
    public ClientPage() {

     /*   LoginOverlay component = new LoginOverlay();
        component.addLoginListener(e -> {
            if (e.getUsername().equals("admin") && e.getPassword().equals("admin"))
                component.close();
            else
                component.setError(true);
        });
        component.setOpened(true); */

        //  Button btn = new Button("generar");
        //  btn.addClickListener(event -> {
        // Notification noti = new Notification(
        //        emailField.getValue(), 3000, Notification.Position.TOP_CENTER
        //);
        //noti.open();
        //});
        // add(emailField);
        // add(btn);
        Accordion accordion = new Accordion();
        accordion.setWidthFull();
        VerticalLayout prebodaLayout = new VerticalLayout();
        H2 titulo = new H2("El plan para sesiones de foto previos a la boda.");
        Html img = new Html("<img src='https://qph.fs.quoracdn.net/main-qimg-9bd8998b214dad85571ec00608207f90'>");
        H3 precio = new H3();
        prebodaLayout.add(titulo,img,precio);
        prebodaLayout.setHorizontalComponentAlignment(Alignment.CENTER,titulo,img,precio);

        accordion.add("Paquete Pre-Boda", prebodaLayout);

        VerticalLayout bodaLayout = new VerticalLayout();
        bodaLayout.add(
                new H2("El plan para sesiones de fotos de boda."),
                new Html("<img src='https://d1zpvjny0s6omk.cloudfront.net/media/cache/bf/b9/bfb90422e7dda7296ff2d6912db4c1b3.jpg'>"),
                new H3("$5000.00")
        );
        accordion.add("Paquete Boda", bodaLayout);

        VerticalLayout videoventoLayout = new VerticalLayout();
        videoventoLayout.add(
                new TextField("Name"),
                new TextField("Phone"),
                new TextField("Email")
        );
        accordion.add("Paquete Video Evento", videoventoLayout);

        VerticalLayout cumpleLayout = new VerticalLayout();
        cumpleLayout.add(
                new TextField("Name"),
                new TextField("Phone"),
                new TextField("Email")
        );
        accordion.add("Paquete de cumple", cumpleLayout);


        add(accordion);
    }
}
