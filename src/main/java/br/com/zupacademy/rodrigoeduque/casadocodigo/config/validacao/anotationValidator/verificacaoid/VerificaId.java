package br.com.zupacademy.rodrigoeduque.casadocodigo.config.validacao.anotationValidator.verificacaoid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = VerificaIdValidator.class)
public @interface VerificaId {
    String message() default "Id incorreto/inexistente";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value() default "";

    String atributo();

    Class<?> classe();

}
