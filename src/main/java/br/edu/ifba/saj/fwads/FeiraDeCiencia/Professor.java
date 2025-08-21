package br.edu.ifba.saj.fwads.FeiraDeCiencia;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario{
    
    private List<Projeto> projetos;
    

    public Professor(String nome, String senha){
        super(nome, senha);
        projetos=new ArrayList<>();
    }

    public List<Projeto> getProjetos(){
        return List.copyOf(projetos);
    }

    public void addProjeto(Projeto projeto){
        projetos.add(projeto);
    }

    public void removeProjeto(Projeto projeto){
        projetos.remove(projeto);
    }


}
