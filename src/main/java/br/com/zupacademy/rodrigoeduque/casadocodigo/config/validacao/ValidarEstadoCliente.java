package br.com.zupacademy.rodrigoeduque.casadocodigo.config.validacao;

import br.com.zupacademy.rodrigoeduque.casadocodigo.cliente.controller.request.NovoClienteRequest;
import br.com.zupacademy.rodrigoeduque.casadocodigo.estado.model.Estado;
import br.com.zupacademy.rodrigoeduque.casadocodigo.estado.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class ValidarEstadoCliente implements Validator {

    private EstadoRepository estadoRepository;

    @Autowired
    public ValidarEstadoCliente(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NovoClienteRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    if (errors.hasErrors()){
        return;
    }
        this.checagemEstado((NovoClienteRequest) o, errors);
    }

    private void checagemEstado(NovoClienteRequest novoClienteRequest, Errors errors) {
            if(null == novoClienteRequest.getIdEstado()){
                this.paisTemEstado(novoClienteRequest,errors);
            }
            else {
                this.idDoEstadoehValido(
                        this.estadoRepository.findById(novoClienteRequest.getIdEstado()),novoClienteRequest.getIdPais(),errors
                );
            }
     }

    private void idDoEstadoehValido(Optional<Estado> estado, Long idPais, Errors errors) {
    if (estado.isEmpty()){
        errors.rejectValue("Id_Estado", "Id do Estado inválido");
        return;
    }
    this.verificaSeEstadoehDoPais(estado.get(), idPais, errors);
    }

    private void verificaSeEstadoehDoPais(Estado estado, Long idPais, Errors errors){
        if(!estado.perteceAoPais(idPais)){
            errors.rejectValue("EstadoID", "Estado não pertence a esse pais");
        }
    }

    private void paisTemEstado(NovoClienteRequest novoClienteRequest, Errors errors) {
        if(0!= this.estadoRepository.countByPais_Id(novoClienteRequest.getIdPais())){
        errors.rejectValue("estado_id", "Null","Id do Estado é obrigatoria para esta país");
        }
    }


}
