package br.com.helpdesk.model;

import java.time.LocalDateTime;

public class Comentario {

    private Long id;
    private String mensagem;
    private LocalDateTime dataComentario;
    private String autor;

    public Comentario(Long id, String mensagem, String autor) {
        this.id = id;
        this.mensagem = mensagem;
        this.autor = autor;
        this.dataComentario = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataComentario() {
        return dataComentario;
    }

    public String getAutor() {
        return autor;
    }
}