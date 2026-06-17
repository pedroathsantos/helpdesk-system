package br.com.helpdesk.model;

public class Tecnico extends Usuario {

    private String especialidade;

    public Tecnico(Long id, String nome, String email, String senha,
                    String especialidade) {

        super(id, nome, email, senha, "TECNICO");
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }
}