package br.com.zupacademy.rodrigoeduque.casadocodigo.config.validacao.anotationValidator.clientesValida;

import br.com.zupacademy.rodrigoeduque.casadocodigo.pais.model.Pais;
import org.springframework.beans.BeanWrapperImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.concurrent.atomic.AtomicBoolean;

public class ClienteRestricoesValidator implements ConstraintValidator<ClienteRestricoes, Object> {

    private String idPais;
    private String idEstado;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(ClienteRestricoes constraintAnnotation) {
        this.idPais = constraintAnnotation.idPais();
        this.idEstado = constraintAnnotation.idEstado();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext context) {
        Object idPaisValue = new BeanWrapperImpl(o).getPropertyValue(idPais);
        Object idEstadoValue = new BeanWrapperImpl(o).getPropertyValue(idEstado);

        if (paisExists(idPaisValue, context) && estadoIsValid(idPaisValue, idEstadoValue, context)) {
            return true; //retorna true se as validações anteriores não retornaram erro
        } else return false;
    }

    public Boolean paisExists(Object idPaisValue, ConstraintValidatorContext context) { //verifica se o idPais existe
        Pais possivelPais = entityManager.find(Pais.class, idPaisValue);
        if (possivelPais == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Identificador do Pais é inválido")
                    .addPropertyNode("idPais").addConstraintViolation();
            return false;
        }
        return true;
    }

    /*
       Valida se o país tem estados, caso tenha: Valida se o idEstado é nulo, se for, retorna erro. Caso não, valida se o idEstado
       (Estado) pertence ao idPais(Pais), caso não pertença, retorna erro. Caso pertença, não faz nada.
     */
    public Boolean estadoIsValid(Object idPaisValue, Object idEstadoValue, ConstraintValidatorContext context) {
        Pais pais = entityManager.find(Pais.class, idPaisValue);

        if (!pais.getEstados().isEmpty() && idEstadoValue == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Você precisa informar um estado para esse país")
                    .addPropertyNode("idEstado").addConstraintViolation();
            return false;
        } else if (!pais.getEstados().isEmpty() && idEstadoValue != null) {
            AtomicBoolean idEstadoPertenceIdPais = new AtomicBoolean(false);

            pais.getEstados().forEach(estado -> {
                if (estado.getId().equals(idEstadoValue)) {
                    idEstadoPertenceIdPais.set(true);
                }
            });

            if (idEstadoPertenceIdPais.get() == false) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Identificador Estado não pertence a esse país")
                        .addPropertyNode("idEstado").addConstraintViolation();

                return false;
            }
        }
        return true;
    }
}