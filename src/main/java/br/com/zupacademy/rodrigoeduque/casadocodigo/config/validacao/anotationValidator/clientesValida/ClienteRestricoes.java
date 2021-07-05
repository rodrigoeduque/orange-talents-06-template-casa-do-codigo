package br.com.zupacademy.rodrigoeduque.casadocodigo.config.validacao.anotationValidator.clientesValida;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ClienteRestricoesValidator.class})
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ClienteRestricoes {

    String message() default "Dados Relacionados ao Estado/Pais do Cliente estão inválidos";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String idPais();

    String idEstado();
}