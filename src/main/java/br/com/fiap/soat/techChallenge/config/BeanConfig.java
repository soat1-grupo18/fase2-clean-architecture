package br.com.fiap.soat.techChallenge.config;

import br.com.fiap.soat.techChallenge.core.ports.outbound.ClienteRepositoryPort;
import br.com.fiap.soat.techChallenge.core.ports.outbound.ProdutoRepositoryPort;
import br.com.fiap.soat.techChallenge.core.ports.outbound.PedidoRepositoryPort;

import br.com.fiap.soat.techChallenge.core.ports.inbound.CadastraClienteUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.inbound.FazerPedidoUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.inbound.IdentificaClienteUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.inbound.ObterProdutosPorCategoriaUseCasePort;

import br.com.fiap.soat.techChallenge.core.usecases.CadastraClienteUseCase;
import br.com.fiap.soat.techChallenge.core.usecases.CadastraProdutoUseCase;
import br.com.fiap.soat.techChallenge.core.usecases.FazerPedidoUseCase;
import br.com.fiap.soat.techChallenge.core.usecases.IdentificaClienteUseCase;
import br.com.fiap.soat.techChallenge.core.usecases.ObterProdutosPorCategoriaUseCase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CadastraClienteUseCasePort cadastraClienteUseCasePort(ClienteRepositoryPort clienteRepositoryPort) {
        return new CadastraClienteUseCase(clienteRepositoryPort);
    }

    @Bean
    public IdentificaClienteUseCasePort identificaClienteUseCasePort(ClienteRepositoryPort clienteRepositoryPort) {
        return new IdentificaClienteUseCase(clienteRepositoryPort);
    }

    @Bean
    public CadastraProdutoUseCase cadastraProdutoUseCasePort(ProdutoRepositoryPort produtoRepositoryPort) {
        return new CadastraProdutoUseCase(produtoRepositoryPort);
    }

    @Bean
    public ObterProdutosPorCategoriaUseCasePort identificaProdutoUseCasePort(ProdutoRepositoryPort produtoRepositoryPort) {
        return new ObterProdutosPorCategoriaUseCase(produtoRepositoryPort);
    }

    @Bean
    public FazerPedidoUseCasePort fazerPedidoUseCasePort(PedidoRepositoryPort pedidoRepositoryPort, ProdutoRepositoryPort produtoRepositoryPort) {
        return new FazerPedidoUseCase(pedidoRepositoryPort, produtoRepositoryPort);
    }
}
