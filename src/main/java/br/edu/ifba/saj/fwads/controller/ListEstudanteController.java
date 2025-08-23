package br.edu.ifba.saj.fwads.controller;
import javafx.scene.control.ChoiceBox;
import br.edu.ifba.saj.fwads.Biblioteca;
import br.edu.ifba.saj.fwads.FeiraDeCiencia.Estudante;
import br.edu.ifba.saj.fwads.FeiraDeCiencia.Professor;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.util.StringConverter;

public class ListEstudanteController {
    @FXML
    private ChoiceBox<Estudante> ListEstudante;

    @FXML 
    private void initialize() {
        ListEstudante.setConverter(new StringConverter<Estudante>() {
            @Override
            public String toString(Estudante obj) {
                if (obj != null) {
                    return obj.getNome();
                }
                return "";
            }

            @Override
            public Estudante fromString(String stringEstudante) {
                return Biblioteca.listaEstudantes
                    .stream()
                    .filter(estudante -> stringEstudante.equals(estudante.getNome()))
                    .findAny()
                    .orElse(null);                
            }
        });
        
        carregarListaEstudantes();
    }

    @FXML
    private void limparTela() {
        //txTitulo.setText("");
        //txSubTitulo.setText("");
        //txISBN.setText("");
        //Todo REVER
        ListEstudante.setSelectionModel(null);
    }
    private void carregarListaEstudantes() {
        ListEstudante.setItems(Biblioteca.listaEstudantes);
    }
}
