package br.com.helpdesk.factory;

import br.com.helpdesk.model.Administrador;
import br.com.helpdesk.model.Tecnico;
import br.com.helpdesk.model.Usuario;

public class UsuarioFactory {

    public static Usuario criarUsuario(Long id, String nome,
                                       String email, String senha) {

        return new Usuario(id, nome, email, senha, "USUARIO");
    }

    public static Tecnico criarTecnico(Long id, String nome,
                                       String email, String senha,
                                       String especialidade) {

        return new Tecnico(id, nome, email, senha, especialidade);
    }

    public static Administrador criarAdministrador(Long id, String nome,
                                                    String email, String senha) {

        return new Administrador(id, nome, email, senha);
    }
}
