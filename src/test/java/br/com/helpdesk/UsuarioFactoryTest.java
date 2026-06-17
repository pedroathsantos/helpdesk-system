package br.com.helpdesk;

import br.com.helpdesk.factory.UsuarioFactory;
import br.com.helpdesk.model.Administrador;
import br.com.helpdesk.model.Tecnico;
import br.com.helpdesk.model.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioFactoryTest {

    @Test
    public void deveCriarUsuarioComFactory() {

        Usuario usuario = UsuarioFactory.criarUsuario(
                1L, "Pedro", "pedro@email.com", "123"
        );

        assertEquals("Pedro", usuario.getNome());
        assertEquals("USUARIO", usuario.getCargo());
    }

    @Test
    public void deveCriarTecnicoComFactory() {

        Tecnico tecnico = UsuarioFactory.criarTecnico(
                2L, "Carlos", "carlos@email.com", "123", "Redes"
        );

        assertEquals("Carlos", tecnico.getNome());
        assertEquals("TECNICO", tecnico.getCargo());
        assertEquals("Redes", tecnico.getEspecialidade());
    }

    @Test
    public void deveCriarAdministradorComFactory() {

        Administrador admin = UsuarioFactory.criarAdministrador(
                3L, "Ana", "ana@email.com", "123"
        );

        assertEquals("Ana", admin.getNome());
        assertEquals("ADMINISTRADOR", admin.getCargo());
    }

    @Test
    public void tecnicoDeveSerUsuario() {

        Tecnico tecnico = UsuarioFactory.criarTecnico(
                1L, "Carlos", "carlos@email.com", "123", "Redes"
        );

        assertTrue(tecnico instanceof Usuario);
    }

    @Test
    public void administradorDeveSerUsuario() {

        Administrador admin = UsuarioFactory.criarAdministrador(
                1L, "Ana", "ana@email.com", "123"
        );

        assertTrue(admin instanceof Usuario);
    }
}
