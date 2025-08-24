package br.edu.ifba.saj.fwads.controller;
import br.edu.ifba.saj.fwads.Biblioteca;
import br.edu.ifba.saj.fwads.FeiraDeCiencia.Feira;
import br.edu.ifba.saj.fwads.FeiraDeCiencia.Projeto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class DetailFeiraController {
    
    public static Feira current;

    @FXML
    private ListView<Projeto> ListaProjetosFeira;

    @FXML
    private TextField txFeira;

    @FXML
    private void initialize(){
        txFeira.setText(current.getNome());

    ListaProjetosFeira.setCellFactory(lv -> new ListCell<Projeto>() {
                @Override
                public void updateItem(Projeto row, boolean empty) {
                    super.updateItem(row, empty) ;
                    setText(empty ? null : row.getNome() + "- Líder:"+ row.getLider());
                }
                
                Projeto projeto = ListaProjetosFeira.getSelectionModel().getSelectedItem();
            });
        caregarListaProjetos();
    }

    private void caregarListaProjetos(){
        ListaProjetosFeira.setItems(Biblioteca.listaProjetos);
    }

    @FXML
    void RetornaFeira(ActionEvent event) {

    }
}
