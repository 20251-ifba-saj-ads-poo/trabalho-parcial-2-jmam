
import java.util.List;


public class Estudante extends Usuario{
    
    protected int estudanteID;
    protected List<Projeto> projetos;

    public Estudante(String nome, String senha) {
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
