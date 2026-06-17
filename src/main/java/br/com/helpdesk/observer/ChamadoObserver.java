package br.com.helpdesk.observer;

import br.com.helpdesk.model.Chamado;

public interface ChamadoObserver {

    void atualizar(Chamado chamado);
}
