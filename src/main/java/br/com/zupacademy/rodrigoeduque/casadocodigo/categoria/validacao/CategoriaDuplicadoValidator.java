package br.com.zupacademy.rodrigoeduque.casadocodigo.categoria.validacao;

import br.com.zupacademy.rodrigoeduque.casadocodigo.categoria.controller.request.CategoriaRequest;
import br.com.zupacademy.rodrigoeduque.casadocodigo.categoria.model.Categoria;
import br.com.zupacademy.rodrigoeduque.casadocodigo.categoria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CategoriaDuplicadoValidator implements Validator {

    private CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaDuplicadoValidator(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }


    @Override
    public boolean supports(Class<?> aClass) {

        return CategoriaRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        if (errors.hasErrors()){
            return;
        }

        CategoriaRequest request = (CategoriaRequest) o;
        Optional<Categoria> retornaCategoria = categoriaRepository.findByNome(request.getNome());

        if (retornaCategoria.isPresent()){
            errors.rejectValue("nome", null, "Esta categoria já foi cadastrada na sua base de dados : " + request.getNome());
        }

    }
}
