package br.com.zup.edu.sitedeviagens.controller.dto;

import br.com.zup.edu.sitedeviagens.modelo.Aeroporto;

public class AeroportoDto {

    private Long id;
    private String nome;
    private Long paisId;

    public AeroportoDto(Aeroporto aeroporto) {
        this.id = aeroporto.getId();
        this.nome = aeroporto.getNome();
        this.paisId = aeroporto.getPais().getId();
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
