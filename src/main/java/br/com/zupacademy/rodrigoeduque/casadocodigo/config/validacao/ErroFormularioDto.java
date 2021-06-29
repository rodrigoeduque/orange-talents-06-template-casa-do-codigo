package br.com.zupacademy.rodrigoeduque.casadocodigo.config.validacao;

public class ErroFormularioDto {
    private String campoErro;
    private String mensagemErro;

    public ErroFormularioDto(String campoErro, String mensagemErro) {
        this.campoErro = campoErro;
        this.mensagemErro = mensagemErro;
    }

    public String getCampoErro() {
        return campoErro;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }
}
