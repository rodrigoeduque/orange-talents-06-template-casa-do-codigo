package br.com.zupacademy.rodrigoeduque.casadocodigo.config.validacao;

import br.com.zupacademy.rodrigoeduque.casadocodigo.autor.controller.request.AutorRequest;
import br.com.zupacademy.rodrigoeduque.casadocodigo.autor.model.Autor;
import br.com.zupacademy.rodrigoeduque.casadocodigo.autor.repository.AutorRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EmailAutorDuplicadoValidator implements Validator {

  private final AutorRepository autorRepository;

  public EmailAutorDuplicadoValidator(AutorRepository autorRepository) {

    this.autorRepository = autorRepository;
  }

  @Override
  public boolean supports(Class<?> aClass) {

    return AutorRequest.class.isAssignableFrom(aClass);
  }

  @Override
  public void validate(Object o, Errors errors) {
    if (errors.hasErrors()) {
      return;
    }
    AutorRequest request = (AutorRequest) o;
    Optional<Autor> retornaAutor = autorRepository.findByEmail(request.getEmail());

    if (retornaAutor.isPresent()) {
      errors.rejectValue(
          "email", null, "Este e-mail foi cadastrado na base de dados : " + request.getEmail());
    }
  }
}
