import java.util.List;

public class Professor extends Usuario{
    
    private int professorID;
    private List<Projeto> projetos;
    

    public Professor(String nome, String senha){
        super(nome, senha);
        projetos=null;
    }

    public List<Projeto> GetProjetos(){
        return List.copyOf(projetos);
    }

    public void AddProjeto(Projeto projeto){
        projetos.add(projeto);
    }

    public void RemoverProjeto(Projeto projeto){
        projetos.remove(projeto);
    }


}
