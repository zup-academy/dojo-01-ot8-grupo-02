package br.com.zup.edu.sitedeviagens.controller;

import br.com.zup.edu.sitedeviagens.controller.dto.CompanhiaDTO;
import br.com.zup.edu.sitedeviagens.controller.form.CompanhiaForm;
import br.com.zup.edu.sitedeviagens.modelo.Companhia;
import br.com.zup.edu.sitedeviagens.repository.CompanhiaRepository;
import br.com.zup.edu.sitedeviagens.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/companhias")
public class CompanhiaController {

    @Autowired
    private CompanhiaRepository repository;

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public CompanhiaDTO cadastrar(@RequestBody @Valid CompanhiaForm form) {
        Companhia companhia = form.toModel(paisRepository);
        this.repository.save(companhia);
        return new CompanhiaDTO(companhia);
    }
}
