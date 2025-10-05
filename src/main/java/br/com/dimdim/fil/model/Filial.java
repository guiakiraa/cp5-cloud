package br.com.dimdim.fil.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "filial")
public class Filial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O nome da filial não pode estar em branco")
    @Size(max = 100, message = "O nome da filial deve ter no máximo 100 caracteres")
    private String nome;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_endereco")
    private Endereco endereco;

    public Filial() {
    }

    public Filial(Long id, String nome, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty(message = "O nome da filial não pode estar em branco") @Size(max = 100, message = "O nome da filial deve ter no máximo 100 caracteres") String getNome() {
        return nome;
    }

    public void setNome(@NotEmpty(message = "O nome da filial não pode estar em branco") @Size(max = 100, message = "O nome da filial deve ter no máximo 100 caracteres") String nome) {
        this.nome = nome;
    }

    public @NotNull Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Filial{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}