package br.com.fiap.soat.techChallenge.application.config;

import br.com.fiap.soat.techChallenge.domain.ports.inbound.*;
import br.com.fiap.soat.techChallenge.domain.ports.outbound.ClienteRepositoryPort;
import br.com.fiap.soat.techChallenge.domain.ports.outbound.ProdutoRepositoryPort;
import br.com.fiap.soat.techChallenge.domain.ports.outbound.PedidoRepositoryPort;

import br.com.fiap.soat.techChallenge.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CadastrarClienteUseCasePort cadastrarClienteUseCasePort(ClienteRepositoryPort clienteRepositoryPort) {
        return new CadastrarClienteUseCase(clienteRepositoryPort);
    }

    @Bean
    public IdentificarClienteUseCasePort identificarClienteUseCasePort(ClienteRepositoryPort clienteRepositoryPort) {
        return new IdentificarClienteUseCase(clienteRepositoryPort);
    }

    @Bean
    public CadastrarProdutoUseCase cadastrarProdutoUseCasePort(ProdutoRepositoryPort produtoRepositoryPort) {
        return new CadastrarProdutoUseCase(produtoRepositoryPort);
    }

    @Bean
    public EditarProdutoUseCase editarProdutoUseCasePort(ProdutoRepositoryPort produtoRepositoryPort) {
        return new EditarProdutoUseCase(produtoRepositoryPort);
    }

    @Bean
    public ExcluirProdutoUseCase excluirProdutoUseCasePort(ProdutoRepositoryPort produtoRepositoryPort) {
        return new ExcluirProdutoUseCase(produtoRepositoryPort);
    }

    @Bean
    public ObterProdutosPorCategoriaUseCasePort identificarProdutoUseCasePort(ProdutoRepositoryPort produtoRepositoryPort) {
        return new ObterProdutosPorCategoriaUseCase(produtoRepositoryPort);
    }

    @Bean
    public FazerPedidoUseCasePort fazerPedidoUseCasePort(PedidoRepositoryPort pedidoRepositoryPort, ProdutoRepositoryPort produtoRepositoryPort, ClienteRepositoryPort clienteRepositoryPort) {
        return new FazerPedidoUseCase(pedidoRepositoryPort, produtoRepositoryPort, clienteRepositoryPort);
    }

    @Bean
    public ObterPedidosUseCasePort obterPedidosUseCasePort(PedidoRepositoryPort pedidoRepositoryPort) {
        return new ObterPedidosUseCase(pedidoRepositoryPort);
    }
}
