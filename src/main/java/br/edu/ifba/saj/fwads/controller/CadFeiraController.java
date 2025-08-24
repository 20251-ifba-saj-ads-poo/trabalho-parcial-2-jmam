package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Biblioteca;
import br.edu.ifba.saj.fwads.FeiraDeCiencia.Feira;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;


public class CadFeiraController {
    @FXML
    private TextField txNome;
/*@FXML
    private TextField txSubTitulo;
    @FXML
    private TextField txISBN;
    @FXML
    private ChoiceBox<Autor> slAutor;*/

    @FXML
    private void salvarFeira(ActionEvent event) {
        Feira novaFeira = new Feira(txNome.getText());
        new Alert(AlertType.INFORMATION, "Cadastrando Feira(Fake):"+novaFeira.toString()).showAndWait();
        Biblioteca.listaFeiras.add(novaFeira);
        limparTela();
      

    }

    /*@FXML 
    private void initialize() {
        slProjeto.setConverter(new StringConverter<Projeto>() {
            @Override
            public String toString(Projeto obj) {
                if (obj != null) {
                    return obj.getNome();
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
*/
    @FXML
    private void limparTela() {
        txNome.setText("");
        //txSubTitulo.setText("");
        //txISBN.setText("");
        //Todo REVER
        //slProjeto.setSelectionModel(null);
    }

    /*private void carregarListaProjeto() {
        slProjeto.setItems(Biblioteca.listaProjetos);
    }*/

}
