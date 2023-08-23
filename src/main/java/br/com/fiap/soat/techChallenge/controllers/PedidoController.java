package br.com.fiap.soat.techChallenge.controllers;

import br.com.fiap.soat.techChallenge.entities.Pedido;
import br.com.fiap.soat.techChallenge.interfaces.usecases.FazerPedidoUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.ObterPedidosUseCasePort;
import br.com.fiap.soat.techChallenge.responses.PedidoResponse;
import br.com.fiap.soat.techChallenge.usecases.model.ComandoDeNovoPedido;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoController {

    private final FazerPedidoUseCasePort fazerPedidoUseCase;
    private final ObterPedidosUseCasePort obterPedidosUseCase;

    public PedidoController(FazerPedidoUseCasePort fazerPedidoUseCase, ObterPedidosUseCasePort obterPedidosUseCase) {
        this.fazerPedidoUseCase = fazerPedidoUseCase;
        this.obterPedidosUseCase = obterPedidosUseCase;
    }

    public PedidoResponse fazerPedido(ComandoDeNovoPedido comandoDeNovoPedido) {
        Pedido pedido = fazerPedidoUseCase.execute(comandoDeNovoPedido);
        return PedidoResponse.fromDomain(pedido);
    }

    public List<PedidoResponse> obterPedidos() {
        List<Pedido> pedidos = obterPedidosUseCase.execute();
        return pedidos.stream().map(PedidoResponse::fromDomain).collect(Collectors.toList());
    }
}
