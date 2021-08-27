package br.com.zup.edu.sitedeviagens.controller.dto;

import br.com.zup.edu.sitedeviagens.modelo.Pais;

public class PaisDto {

    private Long id;
    private String nome;


    public PaisDto(Pais pais) {
        this.id = pais.getId();
    }
}
