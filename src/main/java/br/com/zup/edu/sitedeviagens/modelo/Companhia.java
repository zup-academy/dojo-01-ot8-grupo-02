package br.com.zup.edu.sitedeviagens.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Companhia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    @ManyToOne
    @NotNull
    private Pais pais;

    @Deprecated
    public Companhia() {}

    public Companhia(@NotBlank String nome, @NotNull Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public Pais getPais() {
        return pais;
    }
}
