package br.com.zup.edu.sitedeviagens.controller.form;

import br.com.zup.edu.sitedeviagens.controller.exception.ErroDto;
import br.com.zup.edu.sitedeviagens.controller.exception.RegraNegocioException;
import br.com.zup.edu.sitedeviagens.modelo.Aeroporto;
import br.com.zup.edu.sitedeviagens.modelo.Rota;
import br.com.zup.edu.sitedeviagens.repository.AeroportoRepository;
import br.com.zup.edu.sitedeviagens.repository.RotaRepository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

public class RotaForm {

    private String nome;

    @NotNull
    private Long destinoId;

    @NotNull
    private Long origemId;

    @NotNull @Positive
    private Integer tempoMinutos;

    public Rota toModel(AeroportoRepository aeroportoRepository, RotaRepository repository) {
        if (destinoId == origemId) {
            throw new RegraNegocioException(new ErroDto("destinoID e origemId", "Os aeroportos de origem e destino precisam ser diferentes."));
        }
        Optional<Aeroporto> origem = aeroportoRepository.findById(origemId);
        Optional<Aeroporto> destino = aeroportoRepository.findById(destinoId);
        if (origem.isEmpty()) throw new RegraNegocioException(new ErroDto("origemId", "Esse aeroporto não existe"));
        if (destino.isEmpty()) throw new RegraNegocioException(new ErroDto("destinoId", "Esse aeroporto não existe"));
        List<Rota> rotas = repository.findByOrigemIdAndDestinoId(origem.get().getId(), destino.get().getId());
        if (!rotas.isEmpty()) throw new RegraNegocioException(new ErroDto("destinoId e origemId", "Essa rota, com mesmos" +
                "origem e destino já existe"));
        return new Rota(this.)

    }
}
