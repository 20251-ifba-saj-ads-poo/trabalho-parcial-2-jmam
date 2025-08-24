package br.edu.ifba.saj.fwads.FeiraDeCiencia;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;



public class Feira extends AbstractModel<UUID> {
    
    private String nome;
    private Date data;
    private ArrayList<Projeto> projetos;

    public Feira(String nome/*, Date data*/){
        this.nome=nome;
        //this.data=data;
        this.projetos = new ArrayList<>();
    }

    public String getNome(){
        return nome;
    }

    public void addProjeto(Projeto projeto){
        projetos.add(projeto);
        projeto.addFeira(this);
    }
}
