package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Biblioteca;
import br.edu.ifba.saj.fwads.FeiraDeCiencia.Professor;
import br.edu.ifba.saj.fwads.model.Autor;
import br.edu.ifba.saj.fwads.model.Livro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;
import br.edu.ifba.saj.fwads.FeiraDeCiencia.Projeto;

public class CadProjetoController {
    @FXML
    private TextField txTitulo;
    /*@FXML
    private TextField txSubTitulo;
    @FXML
    private TextField txISBN;*/
    @FXML
    private ChoiceBox<Professor> slProfessor;

    @FXML
    void salvarLivro(ActionEvent event) {
        Projeto novoProjeto = new Projeto(txTitulo.getText(),
                    /*txSubTitulo.getText(), 
                    txISBN.getText(),*/
                    slProfessor.getSelectionModel().getSelectedItem());
        new Alert(AlertType.INFORMATION, 
        "Cadastrando Projeto(Fake):"+novoProjeto.toString()).showAndWait();
        limparTela();
      

    }

    @FXML 
    private void initialize() {
        slProfessor.setConverter(new StringConverter<Professor>() {
            @Override
            public String toString(Professor obj) {
                if (obj != null) {
                    return obj.getNome() + ":" + obj.getEmail();
                }
                return "";
            }

            @Override
            public Professor fromString(String stringProfessor) {
                return Biblioteca.listaProfessores
                    .stream()
                    .filter(autor -> stringProfessor.equals(autor.getNome() + ":" + autor.getEmail()))
                    .findAny()
                    .orElse(null);                
            }
        });
        
        carregarListaAutores();
    }

    @FXML
    private void limparTela() {
        txTitulo.setText("");
        txSubTitulo.setText("");
        txISBN.setText("");
        //Todo REVER
        slAutor.setSelectionModel(null);
    }

    private void carregarListaAutores() {
        slAutor.setItems(Biblioteca.listaAutores);
    }

}
