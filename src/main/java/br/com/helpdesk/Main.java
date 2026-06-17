package br.com.helpdesk;

import br.com.helpdesk.factory.UsuarioFactory;
import br.com.helpdesk.model.*;
import br.com.helpdesk.observer.NotificacaoObserver;
import br.com.helpdesk.repository.ChamadoRepository;
import br.com.helpdesk.repository.ChamadoRepositoryImpl;
import br.com.helpdesk.service.ChamadoService;
import br.com.helpdesk.service.HelpDeskService;

public class Main {

    public static void main(String[] args) {

        ChamadoRepository repository = new ChamadoRepositoryImpl();
        HelpDeskService service = new HelpDeskService(repository);

        service.adicionarObserver(new NotificacaoObserver());

        Usuario usuario = UsuarioFactory.criarUsuario(
                1L,
                "Pedro",
                "pedro@email.com",
                "123"
        );

        Tecnico tecnico = UsuarioFactory.criarTecnico(
                2L,
                "Carlos",
                "carlos@email.com",
                "123",
                "Redes"
        );

        Categoria categoria = new Categoria(
                1L,
                "Hardware"
        );

        Chamado chamado = new Chamado(
                1L,
                "Computador nao liga",
                "O computador nao inicia",
                Prioridade.ALTA,
                usuario,
                categoria
        );

        service.abrirChamado(chamado);

        service.atribuirTecnico(1L, tecnico);

        service.atualizarStatus(1L, StatusChamado.EM_ANDAMENTO);

        Comentario comentario = new Comentario(
                1L,
                "Verificando fonte do computador",
                tecnico.getNome()
        );

        service.adicionarComentario(1L, comentario);

        System.out.println("Chamado criado com sucesso!");
        System.out.println(chamado.getTitulo());
        System.out.println(chamado.getStatus());
    }
}