package br.edu.ifba.saj.fwads.FeiraDeCiencia;
import java.util.ArrayList;
import java.util.Date;



public class Feira {
    
    private String nome;
    private Date data;
    private ArrayList<Projeto> projetos;

    public Feira(String nome/*, Date data*/){
        this.nome=nome;
        //this.data=data;
        projetos = new ArrayList<Projeto>();
    }

    public String getNome(){
        return nome;
    }

    public void addProjeto(Projeto projeto){
        projetos.add(projeto);
        projeto.addFeira(this);
    }
}
