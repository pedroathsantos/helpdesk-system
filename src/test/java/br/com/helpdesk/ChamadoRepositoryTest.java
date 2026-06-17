package br.com.helpdesk;

import br.com.helpdesk.model.Chamado;
import br.com.helpdesk.model.Categoria;
import br.com.helpdesk.model.Prioridade;
import br.com.helpdesk.model.Usuario;
import br.com.helpdesk.repository.ChamadoRepository;
import br.com.helpdesk.repository.ChamadoRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChamadoRepositoryTest {

    private ChamadoRepository criarRepository() {
        return new ChamadoRepositoryImpl();
    }

    private Chamado criarChamado(Long id, String titulo) {

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
                "Descricao do chamado",
                Prioridade.MEDIA,
                usuario,
                categoria
        );
    }

    @Test
    public void deveSalvarChamadoNoRepositorio() {

        ChamadoRepository repository = criarRepository();

        Chamado chamado = criarChamado(1L, "Problema no PC");

        repository.salvar(chamado);

        assertEquals(1, repository.listarTodos().size());
    }

    @Test
    public void deveBuscarChamadoPorId() {

        ChamadoRepository repository = criarRepository();

        Chamado chamado = criarChamado(1L, "Teclado com defeito");

        repository.salvar(chamado);

        Chamado encontrado = repository.buscarPorId(1L);

        assertNotNull(encontrado);
        assertEquals("Teclado com defeito", encontrado.getTitulo());
    }

    @Test
    public void deveRetornarNullQuandoIdNaoExiste() {

        ChamadoRepository repository = criarRepository();

        Chamado encontrado = repository.buscarPorId(99L);

        assertNull(encontrado);
    }

    @Test
    public void deveRemoverChamadoDoRepositorio() {

        ChamadoRepository repository = criarRepository();

        Chamado chamado = criarChamado(1L, "Monitor apagado");

        repository.salvar(chamado);

        repository.remover(1L);

        assertEquals(0, repository.listarTodos().size());
    }

    @Test
    public void deveListarTodosOsChamados() {

        ChamadoRepository repository = criarRepository();

        repository.salvar(criarChamado(1L, "Chamado 1"));
        repository.salvar(criarChamado(2L, "Chamado 2"));
        repository.salvar(criarChamado(3L, "Chamado 3"));

        assertEquals(3, repository.listarTodos().size());
    }
}
