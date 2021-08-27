package br.com.zup.edu.sitedeviagens.controller.form;

import br.com.zup.edu.sitedeviagens.controller.validation.CampoUnicoConstraint;
import br.com.zup.edu.sitedeviagens.modelo.Companhia;
import br.com.zup.edu.sitedeviagens.modelo.Pais;
import br.com.zup.edu.sitedeviagens.repository.PaisRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class CompanhiaForm {

    @NotBlank
    @CampoUnicoConstraint(modelClass = Companhia.class, campo = "nome")
    private String nome;

    @NotNull
    private Long paisId;

    public Companhia toModel(PaisRepository paisRepository) {
        Optional<Pais> pais = paisRepository.findById(this.paisId);
        if (!pais.isPresent()) {
            throw new IllegalArgumentException();
        }
        return new Companhia(this.nome, pais.get());
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }
}
