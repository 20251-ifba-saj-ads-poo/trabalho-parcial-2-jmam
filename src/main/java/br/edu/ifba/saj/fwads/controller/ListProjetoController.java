package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Biblioteca;

import br.edu.ifba.saj.fwads.FeiraDeCiencia.Projeto;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.util.StringConverter;

public class ListProjetoController {
    @FXML
    private ChoiceBox<Projeto> ListProjeto;

    @FXML 
    private void initialize() {
        ListProjeto.setConverter(new StringConverter<Projeto>() {
            @Override
            public String toString(Projeto obj) {
                if (obj != null) {
                    return obj.getNome()+":"+obj.getLider();
                }
                return "";
            }

            @Override
            public Projeto fromString(String stringProjeto) {
                return Biblioteca.listaProjetos
                    .stream()
                    .filter(projeto -> stringProjeto.equals(projeto.getNome()))
                    .findAny()
                    .orElse(null);                
            }
        });
        
        carregarListaProjeto();
    }
    @FXML
    private void limparTela() {
        //txTitulo.setText("");
        //txSubTitulo.setText("");
        //txISBN.setText("");
        //Todo REVER
        ListProjeto.setSelectionModel(null);
    }

    private void carregarListaProjeto() {
        ListProjeto.setItems(Biblioteca.listaProjetos);
    }
}

