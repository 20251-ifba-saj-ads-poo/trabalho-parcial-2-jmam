

public class Usuario {
    
    private String nome;
    private String senha;

    Usuario(String nome, String senha){
        this.setSenha(senha);
        this.setNome(nome);
    }


    private void setSenha(String senha){
        if (senha.length()>=8)
            this.senha=senha;
    }

    private void setNome(String nome){
        if (nome.length()>=8)
            this.nome=nome;
    }

}
