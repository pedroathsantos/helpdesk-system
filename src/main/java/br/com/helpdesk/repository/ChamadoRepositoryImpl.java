package br.com.helpdesk.repository;

import br.com.helpdesk.model.Chamado;

import java.util.ArrayList;
import java.util.List;

public class ChamadoRepositoryImpl implements ChamadoRepository {

    private List<Chamado> chamados;

    public ChamadoRepositoryImpl() {
        chamados = new ArrayList<>();
    }

    @Override
    public void salvar(Chamado chamado) {
        chamados.add(chamado);
    }

    @Override
    public Chamado buscarPorId(Long id) {

        for (Chamado chamado : chamados) {
            if (chamado.getId().equals(id)) {
                return chamado;
            }
        }

        return null;
    }

    @Override
    public List<Chamado> listarTodos() {
        return new ArrayList<>(chamados);
    }

    @Override
    public void remover(Long id) {

        Chamado chamadoParaRemover = null;

        for (Chamado chamado : chamados) {
            if (chamado.getId().equals(id)) {
                chamadoParaRemover = chamado;
            }
        }

        if (chamadoParaRemover != null) {
            chamados.remove(chamadoParaRemover);
        }
    }
}
