package br.com.zup.edu.sitedeviagens.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne @NotNull
    private Aeroporto destino;

    @ManyToOne @NotNull
    private Aeroporto origem;

    @NotNull @Positive
    private Integer tempoMinutos;

    @Deprecated
    public Rota() {}

    public Rota(Aeroporto destino, Aeroporto origem, Integer tempoMinutos) {
        this.destino = destino;
        this.origem = origem;
        this.tempoMinutos = tempoMinutos;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Aeroporto getDestino() {
        return destino;
    }

    public Aeroporto getOrigem() {
        return origem;
    }

    public Integer getTempoMinutos() {
        return tempoMinutos;
    }
}
