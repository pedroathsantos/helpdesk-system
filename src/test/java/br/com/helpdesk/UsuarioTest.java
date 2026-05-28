package br.com.helpdesk;

import br.com.helpdesk.model.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    public void deveCriarUsuarioCorretamente() {

        Usuario usuario = new Usuario(
                1L,
                "Pedro",
                "pedro@email.com",
                "123",
                "USUARIO"
        );

        assertEquals("Pedro", usuario.getNome());
        assertEquals("pedro@email.com", usuario.getEmail());
    }
}