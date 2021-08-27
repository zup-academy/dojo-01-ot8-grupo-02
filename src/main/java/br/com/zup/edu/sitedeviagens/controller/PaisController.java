package br.com.zup.edu.sitedeviagens.controller;

import br.com.zup.edu.sitedeviagens.controller.dto.PaisDto;
import br.com.zup.edu.sitedeviagens.controller.form.PaisForm;
import br.com.zup.edu.sitedeviagens.modelo.Pais;
import br.com.zup.edu.sitedeviagens.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<PaisDto> adicionar(@RequestBody @Valid PaisForm paisForm, UriComponentsBuilder builder) {
        Pais pais = paisForm.toModel();
        pais = repository.save(pais);
        URI uri = builder.path("/paises/{id}").buildAndExpand(pais.getId()).toUri();
        return ResponseEntity.created(uri).body(new PaisDto(pais));
    }

}
