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
import com.vaadin.flow.component.checkbox.Checkbox;
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

import java.util.ArrayList;
import java.util.List;


@Route("def")
public class ClientPage extends VerticalLayout {
    Producto preboda = new Producto(1,"preboda",1000.00);
    Producto boda = new Producto(2,"boda",5000.00);
    Producto cumple = new Producto(3,"cumple",3000.00);
    Producto videv = new Producto(4,"video evento",4000.00);
    List<Producto> list = new ArrayList<Producto>();
    public ClientPage() {
        LoginOverlay component = new LoginOverlay();
        component.addLoginListener(e -> {
            if (e.getUsername().equals("admin") && e.getPassword().equals("admin"))
                component.close();
            else
                component.setError(true);
        });
        component.setOpened(true);

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
        accordion.close();
        VerticalLayout prebodaLayout = new VerticalLayout();
        H2 titulo1 = new H2("El plan para sesiones de foto previos a la boda.");
        Html img1 = new Html("<img src='https://qph.fs.quoracdn.net/main-qimg-9bd8998b214dad85571ec00608207f90'>");
        H3 precio1 = new H3("$"+preboda.getPrecio().toString());
        Checkbox check1 = new Checkbox("Seleccionar");
        prebodaLayout.add(titulo1,img1,precio1,check1);
        prebodaLayout.setHorizontalComponentAlignment(Alignment.CENTER,titulo1,img1,precio1,check1);

        accordion.add("Paquete Pre-Boda", prebodaLayout);

        VerticalLayout bodaLayout = new VerticalLayout();
        H2 titulo2 = new H2("El plan para sesiones de fotos de boda.");
        Html img2 = new Html("<img src='https://d1zpvjny0s6omk.cloudfront.net/media/cache/bf/b9/bfb90422e7dda7296ff2d6912db4c1b3.jpg'>");
        H3 precio2 = new H3("$"+boda.getPrecio().toString());
        Checkbox check2 = new Checkbox("Seleccionar");
        bodaLayout.add(titulo2,img2,precio2,check2);

        accordion.add("Paquete Boda", bodaLayout);
        prebodaLayout.setHorizontalComponentAlignment(Alignment.CENTER,titulo2,img2,precio2,check2);

        VerticalLayout videoventoLayout = new VerticalLayout();
        Checkbox check3 = new Checkbox("Seleccionar");

        videoventoLayout.add(
                new TextField("Name"),
                new TextField("Phone"),
                new TextField("Email"),check3

        );
        accordion.add("Paquete Video Evento", videoventoLayout);

        VerticalLayout cumpleLayout = new VerticalLayout();
        Checkbox check4 = new Checkbox("Seleccionar");
        cumpleLayout.add(
                new TextField("Name"),
                new TextField("Phone"),
                new TextField("Email"),check4
        );
        accordion.add("Paquete de cumple", cumpleLayout);


        add(accordion);
        Button btn = new Button("Comprar");
        VerticalLayout btnLay = new VerticalLayout();
        btnLay.setHorizontalComponentAlignment(Alignment.CENTER, btn);
        add(btn);
          btn.addClickListener(event -> {
              if (check1.getValue()==true){
                  list.add(preboda);
              }
              else if (check2.getValue()==true){
                  list.add(boda);
              }
              else if (check3.getValue()==true){
                  list.add(cumple);
              }
              else if (check4.getValue()==true){
                  list.add(videv);
              }
              else if (check1.getValue()==false && check2.getValue()==false && check3.getValue()==false && check4.getValue()==false) {
                  Notification noti = new Notification("Seleccione un paquete",3000, Notification.Position.TOP_CENTER
                  );
                  noti.open();

              }
          }
        );
    }
}
