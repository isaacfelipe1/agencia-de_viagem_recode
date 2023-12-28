package entidades;
public class contato {
    private int idcontato;
    private String nome;
    private String sobrenome;
    private String email;
    private String mensagem;

    public int getIdcontato() {
        return idcontato;
    }
    public void setIdcontato(int idcontato) {
        this.idcontato = idcontato;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
