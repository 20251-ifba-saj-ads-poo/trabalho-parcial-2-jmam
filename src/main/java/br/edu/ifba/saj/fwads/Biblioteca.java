package br.edu.ifba.saj.fwads;

import br.edu.ifba.saj.fwads.FeiraDeCiencia.Estudante;
import br.edu.ifba.saj.fwads.FeiraDeCiencia.Feira;
import br.edu.ifba.saj.fwads.FeiraDeCiencia.Professor;
import br.edu.ifba.saj.fwads.FeiraDeCiencia.Projeto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Biblioteca {
    public static ObservableList<Professor> listaProfessores = FXCollections.observableArrayList();
    public static ObservableList<Estudante> listaEstudantes = FXCollections.observableArrayList();
    public static ObservableList<Projeto> listaProjetos = FXCollections.observableArrayList();
    public static ObservableList<Feira> listaFeiras = FXCollections.observableArrayList();

    static{
        //listaAutores.add(new Autor("Jose","jose@seila.com","123.456.789.-11"));
    }
    
}
