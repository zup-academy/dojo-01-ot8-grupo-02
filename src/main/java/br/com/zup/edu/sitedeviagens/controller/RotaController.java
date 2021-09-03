package br.com.zup.edu.sitedeviagens.controller;

import br.com.zup.edu.sitedeviagens.controller.dto.RotaDto;
import br.com.zup.edu.sitedeviagens.controller.form.RotaForm;
import br.com.zup.edu.sitedeviagens.modelo.Rota;
import br.com.zup.edu.sitedeviagens.repository.AeroportoRepository;
import br.com.zup.edu.sitedeviagens.repository.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/rotas")
public class RotaController {

    @Autowired
    private RotaRepository rotaRepository;

    @Autowired
    private AeroportoRepository aeroportoRepository;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public RotaDto adicionar(@RequestBody @Valid RotaForm formulario){
        Rota rota = formulario.toModel(aeroportoRepository,rotaRepository);
        rotaRepository.save(rota);
        return new RotaDto(rota);
    }
}
