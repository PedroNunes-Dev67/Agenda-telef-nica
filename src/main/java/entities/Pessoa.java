package entities;

import jakarta.persistence.*;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome", nullable = true)
    private String nome;
    @Column(name = "telefone", nullable = true)
    private String telefone;

    public Pessoa() {
    }

    public Pessoa(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return id+" | Nome: "+nome+" | Telefone: "+ telefone;
    }
}
