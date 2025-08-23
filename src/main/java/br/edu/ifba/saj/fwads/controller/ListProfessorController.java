package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Biblioteca;

import br.edu.ifba.saj.fwads.FeiraDeCiencia.Professor;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.StringConverter;

public class ListProfessorController {
@FXML
    private ChoiceBox<Professor> ListProfessor;

    @FXML
    private ListView<Professor> ListarProfessor;

    @FXML 
    private void initialize() {
        ListProfessor.setConverter(new StringConverter<Professor>() {
            @Override
            public String toString(Professor obj) {
                if (obj != null) {
                    return obj.getNome();
                }
                return "";
            }

            @Override
            public Professor fromString(String stringProfessor) {
                return Biblioteca.listaProfessores
                    .stream()
                    .filter(professor -> stringProfessor.equals(professor.getNome()))
                    .findAny()
                    .orElse(null);                
            }
        });
        ListarProfessor.setCellFactory(lv ->new ListCell<Professor>() {
                @Override
                public void updateItem(Professor row, boolean empty) {
                    super.updateItem(row, empty) ;
                    setText(empty ? null : row.getNome());
                }
                
                Professor professor = ListarProfessor.getSelectionModel().getSelectedItem();
            });            
            
            carregarListaProfessor();
    }

    @FXML
    private void limparTela() {
        //txTitulo.setText("");
        //txSubTitulo.setText("");
        //txISBN.setText("");
        //Todo REVER
        ListProfessor.setSelectionModel(null);
    }

    private void carregarListaProfessor() {
        ListProfessor.setItems(Biblioteca.listaProfessores);
        ListarProfessor.setItems(Biblioteca.listaProfessores);
    }
}
