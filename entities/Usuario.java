package entities;

public class Usuario {
    private String nome;
    private String endereço;
    private Integer telefone;

    public Usuario() {

    }

    public Usuario(String nome, String endereço, Integer telefone) {
        this.nome = nome;
        this.endereço = endereço;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

}
