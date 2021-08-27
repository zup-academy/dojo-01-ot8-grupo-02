package br.com.zup.edu.sitedeviagens.controller;

import br.com.zup.edu.sitedeviagens.controller.dto.PaisDto;
import br.com.zup.edu.sitedeviagens.controller.form.PaisForm;
import br.com.zup.edu.sitedeviagens.modelo.Pais;
import br.com.zup.edu.sitedeviagens.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisRepository repository;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public PaisDto adicionar(@RequestBody @Valid PaisForm paisForm) {
        Pais pais = paisForm.toModel();
        pais = repository.save(pais);
        return new PaisDto(pais);
    }
}
