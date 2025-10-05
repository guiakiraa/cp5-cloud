package br.com.dimdim.fil.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O logradouro não pode estar em branco")
    @Size(max = 255, message = "O logradouro deve ter no máximo 255 caracteres")
    private String logradouro;

    @Min(value = 1, message = "O número deve ser no mínimo 1")
    @Max(value = 99999, message = "O número deve ter no máximo 5 dígitos")
    private Integer numero;

    @NotEmpty(message = "O bairro não pode estar em branco")
    @Size(max = 100, message = "O bairro deve ter no máximo 100 caracteres")
    private String bairro;

    @NotEmpty(message = "A cidade não pode estar em branco")
    @Size(max = 100, message = "A cidade deve ter no máximo 100 caracteres")
    private String cidade;

    @NotEmpty(message = "O estado não pode estar em branco")
    @Size(min = 2, max = 2, message = "O estado deve ter 2 caracteres (UF)")
    @Pattern(regexp = "[A-Z]{2}", message = "O estado deve conter apenas letras maiúsculas (UF)")
    private String estado;

    @NotEmpty(message = "O CEP não pode estar em branco")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato XXXXX-XXX")
    private String cep;

    @Size(max = 255, message = "O complemento deve ter no máximo 255 caracteres")
    private String complemento;

    public Endereco() {
    }

    public Endereco(Long id, String logradouro, Integer numero, String bairro, String cidade, String estado, String cep, String complemento) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.complemento = complemento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty(message = "O logradouro não pode estar em branco") @Size(max = 255, message = "O logradouro deve ter no máximo 255 caracteres") String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(@NotEmpty(message = "O logradouro não pode estar em branco") @Size(max = 255, message = "O logradouro deve ter no máximo 255 caracteres") String logradouro) {
        this.logradouro = logradouro;
    }

    public @Min(value = 1, message = "O número deve ser no mínimo 1") @Max(value = 99999, message = "O número deve ter no máximo 5 dígitos") Integer getNumero() {
        return numero;
    }

    public void setNumero(@Min(value = 1, message = "O número deve ser no mínimo 1") @Max(value = 99999, message = "O número deve ter no máximo 5 dígitos") Integer numero) {
        this.numero = numero;
    }

    public @NotEmpty(message = "O bairro não pode estar em branco") @Size(max = 100, message = "O bairro deve ter no máximo 100 caracteres") String getBairro() {
        return bairro;
    }

    public void setBairro(@NotEmpty(message = "O bairro não pode estar em branco") @Size(max = 100, message = "O bairro deve ter no máximo 100 caracteres") String bairro) {
        this.bairro = bairro;
    }

    public @NotEmpty(message = "A cidade não pode estar em branco") @Size(max = 100, message = "A cidade deve ter no máximo 100 caracteres") String getCidade() {
        return cidade;
    }

    public void setCidade(@NotEmpty(message = "A cidade não pode estar em branco") @Size(max = 100, message = "A cidade deve ter no máximo 100 caracteres") String cidade) {
        this.cidade = cidade;
    }

    public @NotEmpty(message = "O estado não pode estar em branco") @Size(min = 2, max = 2, message = "O estado deve ter 2 caracteres (UF)") @Pattern(regexp = "[A-Z]{2}", message = "O estado deve conter apenas letras maiúsculas (UF)") String getEstado() {
        return estado;
    }

    public void setEstado(@NotEmpty(message = "O estado não pode estar em branco") @Size(min = 2, max = 2, message = "O estado deve ter 2 caracteres (UF)") @Pattern(regexp = "[A-Z]{2}", message = "O estado deve conter apenas letras maiúsculas (UF)") String estado) {
        this.estado = estado;
    }

    public @NotEmpty(message = "O CEP não pode estar em branco") @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato XXXXX-XXX") String getCep() {
        return cep;
    }

    public void setCep(@NotEmpty(message = "O CEP não pode estar em branco") @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato XXXXX-XXX") String cep) {
        this.cep = cep;
    }

    public @Size(max = 255, message = "O complemento deve ter no máximo 255 caracteres") String getComplemento() {
        return complemento;
    }

    public void setComplemento(@Size(max = 255, message = "O complemento deve ter no máximo 255 caracteres") String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", logradouro='" + logradouro + '\'' +
                ", numero=" + numero +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                ", complemento='" + complemento + '\'' +
                '}';
    }
}
