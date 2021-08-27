package br.com.zup.edu.sitedeviagens.controller;

import br.com.zup.edu.sitedeviagens.controller.dto.AeroportoDto;
import br.com.zup.edu.sitedeviagens.controller.form.AeroportoForm;
import br.com.zup.edu.sitedeviagens.modelo.Aeroporto;
import br.com.zup.edu.sitedeviagens.repository.AeroportoRepository;
import br.com.zup.edu.sitedeviagens.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/aeroportos")
public class AeroportoController {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private AeroportoRepository aeroportoRepository;

    @PostMapping
    @Transactional
    @ResponseStatus(code = HttpStatus.CREATED)
    public AeroportoDto cadastrar(@RequestBody @Valid AeroportoForm aeroportoForm) {
        Aeroporto aeroporto = aeroportoForm.toModel(this.paisRepository);
        aeroporto = this.aeroportoRepository.save(aeroporto);
        return new AeroportoDto(aeroporto);
    }
}
