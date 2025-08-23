package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Biblioteca;
import br.edu.ifba.saj.fwads.FeiraDeCiencia.Professor;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class CadProfessorController {

    //@FXML
    //private TextField txCPF;

    //@FXML
    //private TextField txEmail;

    @FXML
    private TextField txNome;

    @FXML
    private void salvarProfessor() {

            Professor novoProfessor = new Professor(txNome.getText(), "admin"
                        /*txEmail.getText(), 
                        txCPF.getText()*/);
            new Alert(AlertType.INFORMATION, 
            "Cadastrando Professor:"+novoProfessor.getNome()).showAndWait();
            Biblioteca.listaProfessores.add(novoProfessor);
            limparTela();
            
        
    }
    @FXML
    private void limparTela() {
        txNome.setText("");
        //txEmail.setText("");
        //txCPF.setText("");
    }

}
