package com.example.application.views.main.ficha;
import java.util.Map;

import com.example.application.views.main.ficha.Ficha;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Input;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.textfield.TextArea;

import com.api.persistencia.FichaDAO;

public class Ficha extends Div {
    Map<String, String> charInfo = Map.of(
            "nome", "",
            "classe", "",
            "background", "",
            "raca", "",
            "alinhamento", "");

    public Ficha() {
        HorizontalLayout h = new HorizontalLayout(fichaStatus(), fichaStatus2(), fichaStatus3(), fichaStatus4());
        h.setWidthFull();

        HorizontalLayout h2 = new HorizontalLayout(btnSalvar());
        h2.setWidthFull();
        h2.setJustifyContentMode(JustifyContentMode.END);

        add(
                new VerticalLayout(
                        h2,
                        fichaInfo(),
                        h));
    }

    private Button btnSalvar(){

    FichaDAO dao = new FichaDAO();
    
    Button btn = new Button("Salvar");

    btn.addClickListener(click -> {
        dao.inserir2();
    });
    return btn;
    }

    private HorizontalLayout fichaInfo() {
        String nome = charInfo.get("nome");
        String classe = charInfo.get("classe");
        String background = charInfo.get("background");
        String raca = charInfo.get("raca");
        String alinhamento = charInfo.get("alinhamento");

        HorizontalLayout h = new HorizontalLayout();
        h.addClassName("background");
        h.setWidthFull();

        VerticalLayout nomeContainer = inputContainer("Nome do personagem", nome, "nome", "input-nome");
        nomeContainer.addClassNames("has-float-label", "center");
        nomeContainer.setWidth("50%");
        nomeContainer.setJustifyContentMode(JustifyContentMode.CENTER);

        VerticalLayout status = new VerticalLayout();
        status.setWidth("50%");
        HorizontalLayout r1 = new HorizontalLayout();
        HorizontalLayout r2 = new HorizontalLayout();

        r1.add(
                inputContainer("Classe e Nível", classe, "classe", ""),
                inputContainer("Antecedente", background, "background", ""));

        r2.add(
                inputContainer("Alinhamento", alinhamento, "alinhamento", ""),
                inputContainer("Raça", raca, "raca", ""));

        status.add(r1, r2);

        h.add(nomeContainer, status);
        return h;
    }

    private VerticalLayout fichaStatus() {
        VerticalLayout container = new VerticalLayout();
        container.addClassName("background");
        container.setWidth("10rem");
        container.setHeight("fit-content");
        container.add(verticalBox("Força", 10, true, 1, "100%", "forca"));
        container.add(verticalBox("Destreza", 10, true, 1, "100%", "destreza"));
        container.add(verticalBox("Constituição", 10, true, 1, "100%", "constituição"));
        container.add(verticalBox("Intêligencia", 10, true, 1, "100%", "inteligencia"));
        container.add(verticalBox("Sabedoria", 10, true, 1, "100%", "sabedoria"));
        container.add(verticalBox("Carisma", 10, true, 1, "100%", "carisma"));

        return container;
    }

    private VerticalLayout fichaStatus2() {
        VerticalLayout container = new VerticalLayout();
        container.setWidth("20%");

        HorizontalLayout inspiracaoContainer = horizontalLabel("Inspiração", "text-center");
        HorizontalLayout proficienciaContainer = horizontalLabel("Proficiência", "text-center", "rounded");
        HorizontalLayout sabContainer = horizontalLabel("Sabedoria Passiva", "text-center", "rounded");

        VerticalLayout salvaguardas = ComboLabel(
                "Salvaguardas",
                "Força",
                "Destreza",
                "Constituição",
                "Inteligência",
                "Sabedoria",
                "Carisma");
        VerticalLayout pericias = ComboLabel(
                "Perícias",
                "Acrobacia",
                "Arcanismo",
                "Atletismo",
                "Atuação",
                "Enganação",
                "Furtividade",
                "História",
                "Intimidação",
                "Intuição",
                "Investigação",
                "Lidar com animais",
                "Medicina",
                "Natureza",
                "Percepção",
                "Persuasão",
                "Prestidigitação",
                "Religião",
                "Sobrevivência");

        container.add(inspiracaoContainer, proficienciaContainer, salvaguardas, pericias, sabContainer);
        return container;
    }

    private VerticalLayout fichaStatus3() {
        VerticalLayout container = new VerticalLayout();
        container.setWidth("30%");
        container.addClassName("background");

        HorizontalLayout cards1 = new HorizontalLayout(
                verticalBox("Classe de Armadura", 10, false, -1, "30%", ""),
                verticalBox("Iniciativa", 10, false, -1, "30%", ""),
                verticalBox("Deslocamento", 10, false, -1, "30%", ""));
        cards1.setJustifyContentMode(JustifyContentMode.BETWEEN);

        container.add(
                cards1,
                horizontalInput("Pontos de vida Atuais", true, "Pontos de vida máximos"),
                horizontalInput("Pontos de vida Temporários", false, ""),
                horizontalInput("Dado de Vida", true, "Total"),
                horizontalTextArea("Equipamento", ""));
        return container;
    }

    private VerticalLayout fichaStatus4() {
        VerticalLayout container = new VerticalLayout();
        container.setWidth("30%");
        container.addClassName("background");

        container.add(
                horizontalTextArea("Traços de personalidade", ""),
                horizontalTextArea("Ideais", ""),
                horizontalTextArea("Vínculos", ""),
                horizontalTextArea("Fraquezas", ""),
                horizontalTextArea("Características & talentos", "300px"));

        return container;
    }

    private VerticalLayout inputContainer(
            String txt,
            String valor,
            String campo,
            String inputClassName) {
        Div label = new Div(new Text(txt));
        Input input = new Input();

        input.setValue(valor);
        input.addBlurListener(blur -> {
            charInfo.put(campo, input.getValue());
        });
        if (inputClassName != "") {
            input.addClassName(inputClassName);
        }

        VerticalLayout container = new VerticalLayout(label, input);
        container.addClassName("has-float-label");

        return container;
    }

    private VerticalLayout verticalBox(String txt, int valor, boolean has2, int valor2, String width, String campo) {
        Input input = new Input();
        input.setValue(valor + "");
        input.addBlurListener(listener -> {
            // System.out.println(input.getValue());
            System.out.print("teste");
        });
        VerticalLayout box = new VerticalLayout(
                new Div(new Text(txt)),
                input);
        box.setWidth(width);
        box.setHeight("115px");
        box.addClassName("box-status");

        if (has2) {
            Input input2 = new Input();
            input2.setValue(valor2 + "");
            input2.addClassName("input-float");
            box.add(input2);
        }

        return box;
    }

    private HorizontalLayout horizontalLabel(String ttl, String... inputClasses) {
        HorizontalLayout container = new HorizontalLayout();
        container.setWidth("100%");

        Input input = new Input();
        input.addClassNames(inputClasses);
        input.setWidth("51px");
        input.setHeight("51px");

        Div label = new Div(new H3(ttl));
        label.addClassNames("text-center", "background", "pt-5");
        label.setWidth("95%");

        container.add(input, label);
        return container;
    }

    private VerticalLayout ComboLabel(String ttl, String... inputs) {
        VerticalLayout container = new VerticalLayout();
        container.setWidth("100%");
        container.addClassName("background");

        HorizontalLayout ttlContainer = new HorizontalLayout(new H4(ttl));
        ttlContainer.setWidthFull();
        ttlContainer.setJustifyContentMode(JustifyContentMode.CENTER);

        for (String input : inputs) {
            HorizontalLayout h = new HorizontalLayout(
                    new Checkbox(),
                    new H5(input));
            h.setWidthFull();
            ;
            // h.setJustifyContentMode(JustifyContentMode.BETWEE);

            container.add(h);
        }
        container.add(ttlContainer);

        return container;
    }

    private VerticalLayout horizontalInput(String ttl, boolean has2, String ttl2) {
        VerticalLayout container = new VerticalLayout();
        container.setWidthFull();
        container.addClassName("background");
        container.setAlignItems(Alignment.CENTER);

        if (has2) {
            Input input = new Input();

            HorizontalLayout containerH = new HorizontalLayout(
                new H6(ttl2),
                input
                );
            containerH.setWidth("100%");
                    container.add(
                    containerH);

        }

        Input bigInput = new Input();
        bigInput.addClassName("input-grande");

        container.add(
                bigInput,
                new H4(ttl));

        return container;
    }

    private VerticalLayout horizontalTextArea(String ttl, String minH) {
        VerticalLayout container = new VerticalLayout();
        container.setWidthFull();
        container.addClassName("background");
        container.setAlignItems(Alignment.CENTER);

        TextArea textArea = new TextArea();
        textArea.setWidthFull();

        if(minH != ""){
            textArea.setMinHeight(minH);
        }

        container.add(
                textArea,
                new H4(ttl));

        return container;
    }
}
