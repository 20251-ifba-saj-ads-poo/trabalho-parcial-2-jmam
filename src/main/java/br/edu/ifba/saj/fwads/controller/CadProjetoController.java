package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Biblioteca;
import br.edu.ifba.saj.fwads.FeiraDeCiencia.Professor;
import br.edu.ifba.saj.fwads.FeiraDeCiencia.Projeto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

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
    void salvarProjeto(ActionEvent event) {
        try {
            Projeto novoProjeto = new Projeto(txTitulo.getText(), slProfessor.getSelectionModel().getSelectedItem());
            new Alert(AlertType.INFORMATION, "Cadastrando Projeto(Fake):"+novoProjeto.toString()).showAndWait();
            limparTela();
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
      

    }

    @FXML 
    private void initialize() {
        slProfessor.setConverter(new StringConverter<Professor>() {
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
        
        carregarListaProfessores();
    }

    @FXML
    private void limparTela() {
        txTitulo.setText("");
        //txSubTitulo.setText("");
        //txISBN.setText("");
        //Todo REVER
        slProfessor.setSelectionModel(null);
    }

    private void carregarListaProfessores() {
        slProfessor.setItems(Biblioteca.listaProfessores);
    }

}
