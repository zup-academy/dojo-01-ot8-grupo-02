package br.com.zup.edu.sitedeviagens.controller.form;

import br.com.zup.edu.sitedeviagens.controller.exception.ErroDto;
import br.com.zup.edu.sitedeviagens.controller.exception.RegraNegocioException;
import br.com.zup.edu.sitedeviagens.controller.validation.CampoUnicoConstraint;
import br.com.zup.edu.sitedeviagens.modelo.Aeroporto;
import br.com.zup.edu.sitedeviagens.modelo.Pais;
import br.com.zup.edu.sitedeviagens.repository.PaisRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class AeroportoForm {

    @NotBlank
    @CampoUnicoConstraint(modelClass = Aeroporto.class, campo = "nome")
    private String nome;

    @NotNull
    private Long paisId;

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Aeroporto toModel(PaisRepository paisRepository) {
        Optional<Pais> pais = paisRepository.findById(paisId);
        if (!pais.isPresent()) {
            throw new RegraNegocioException(new ErroDto("paisId", "ID inválido"));
        }
        return new Aeroporto(this.nome, pais.get());
    }
}
