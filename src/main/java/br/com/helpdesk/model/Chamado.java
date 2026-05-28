package br.com.helpdesk.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Chamado {

    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataAbertura;
    private StatusChamado status;
    private Prioridade prioridade;

    private Usuario usuario;
    private Tecnico tecnico;
    private Categoria categoria;

    private List<Comentario> comentarios;

    public Chamado(Long id,
                    String titulo,
                    String descricao,
                    Prioridade prioridade,
                    Usuario usuario,
                    Categoria categoria) {

        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.usuario = usuario;
        this.categoria = categoria;

        this.status = StatusChamado.ABERTO;
        this.dataAbertura = LocalDateTime.now();
        this.comentarios = new ArrayList<>();
    }

    public void atualizarStatus(StatusChamado novoStatus) {
        this.status = novoStatus;
    }

    public void atribuirTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public void adicionarComentario(Comentario comentario) {
        comentarios.add(comentario);
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public StatusChamado getStatus() {
        return status;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }
}