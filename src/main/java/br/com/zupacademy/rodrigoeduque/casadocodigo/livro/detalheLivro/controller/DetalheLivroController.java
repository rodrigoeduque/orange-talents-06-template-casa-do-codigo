package br.com.zupacademy.rodrigoeduque.casadocodigo.livro.detalheLivro.controller;

import br.com.zupacademy.rodrigoeduque.casadocodigo.livro.LivroRepository;
import br.com.zupacademy.rodrigoeduque.casadocodigo.livro.detalheLivro.controller.response.DetalheLivroResponse;
import br.com.zupacademy.rodrigoeduque.casadocodigo.livro.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class DetalheLivroController {

    private LivroRepository livroRepository;

    @Autowired
    public DetalheLivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<?> detalheLivro(@PathVariable Long id) {

        Optional<Livro> livroRetorno = livroRepository.findById(id);

        if (livroRetorno.isPresent()) {
            return ResponseEntity.ok().body(new DetalheLivroResponse(livroRetorno.get()));
        }

        return ResponseEntity.notFound().build();
    }

}
