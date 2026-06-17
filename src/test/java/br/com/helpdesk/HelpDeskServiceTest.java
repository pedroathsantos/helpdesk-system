package br.com.helpdesk;

import br.com.helpdesk.exception.ChamadoNaoEncontradoException;
import br.com.helpdesk.model.*;
import br.com.helpdesk.repository.ChamadoRepository;
import br.com.helpdesk.repository.ChamadoRepositoryImpl;
import br.com.helpdesk.service.HelpDeskService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HelpDeskServiceTest {

    private HelpDeskService criarService() {
        ChamadoRepository repository = new ChamadoRepositoryImpl();
        return new HelpDeskService(repository);
    }

    private Chamado criarChamado(Long id, String titulo, String descricao) {

        Usuario usuario = new Usuario(
                1L,
                "Pedro",
                "pedro@email.com",
                "123",
                "USUARIO"
        );

        Categoria categoria = new Categoria(1L, "Hardware");

        return new Chamado(
                id,
                titulo,
                descricao,
                Prioridade.BAIXA,
                usuario,
                categoria
        );
    }

    @Test
    public void deveAdicionarChamadoNaLista() {

        HelpDeskService service = criarService();

        Chamado chamado = criarChamado(1L, "Mouse nao funciona", "Mouse desconectado");

        service.abrirChamado(chamado);

        assertEquals(1, service.listarChamados().size());
    }

    @Test
    public void deveAtribuirTecnicoAoChamado() {

        HelpDeskService service = criarService();

        Tecnico tecnico = new Tecnico(
                2L,
                "Carlos",
                "carlos@email.com",
                "123",
                "Infraestrutura"
        );

        Chamado chamado = criarChamado(1L, "Sem internet", "Internet caiu");

        service.abrirChamado(chamado);

        service.atribuirTecnico(1L, tecnico);

        assertEquals(tecnico, chamado.getTecnico());
    }

    @Test
    public void deveBuscarChamadoPorId() {

        HelpDeskService service = criarService();

        Chamado chamado = criarChamado(1L, "Erro no sistema", "Sistema travando");

        service.abrirChamado(chamado);

        Chamado encontrado = service.buscarChamadoPorId(1L);

        assertEquals("Erro no sistema", encontrado.getTitulo());
    }

    @Test
    public void deveLancarExcecaoQuandoChamadoNaoEncontrado() {

        HelpDeskService service = criarService();

        assertThrows(ChamadoNaoEncontradoException.class, () -> {
            service.buscarChamadoPorId(99L);
        });
    }

    @Test
    public void deveAtualizarStatusDoChamadoViaService() {

        HelpDeskService service = criarService();

        Chamado chamado = criarChamado(1L, "Impressora com defeito", "Nao imprime");

        service.abrirChamado(chamado);

        service.atualizarStatus(1L, StatusChamado.EM_ANDAMENTO);

        assertEquals(StatusChamado.EM_ANDAMENTO, chamado.getStatus());
    }

    @Test
    public void deveAdicionarComentarioAoChamado() {

        HelpDeskService service = criarService();

        Chamado chamado = criarChamado(1L, "Monitor apagado", "Monitor nao liga");

        service.abrirChamado(chamado);

        Comentario comentario = new Comentario(
                1L,
                "Verificando cabo de forca",
                "Carlos"
        );

        service.adicionarComentario(1L, comentario);

        assertEquals(1, chamado.getComentarios().size());
    }

    @Test
    public void deveListarChamadosVazioInicialmente() {

        HelpDeskService service = criarService();

        assertEquals(0, service.listarChamados().size());
    }
}