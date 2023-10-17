package com.example.application.views.main;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
        Conteudo conteudo = new Conteudo("Minhas fichas");
        conteudo.setWidthFull();

        /* HorizontalLayout abaView = new HorizontalLayout();

        ArrayList<String> abas = new ArrayList<String>() {
            {
                add("Não sei");
                add("Minhas fichas");
            }
        };

        for (String a : abas) {
            Button btn = new Button(a);
            btn.addClickListener(click -> {
                conteudo.changeAba(a);
            });

            abaView.add(btn);
        } */

        add(
                // abaView,
                conteudo);
    }
}
