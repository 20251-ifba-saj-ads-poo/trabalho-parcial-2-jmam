
import java.util.ArrayList;
import java.util.Date;



public class Feira {
    
    private String nome;
    private int feiraID;
    private Date data;
    private ArrayList<Projeto> projetos;

    public Feira(String nome, Date data){
        this.nome=nome;
        this.data=data;
        projetos = new ArrayList<Projeto>();
    }
}
