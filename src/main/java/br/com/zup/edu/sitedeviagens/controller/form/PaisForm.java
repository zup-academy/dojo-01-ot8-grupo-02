package br.com.zup.edu.sitedeviagens.controller.form;

import br.com.zup.edu.sitedeviagens.modelo.Pais;

import javax.validation.constraints.NotBlank;

public class PaisForm {

    @NotBlank
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }
    public Pais toModel() {
        return new Pais(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
