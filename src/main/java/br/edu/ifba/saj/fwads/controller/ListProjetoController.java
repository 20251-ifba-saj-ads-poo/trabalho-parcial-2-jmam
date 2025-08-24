package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Biblioteca;
import br.edu.ifba.saj.fwads.FeiraDeCiencia.Projeto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.StringConverter;

public class ListProjetoController {
    @FXML
    private ChoiceBox<Projeto> ListProjeto;

    @FXML
    private ListView<Projeto> ListarProjeto;

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

        ListarProjeto.setCellFactory(lv -> new ListCell<Projeto>() {
                @Override
                public void updateItem(Projeto row, boolean empty) {
                    super.updateItem(row, empty) ;
                    setText(empty ? null : row.getNome() + "- Líder:"+ row.getLider());
                }
                
                Projeto projeto = ListarProjeto.getSelectionModel().getSelectedItem();
            });
        
        carregarListaProjeto();
    }

     @FXML
    void SelectProjeto(ActionEvent event) {

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
        ListarProjeto.setItems(Biblioteca.listaProjetos);
    }
}

