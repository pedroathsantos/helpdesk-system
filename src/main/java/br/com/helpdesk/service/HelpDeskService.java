package br.com.helpdesk.service;

import br.com.helpdesk.exception.ChamadoNaoEncontradoException;
import br.com.helpdesk.model.*;
import br.com.helpdesk.observer.ChamadoObserver;
import br.com.helpdesk.repository.ChamadoRepository;

import java.util.ArrayList;
import java.util.List;

public class HelpDeskService implements ChamadoService {

    private ChamadoRepository repository;
    private List<ChamadoObserver> observers;

    public HelpDeskService(ChamadoRepository repository) {
        this.repository = repository;
        this.observers = new ArrayList<>();
    }

    public void adicionarObserver(ChamadoObserver observer) {
        observers.add(observer);
    }

    private void notificarObservers(Chamado chamado) {

        for (ChamadoObserver observer : observers) {
            observer.atualizar(chamado);
        }
    }

    @Override
    public void abrirChamado(Chamado chamado) {
        repository.salvar(chamado);
    }

    @Override
    public List<Chamado> listarChamados() {
        return repository.listarTodos();
    }

    @Override
    public Chamado buscarChamadoPorId(Long id) {

        Chamado chamado = repository.buscarPorId(id);

        if (chamado == null) {
            throw new ChamadoNaoEncontradoException(id);
        }

        return chamado;
    }

    @Override
    public void atualizarStatus(Long id, StatusChamado status) {

        Chamado chamado = buscarChamadoPorId(id);
        chamado.atualizarStatus(status);
        notificarObservers(chamado);
    }

    @Override
    public void atribuirTecnico(Long id, Tecnico tecnico) {

        Chamado chamado = buscarChamadoPorId(id);
        chamado.atribuirTecnico(tecnico);
    }

    @Override
    public void adicionarComentario(Long id, Comentario comentario) {

        Chamado chamado = buscarChamadoPorId(id);
        chamado.adicionarComentario(comentario);
    }
}