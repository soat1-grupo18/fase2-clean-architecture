package br.com.fiap.soat.techChallenge.controllers;

import br.com.fiap.soat.techChallenge.entities.Pedido;
import br.com.fiap.soat.techChallenge.interfaces.usecases.FazerCheckoutPedidoUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.ObterPedidosUseCasePort;
import br.com.fiap.soat.techChallenge.presenters.PedidoPresenter;
import br.com.fiap.soat.techChallenge.usecases.model.ComandoDeNovoPedido;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoController {

    private final FazerCheckoutPedidoUseCasePort fazerCheckoutPedidoUseCase;
    private final ObterPedidosUseCasePort obterPedidosUseCase;

    public PedidoController(FazerCheckoutPedidoUseCasePort fazerCheckoutPedidoUseCase, ObterPedidosUseCasePort obterPedidosUseCase) {
        this.fazerCheckoutPedidoUseCase = fazerCheckoutPedidoUseCase;
        this.obterPedidosUseCase = obterPedidosUseCase;
    }

    public PedidoPresenter fazerCheckoutPedido(ComandoDeNovoPedido comandoDeNovoPedido) {
        Pedido pedido = fazerCheckoutPedidoUseCase.execute(comandoDeNovoPedido);
        return PedidoPresenter.fromDomain(pedido);
    }

    public List<PedidoPresenter> obterPedidos() {
        List<Pedido> pedidos = obterPedidosUseCase.execute();
        return pedidos.stream().map(PedidoPresenter::fromDomain).collect(Collectors.toList());
    }
}
