package entidades;

public class usuario {
    private int idusuario;
    private String nome;
    private String login;
    private String senha;
    private String email;
    public int getIdusuario() {
        return idusuario;
    }
    public void setIdusuario(int codigo) {
        this.idusuario = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
