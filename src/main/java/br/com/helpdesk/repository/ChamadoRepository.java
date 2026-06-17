package br.com.helpdesk.repository;

import br.com.helpdesk.model.Chamado;

import java.util.List;

public interface ChamadoRepository {

    void salvar(Chamado chamado);

    Chamado buscarPorId(Long id);

    List<Chamado> listarTodos();

    void remover(Long id);
}
