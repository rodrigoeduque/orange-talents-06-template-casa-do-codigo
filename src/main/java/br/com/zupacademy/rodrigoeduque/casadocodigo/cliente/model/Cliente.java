package br.com.zupacademy.rodrigoeduque.casadocodigo.cliente.model;

import br.com.zupacademy.rodrigoeduque.casadocodigo.config.validacao.anotationValidator.cpfoucnpj.CpfCnpj;
import br.com.zupacademy.rodrigoeduque.casadocodigo.estado.model.Estado;
import br.com.zupacademy.rodrigoeduque.casadocodigo.pais.model.Pais;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Email @Column(nullable = false)
    private String email;
    @NotBlank @Column(nullable = false)
    private String nome;
    @NotBlank @Column(nullable = false)
    private String sobrenome;
    @NotBlank @CpfCnpj @Column(nullable = false)
    private String documento;
    @NotBlank @Column(nullable = false)
    private String endereco;
    @NotBlank @Column(nullable = false)
    private String complemento;
    @NotBlank @Column(nullable = false)
    private String cidade;
    @ManyToOne @NotNull
    private Pais pais;
    @ManyToOne
    private Estado estado;
    @NotBlank @Column(nullable = false)
    private String telefone;
    @NotBlank @Column(nullable = false)
    private String cep;

    public Cliente(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Pais pais, Estado estado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", pais=" + pais +
                ", estado=" + estado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}