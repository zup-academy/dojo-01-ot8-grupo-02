package br.com.zup.edu.sitedeviagens.controller.exception;

public class RegraNegocioException extends RuntimeException{

    private ErroDto erro;

    public RegraNegocioException(ErroDto error){
        this.erro = error;
    }

    public ErroDto getErro() {
        return erro;
    }
}
