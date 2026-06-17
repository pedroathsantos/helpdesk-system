package br.com.helpdesk.service;

import br.com.helpdesk.model.*;

import java.util.List;

public interface ChamadoService {

    void abrirChamado(Chamado chamado);

    List<Chamado> listarChamados();

    Chamado buscarChamadoPorId(Long id);

    void atualizarStatus(Long id, StatusChamado status);

    void atribuirTecnico(Long id, Tecnico tecnico);

    void adicionarComentario(Long id, Comentario comentario);
}
