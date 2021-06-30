package br.com.zupacademy.rodrigoeduque.casadocodigo.livro.controller;

import br.com.zupacademy.rodrigoeduque.casadocodigo.livro.LivroRepository;
import br.com.zupacademy.rodrigoeduque.casadocodigo.livro.controller.request.LivroRequest;
import br.com.zupacademy.rodrigoeduque.casadocodigo.livro.model.Livro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;


@RestController
@RequestMapping("/livros")
public class LivroController {

    private static Logger LOGGER = LoggerFactory.getLogger(LivroController.class);

    private LivroRepository livroRepository;
    @PersistenceContext
    private EntityManager manager;

    @Autowired
    public LivroController(LivroRepository livroRepository, EntityManager manager) {
        this.livroRepository = livroRepository;
        this.manager = manager;
    }


    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid LivroRequest request){
        Livro livro = request.toModel(manager);
        manager.persist(livro);
        LOGGER.info("request: " + request);
    }

}
