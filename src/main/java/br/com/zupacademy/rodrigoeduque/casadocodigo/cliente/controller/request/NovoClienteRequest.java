package br.com.zupacademy.rodrigoeduque.casadocodigo.cliente.controller.request;

import br.com.zupacademy.rodrigoeduque.casadocodigo.cliente.model.Cliente;
import br.com.zupacademy.rodrigoeduque.casadocodigo.config.validacao.anotationValidator.clientesValida.ClienteRestricoes;
import br.com.zupacademy.rodrigoeduque.casadocodigo.config.validacao.anotationValidator.cpfoucnpj.CpfCnpj;
import br.com.zupacademy.rodrigoeduque.casadocodigo.config.validacao.anotationValidator.valorunico.ValorUnico;
import br.com.zupacademy.rodrigoeduque.casadocodigo.estado.model.Estado;
import br.com.zupacademy.rodrigoeduque.casadocodigo.estado.repository.EstadoRepository;
import br.com.zupacademy.rodrigoeduque.casadocodigo.pais.model.Pais;
import br.com.zupacademy.rodrigoeduque.casadocodigo.pais.repository.PaisRepository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ClienteRestricoes(idPais = "idPais", idEstado = "idEstado")
public class NovoClienteRequest {

    @NotBlank
    @Email
    @ValorUnico(message = "E-mail de cliente já existe!", classe = Cliente.class, atributo = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobreNome;
    @NotBlank
    @CpfCnpj
    @ValorUnico(message = "Documento identificador já cadastrado anteriormente", classe = Cliente.class, atributo = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;

    @NotNull
    private Long idPais;

    private Long idEstado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @Deprecated
    public NovoClienteRequest() {
    }

    public NovoClienteRequest(String email, String nome, String sobreNome, String documento, String endereco, String complemento, String cidade, Long idPais, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository){
        Pais pais = paisRepository.getById(this.idPais);

        Estado estado = null;
        if(idEstado != null){
            estado = estadoRepository.getById(this.idEstado);
        }

        return new Cliente(this.email, this.nome, this.sobreNome, this.documento, this.endereco, this.complemento, this.cidade, pais, estado, this.telefone, this.cep);
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    @Override
    public String toString() {
        return "NovoClienteRequest{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", idPais=" + idPais +
                ", idEstado=" + idEstado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}

