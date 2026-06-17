package br.com.helpdesk.observer;

import br.com.helpdesk.model.Chamado;

public class NotificacaoObserver implements ChamadoObserver {

    @Override
    public void atualizar(Chamado chamado) {
        System.out.println("Chamado " + chamado.getId()
                + " atualizado para: " + chamado.getStatus());
    }
}
