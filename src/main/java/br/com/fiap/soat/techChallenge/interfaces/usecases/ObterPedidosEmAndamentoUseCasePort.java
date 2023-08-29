package br.com.fiap.soat.techChallenge.interfaces.usecases;

import br.com.fiap.soat.techChallenge.entities.Pedido;

import java.util.List;

public interface ObterPedidosEmAndamentoUseCasePort {
    public List<Pedido> execute();
}
