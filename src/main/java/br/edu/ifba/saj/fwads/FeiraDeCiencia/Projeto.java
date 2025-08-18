 import java.util.ArrayList;
import java.util.List;



public final class Projeto {
    
    private String nome;
    private int projetoID;
    private final List<Professor> professores;
    private List<Estudante> estudantes;

    public Projeto(String nome, Professor professor){
        this.nome=nome;
        professores= new ArrayList<Professor>();
        AddProfessor(professor);
    }

    public List<Professor> GetProfessores(){
        return List.copyOf(professores);
    }

    public List<Estudante> GetEstudantes(){
        return List.copyOf(estudantes);
    }

    public void AddProfessor(Professor professor){
        professores.add(professor);
        professor.AddProjeto(this);
    }

    public void RemoverProfessor(Professor professor){
        professores.remove(professor);
        professor.RemoverProjeto(this);
    }

    
}
