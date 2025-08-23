package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Biblioteca;
import br.edu.ifba.saj.fwads.FeiraDeCiencia.Feira;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.util.StringConverter;

public class ListFeiraController {
@FXML
    private ChoiceBox<Feira> ListFeira;

    @FXML 
    private void initialize() {
        ListFeira.setConverter(new StringConverter<Feira>() {
            @Override
            public String toString(Feira obj) {
                if (obj != null) {
                    return obj.getNome();
                }
                return "";
            }

            @Override
            public Feira fromString(String stringFeira) {
                return Biblioteca.listaFeiras
                    .stream()
                    .filter(Feira -> stringFeira.equals(Feira.getNome()))
                    .findAny()
                    .orElse(null);                
            }
        });
        
        carregarListaFeiras();
    }
    @FXML
    private void limparTela() {
        //txTitulo.setText("");
        //txSubTitulo.setText("");
        //txISBN.setText("");
        //Todo REVER
        ListFeira.setSelectionModel(null);
    }

    private void carregarListaFeiras() {
        ListFeira.setItems(Biblioteca.listaFeiras);
    }
}
