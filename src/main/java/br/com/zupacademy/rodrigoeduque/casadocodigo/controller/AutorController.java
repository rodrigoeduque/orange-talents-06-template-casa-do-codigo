package br.com.zupacademy.rodrigoeduque.casadocodigo.controller;

import br.com.zupacademy.rodrigoeduque.casadocodigo.config.validacao.EmailAutorDuplicadoValidator;
import br.com.zupacademy.rodrigoeduque.casadocodigo.controller.dto.AutorDto;
import br.com.zupacademy.rodrigoeduque.casadocodigo.controller.request.AutorRequest;
import br.com.zupacademy.rodrigoeduque.casadocodigo.model.Autor;
import br.com.zupacademy.rodrigoeduque.casadocodigo.repository.AutorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autores")
public class AutorController {

    AutorRepository autorRepository;
    EmailAutorDuplicadoValidator emailAutorDuplicadoValidator;

    public AutorController(AutorRepository autorRepository, EmailAutorDuplicadoValidator emailAutorDuplicadoValidator) {
        this.autorRepository = autorRepository;
        this.emailAutorDuplicadoValidator = emailAutorDuplicadoValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(emailAutorDuplicadoValidator);
    }

    @PostMapping
    public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorRequest autorRequest, UriComponentsBuilder uriComponentsBuilder) {
        Autor autor = autorRequest.convert();
        autorRepository.save(autor);

        URI uri = uriComponentsBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();

        return ResponseEntity.created(uri).body(new AutorDto(autor));
    }

}
