package br.edu.ifba.saj.fwads.FeiraDeCiencia;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



public final class Projeto extends AbstractModel<UUID>{
    
    private String nome;
    private List<Professor> professores;
    private List<Estudante> estudantes;
    private Feira feira;

    public Projeto(String nome, Professor professor){
        this.nome=nome;
        professores= new ArrayList<>();
        addProfessor(professor);
    }

    public List<Professor> getProfessores(){
        return List.copyOf(professores);
    }

    public List<Estudante> getEstudantes(){
        return List.copyOf(estudantes);
    }

    public void addProfessor(Professor professor){
        professores.add(professor);
        professor.addProjeto(this);
    }

    public void removeProfessor(Professor professor){
        professores.remove(professor);
        professor.removeProjeto(this);
    }

    public void addEstudante (Estudante estudante){
        estudantes.add(estudante);
        estudante.addProjeto(this);
    }

    public void removeEstudante (Estudante estudante){
        estudantes.remove(estudante);
        estudante.removeProjeto(this);
    }

    public void addFeira(Feira feira) {
        this.feira=feira;
    }

    public String getNome(){
        return nome;
    }

    
}
