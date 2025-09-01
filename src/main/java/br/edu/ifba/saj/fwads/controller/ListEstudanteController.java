package br.edu.ifba.saj.fwads.controller;
import br.edu.ifba.saj.fwads.Biblioteca;
import br.edu.ifba.saj.fwads.FeiraDeCiencia.Estudante;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class ListEstudanteController {
    //@FXML
    //private ChoiceBox<Estudante> ListEstudante;
    
    @FXML
    private ListView<Estudante> ListarEstudante;

    private MasterController masterController;

    public void setMasterController(MasterController masterController){
        this.masterController = masterController;
    }

    @FXML 
    private void initialize() {
        /*ListEstudante.setConverter(new StringConverter<Estudante>() {
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
            });*/

            ListarEstudante.setCellFactory(lv -> new ListCell<Estudante>() {
                @Override
                public void updateItem(Estudante row, boolean empty) {
                    super.updateItem(row, empty) ;
                    setText(empty ? null : row.getNome());
                }
                
                Estudante estudante = ListarEstudante.getSelectionModel().getSelectedItem();
            });            
            
            carregarListaEstudantes();
        }

    @FXML
    private void limparTela() {
        //txTitulo.setText("");
        //txSubTitulo.setText("");
        //txISBN.setText("");
        //Todo REVER
        //ListEstudante.setSelectionModel(null);
    }
    private void carregarListaEstudantes() {
        //ListEstudante.setItems(Biblioteca.listaEstudantes);
        ListarEstudante.setItems(Biblioteca.listaEstudantes);
    }
    
}
