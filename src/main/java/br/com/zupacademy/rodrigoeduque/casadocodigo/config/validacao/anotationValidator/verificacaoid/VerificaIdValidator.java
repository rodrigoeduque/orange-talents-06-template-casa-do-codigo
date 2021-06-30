package br.com.zupacademy.rodrigoeduque.casadocodigo.config.validacao.anotationValidator.verificacaoid;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class VerificaIdValidator implements ConstraintValidator<VerificaId, Long> {

    private String atributo;
    private Class<?> classe;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(VerificaId verificaId) {
        atributo = verificaId.atributo();
        classe = verificaId.classe();
    }

    //validação só irá ocorrer quando minha condição ser verdadeira
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("select 1 from " + classe.getName() + " where " + atributo + "=:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();

        if (list.size() > 0) {
            return true;
        }

        return false;
    }
}
