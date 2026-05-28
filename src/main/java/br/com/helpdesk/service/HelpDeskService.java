package br.com.helpdesk.service;

import br.com.helpdesk.model.*;

import java.util.ArrayList;
import java.util.List;

public class HelpDeskService {

    private List<Chamado> chamados;

    public HelpDeskService() {
        chamados = new ArrayList<>();
    }

    public void abrirChamado(Chamado chamado) {
        chamados.add(chamado);
    }

    public List<Chamado> listarChamados() {
        return chamados;
    }

    public Chamado buscarChamadoPorId(Long id) {

        for (Chamado chamado : chamados) {
            if (chamado.getId().equals(id)) {
                return chamado;
            }
        }

        return null;
    }

    public void atualizarStatus(Long id, StatusChamado status) {

        Chamado chamado = buscarChamadoPorId(id);

        if (chamado != null) {
            chamado.atualizarStatus(status);
        }
    }

    public void atribuirTecnico(Long id, Tecnico tecnico) {

        Chamado chamado = buscarChamadoPorId(id);

        if (chamado != null) {
            chamado.atribuirTecnico(tecnico);
        }
    }

    public void adicionarComentario(Long id, Comentario comentario) {

        Chamado chamado = buscarChamadoPorId(id);

        if (chamado != null) {
            chamado.adicionarComentario(comentario);
        }
    }
}