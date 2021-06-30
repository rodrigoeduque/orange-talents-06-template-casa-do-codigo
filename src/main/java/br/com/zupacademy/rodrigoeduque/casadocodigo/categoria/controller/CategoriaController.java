package br.com.zupacademy.rodrigoeduque.casadocodigo.categoria.controller;

import br.com.zupacademy.rodrigoeduque.casadocodigo.categoria.controller.request.CategoriaRequest;
import br.com.zupacademy.rodrigoeduque.casadocodigo.categoria.model.Categoria;
import br.com.zupacademy.rodrigoeduque.casadocodigo.categoria.repository.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

/*    private CategoriaDuplicadoValidator categoriaDuplicadoValidator;

    public CategoriaController(CategoriaRepository categoriaRepository, CategoriaDuplicadoValidator categoriaDuplicadoValidator) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaDuplicadoValidator = categoriaDuplicadoValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(categoriaDuplicadoValidator);
    }*/

    @PostMapping
    public ResponseEntity<CategoriaRequest> cadastrar(@RequestBody @Valid CategoriaRequest categoriaRequest, UriComponentsBuilder uriComponentsBuilder) {

        Categoria categoria = categoriaRequest.toModel();
        categoriaRepository.save(categoria);

        return ResponseEntity.ok().build();
    }
}
