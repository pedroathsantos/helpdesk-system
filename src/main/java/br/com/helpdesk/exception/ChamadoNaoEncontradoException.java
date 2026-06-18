package br.com.helpdesk.exception;

public class ChamadoNaoEncontradoException extends RuntimeException {

    public ChamadoNaoEncontradoException(Long id) {
        super("Chamado nao encontrado: " + id);
    }
}
