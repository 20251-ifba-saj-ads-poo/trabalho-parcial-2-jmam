package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Biblioteca;
import br.edu.ifba.saj.fwads.FeiraDeCiencia.Estudante;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;


public class CadEstudanteController {

/*   @FXML
    private TextField txCPF;

@FXML
    private TextField txEmail;
*/
    @FXML
    private TextField txNome;

    @FXML
    private void salvarEstudante() {
        Estudante novoEstudante = new Estudante(txNome.getText(), "admin"/*,
                    txEmail.getText(), 
                    txCPF.getText()*/);
        new Alert(AlertType.INFORMATION, 
        "Cadastrando Estudante:"+novoEstudante.getNome()).showAndWait();
        Biblioteca.listaEstudantes.add(novoEstudante);
        limparTela();
    }
    @FXML
    private void limparTela() {
        txNome.setText("");
        //txEmail.setText("");
        //txCPF.setText("");
    }

}
