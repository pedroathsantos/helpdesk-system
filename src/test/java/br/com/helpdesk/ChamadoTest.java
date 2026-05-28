package br.com.helpdesk;

import br.com.helpdesk.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChamadoTest {

    @Test
    public void deveCriarChamadoComStatusAberto() {

        Usuario usuario = new Usuario(
                1L,
                "Pedro",
                "pedro@email.com",
                "123",
                "USUARIO"
        );

        Categoria categoria = new Categoria(1L, "Software");

        Chamado chamado = new Chamado(
                1L,
                "Erro no sistema",
                "Sistema travando",
                Prioridade.MEDIA,
                usuario,
                categoria
        );

        assertEquals(StatusChamado.ABERTO, chamado.getStatus());
    }

    @Test
    public void deveAtualizarStatusDoChamado() {

        Usuario usuario = new Usuario(
                1L,
                "Pedro",
                "pedro@email.com",
                "123",
                "USUARIO"
        );

        Categoria categoria = new Categoria(1L, "Rede");

        Chamado chamado = new Chamado(
                1L,
                "Internet lenta",
                "Internet oscilando",
                Prioridade.ALTA,
                usuario,
                categoria
        );

        chamado.atualizarStatus(StatusChamado.EM_ANDAMENTO);

        assertEquals(StatusChamado.EM_ANDAMENTO,
                chamado.getStatus());
    }
}