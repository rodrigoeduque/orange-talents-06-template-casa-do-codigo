package br.com.zupacademy.rodrigoeduque.casadocodigo.autor.controller;

import br.com.zupacademy.rodrigoeduque.casadocodigo.autor.controller.dto.AutorDto;
import br.com.zupacademy.rodrigoeduque.casadocodigo.autor.controller.request.AutorRequest;
import br.com.zupacademy.rodrigoeduque.casadocodigo.autor.model.Autor;
import br.com.zupacademy.rodrigoeduque.casadocodigo.autor.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private AutorRepository autorRepository;

    @Autowired
    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    /*    EmailAutorDuplicadoValidator emailAutorDuplicadoValidator;

    public AutorController(AutorRepository autorRepository, EmailAutorDuplicadoValidator emailAutorDuplicadoValidator) {
        this.autorRepository = autorRepository;
        this.emailAutorDuplicadoValidator = emailAutorDuplicadoValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(emailAutorDuplicadoValidator);
    }*/

    @PostMapping
    public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorRequest autorRequest, UriComponentsBuilder uriComponentsBuilder) {
        Autor autor = autorRequest.convert();
        autorRepository.save(autor);

        URI uri = uriComponentsBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();

        return ResponseEntity.created(uri).body(new AutorDto(autor));
    }

}
