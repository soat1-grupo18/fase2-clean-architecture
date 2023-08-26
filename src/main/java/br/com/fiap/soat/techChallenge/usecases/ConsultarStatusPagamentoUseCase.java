package br.com.fiap.soat.techChallenge.usecases;

import br.com.fiap.soat.techChallenge.interfaces.gateways.PagamentoGatewayPort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.ConsultarStatusPagamentoUseCasePort;

import java.util.UUID;

public class ConsultarStatusPagamentoUseCase implements ConsultarStatusPagamentoUseCasePort {
    private final PagamentoGatewayPort pagamentoGateway;

    public ConsultarStatusPagamentoUseCase(PagamentoGatewayPort pagamentoGateway) {
        this.pagamentoGateway = pagamentoGateway;
    }

    @Override
    public Boolean execute(UUID pedidoId) {
        return pagamentoGateway.consultarStatusPagamento(pedidoId);
    }
}
