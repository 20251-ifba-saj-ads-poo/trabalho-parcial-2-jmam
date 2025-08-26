package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class MasterController {

    @FXML
    static BorderPane masterPane;

    @FXML
    private VBox menu;

    @FXML
    private Label userEmail;

    @FXML
    private Circle userPicture;

    @FXML
    void logOff(MouseEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja realmente sair??", ButtonType.YES, ButtonType.NO);
        alert.showAndWait()
                .filter(response -> response == ButtonType.YES)
                .ifPresent(response -> {
                    App.setRoot("controller/Login.fxml");
                });
    }

    @FXML
    void showHome(ActionEvent event) {
        limparBotoes(event.getSource());
        masterPane.setCenter(new Pane());

    }

    @FXML
    void showUsuarios(ActionEvent event) {
        limparBotoes(event.getSource());
        masterPane.setCenter(new Pane());
    }

    private void limparBotoes(Object source) {
        menu.getChildren().forEach((node) -> {
            if (node instanceof Button btn) {
                btn.getStyleClass().clear();
                btn.getStyleClass().add("btn-menu");
            }
        }

        );
        if (source instanceof Button btn) {
            btn.getStyleClass().clear();
            btn.getStyleClass().add("btn-menu-selected");
        }
    }

    @FXML
    void showProfessor(ActionEvent event) {
        limparBotoes(event.getSource());
        showFXMLFile("CadProfessor.fxml");
    }

    @FXML
    void showEstudante(ActionEvent event) {
        limparBotoes(event.getSource());
        showFXMLFile("CadEstudante.fxml");
    }

    @FXML
    void showFeira(ActionEvent event) {
        limparBotoes(event.getSource());
        showFXMLFile("CadFeira.fxml");
    }

    @FXML
    void showProjeto(ActionEvent event) {
        limparBotoes(event.getSource());
        showFXMLFile("CadProjeto.fxml");
    }
    @FXML
    void listEstudante(ActionEvent event) {
        limparBotoes(event.getSource());
        showEstudante(event); showFXMLFile("ListEstudante.fxml");
        ListEstudanteController.setMasterController(this);
    }
    }

    @FXML
    void listFeira(ActionEvent event) {
        limparBotoes(event.getSource());
        showFXMLFile("ListFeira.fxml");
    }

    @FXML
    void listProfessores(ActionEvent event) {
        limparBotoes(event.getSource());
        showFXMLFile("ListProfessor.fxml");
    }

    @FXML
    void listProjeto(ActionEvent event) {
        limparBotoes(event.getSource());
        showFXMLFile("ListProjeto.fxml");

    }



    private void showFXMLFile(String resourceName) {
        try {            
            Pane fxmlCarregado = FXMLLoader.load(getClass().getResource(resourceName));
            masterPane.setCenter(fxmlCarregado);
        } catch (Exception e) {
            new Alert(AlertType.ERROR, "Erro ao carregar o arquivo " + resourceName).showAndWait();
            e.printStackTrace();
        }
    }
}
