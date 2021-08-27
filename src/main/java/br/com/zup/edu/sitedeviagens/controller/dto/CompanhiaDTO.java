package br.com.zup.edu.sitedeviagens.controller.dto;

import br.com.zup.edu.sitedeviagens.modelo.Companhia;

public class CompanhiaDTO {

    private Long id;
    private String nome;
    private Long paisId;

    public CompanhiaDTO(Companhia companhia) {
        this.id = companhia.getId();
        this.nome = companhia.getNome();
        this.paisId = companhia.getPais().getId();
    }

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public Long getPaisId() {
        return paisId;
    }
}
