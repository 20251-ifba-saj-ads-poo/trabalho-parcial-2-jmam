package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Biblioteca;
import br.edu.ifba.saj.fwads.FeiraDeCiencia.Feira;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

public class ListFeiraController {
    
       
    @FXML
    private ListView<Feira> ListarFeira;
    
    private MasterController masterController;

    public void setMasterController(MasterController masterController){
        this.masterController = masterController;
    }

    @FXML 
    private void initialize() {
        /*ListFeira.setConverter(new StringConverter<Feira>() {
            @Override
            public String toString(Feira obj) {
                if (obj != null) {
                    return obj.getNome();
                }
                return "";
            }

            @Override
            public Feira fromString(String stringFeira) {
                return Biblioteca.listaFeiras
                    .stream()
                    .filter(Feira -> stringFeira.equals(Feira.getNome()))
                    .findAny()
                    .orElse(null);                
            }
        });*/

        ListarFeira.setCellFactory(lv -> new ListCell<Feira>() {
                @Override
                public void updateItem(Feira row, boolean empty) {
                    super.updateItem(row, empty) ;
                    setText(empty ? null : row.getNome());
                }
                
                Feira feira = ListarFeira.getSelectionModel().getSelectedItem();
            });
        
        carregarListaFeiras();
    }

    @FXML
    void VisualizaFeira(ActionEvent event) {
        DetailFeiraController.current=ListarFeira.getSelectionModel().getSelectedItem();
        showFXMLFile("DetailFeira.fxml");
    }
    

    /*@FXML
    private void limparTela() {
        //txTitulo.setText("");
        //txSubTitulo.setText("");
        //txISBN.setText("");
        //Todo REVER
        //ListFeira.setSelectionModel(null);
    }*/

    private void carregarListaFeiras() {
        //ListFeira.setItems(Biblioteca.listaFeiras);
        ListarFeira.setItems(Biblioteca.listaFeiras);
    }

    private void showFXMLFile(String resourceName) {
        try {            
            Pane fxmlCarregado = FXMLLoader.load(getClass().getResource(resourceName));
            masterController.masterPane.setCenter(fxmlCarregado);
        } catch (Exception e) {
            new Alert(AlertType.ERROR, "Erro ao carregar o arquivo " + resourceName).showAndWait();
            e.printStackTrace();
        }
    }

}
