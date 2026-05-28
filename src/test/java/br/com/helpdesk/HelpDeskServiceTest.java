package br.com.helpdesk;

import br.com.helpdesk.model.*;
import br.com.helpdesk.service.HelpDeskService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HelpDeskServiceTest {

    @Test
    public void deveAdicionarChamadoNaLista() {

        HelpDeskService service = new HelpDeskService();

        Usuario usuario = new Usuario(
                1L,
                "Pedro",
                "pedro@email.com",
                "123",
                "USUARIO"
        );

        Categoria categoria = new Categoria(1L, "Hardware");

        Chamado chamado = new Chamado(
                1L,
                "Mouse não funciona",
                "Mouse desconectado",
                Prioridade.BAIXA,
                usuario,
                categoria
        );

        service.abrirChamado(chamado);

        assertEquals(1, service.listarChamados().size());
    }

    @Test
    public void deveAtribuirTecnicoAoChamado() {

        HelpDeskService service = new HelpDeskService();

        Usuario usuario = new Usuario(
                1L,
                "Pedro",
                "pedro@email.com",
                "123",
                "USUARIO"
        );

        Tecnico tecnico = new Tecnico(
                2L,
                "Carlos",
                "carlos@email.com",
                "123",
                "Infraestrutura"
        );

        Categoria categoria = new Categoria(1L, "Rede");

        Chamado chamado = new Chamado(
                1L,
                "Sem internet",
                "Internet caiu",
                Prioridade.ALTA,
                usuario,
                categoria
        );

        service.abrirChamado(chamado);

        service.atribuirTecnico(1L, tecnico);

        assertEquals(tecnico, chamado.getTecnico());
    }
}