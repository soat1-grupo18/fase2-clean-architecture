package br.com.fiap.soat.techChallenge.controllers;

import br.com.fiap.soat.techChallenge.entities.Pedido;
import br.com.fiap.soat.techChallenge.entities.StatusDoPedido;
import br.com.fiap.soat.techChallenge.interfaces.usecases.AtualizarStatusPedidoUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.FazerCheckoutPedidoUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.ObterPedidosEmAndamentoUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.ObterTodosPedidosUseCasePort;
import br.com.fiap.soat.techChallenge.presenters.PedidoPresenter;
import br.com.fiap.soat.techChallenge.usecases.model.ComandoDeNovoPedido;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PedidoController {

    private final FazerCheckoutPedidoUseCasePort fazerCheckoutPedidoUseCase;
    private final ObterTodosPedidosUseCasePort obterTodosPedidosUseCase;
    private final ObterPedidosEmAndamentoUseCasePort obterPedidosEmAndamentoUseCase;
    private final AtualizarStatusPedidoUseCasePort atualizarStatusPedidoUseCase;

    public PedidoController(FazerCheckoutPedidoUseCasePort fazerCheckoutPedidoUseCase,
                            ObterTodosPedidosUseCasePort obterTodosPedidosUseCase,
                            ObterPedidosEmAndamentoUseCasePort obterPedidosEmAndamentoUseCase,
                            AtualizarStatusPedidoUseCasePort atualizarStatusPedidoUseCase) {
        this.fazerCheckoutPedidoUseCase = fazerCheckoutPedidoUseCase;
        this.obterTodosPedidosUseCase = obterTodosPedidosUseCase;
        this.obterPedidosEmAndamentoUseCase = obterPedidosEmAndamentoUseCase;
        this.atualizarStatusPedidoUseCase = atualizarStatusPedidoUseCase;
    }

    public PedidoPresenter fazerCheckoutPedido(ComandoDeNovoPedido comandoDeNovoPedido) {
        Pedido pedido = fazerCheckoutPedidoUseCase.execute(comandoDeNovoPedido);
        return PedidoPresenter.fromDomain(pedido);
    }

    public List<PedidoPresenter> obterTodosPedidos() {
        List<Pedido> pedidos = obterTodosPedidosUseCase.execute();
        return pedidos.stream().map(PedidoPresenter::fromDomain).collect(Collectors.toList());
    }

    public List<PedidoPresenter> obterPedidosEmAndamento() {
        List<Pedido> pedidos = obterPedidosEmAndamentoUseCase.execute();
        return pedidos.stream().map(PedidoPresenter::fromDomain).collect(Collectors.toList());
    }

    public PedidoPresenter atualizarStatusPedido(UUID pedidoId, StatusDoPedido statusDoPedido) {
        Pedido pedido = atualizarStatusPedidoUseCase.execute(pedidoId, statusDoPedido);
        return PedidoPresenter.fromDomain(pedido);
    }
}
