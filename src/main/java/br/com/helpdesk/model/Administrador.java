package br.com.helpdesk.model;

public class Administrador extends Usuario {

    public Administrador(Long id, String nome,
                         String email, String senha) {

        super(id, nome, email, senha, "ADMINISTRADOR");
    }
}