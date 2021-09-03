package br.com.zup.edu.sitedeviagens.controller.dto;

import br.com.zup.edu.sitedeviagens.modelo.Rota;

public class RotaDto {

    private String nome;
    private String nomeAeroportoOrigem;
    private String nomeAeroportoDestino;
    private Integer TempoMinutos;

    public RotaDto(Rota rota) {
        this.nome = rota.getNome();
        this.nomeAeroportoOrigem = rota.getOrigem().getNome();
        this.nomeAeroportoDestino = rota.getDestino().getNome();
        this.TempoMinutos = rota.getTempoMinutos();
    }

    public String getNome() {
        return nome;
    }

    public String getNomeAeroportoOrigem() {
        return nomeAeroportoOrigem;
    }

    public String getNomeAeroportoDestino() {
        return nomeAeroportoDestino;
    }

    public Integer getTempoMinutos() {
        return TempoMinutos;
    }
}
