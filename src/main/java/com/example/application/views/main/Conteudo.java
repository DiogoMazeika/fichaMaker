package com.example.application.views.main;

import com.vaadin.flow.component.html.Div;

import java.util.Map;

import com.example.application.views.main.ficha.Ficha;

public class Conteudo extends Div {
    Div aba;
    private static Map<String, Div> abas = Map.of("Minhas fichas", new Ficha());

    public Conteudo(String aba) {
        this.aba = abas.get(aba);
        add(this.aba);
    }

    public void changeAba(String aba) {
        remove(this.aba);
        this.aba = abas.get(aba);
        add(this.aba);
    }

}
