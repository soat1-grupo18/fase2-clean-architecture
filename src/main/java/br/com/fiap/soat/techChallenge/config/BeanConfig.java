package br.com.fiap.soat.techChallenge.config;

import br.com.fiap.soat.techChallenge.interfaces.usecases.*;
import br.com.fiap.soat.techChallenge.interfaces.gateways.ClienteGatewayPort;
import br.com.fiap.soat.techChallenge.interfaces.gateways.ProdutoGatewayPort;
import br.com.fiap.soat.techChallenge.interfaces.gateways.PedidoGatewayPort;

import br.com.fiap.soat.techChallenge.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CadastrarClienteUseCasePort cadastrarClienteUseCasePort(ClienteGatewayPort clienteRepositoryPort) {
        return new CadastrarClienteUseCase(clienteRepositoryPort);
    }

    @Bean
    public IdentificarClienteUseCasePort identificarClienteUseCasePort(ClienteGatewayPort clienteRepositoryPort) {
        return new IdentificarClienteUseCase(clienteRepositoryPort);
    }

    @Bean
    public CadastrarProdutoUseCase cadastrarProdutoUseCasePort(ProdutoGatewayPort produtoRepositoryPort) {
        return new CadastrarProdutoUseCase(produtoRepositoryPort);
    }

    @Bean
    public EditarProdutoUseCase editarProdutoUseCasePort(ProdutoGatewayPort produtoRepositoryPort) {
        return new EditarProdutoUseCase(produtoRepositoryPort);
    }

    @Bean
    public ExcluirProdutoUseCase excluirProdutoUseCasePort(ProdutoGatewayPort produtoRepositoryPort) {
        return new ExcluirProdutoUseCase(produtoRepositoryPort);
    }

    @Bean
    public ObterProdutosPorCategoriaUseCasePort identificarProdutoUseCasePort(ProdutoGatewayPort produtoRepositoryPort) {
        return new ObterProdutosPorCategoriaUseCase(produtoRepositoryPort);
    }

    @Bean
    public FazerPedidoUseCasePort fazerPedidoUseCasePort(PedidoGatewayPort pedidoRepositoryPort, ProdutoGatewayPort produtoRepositoryPort, ClienteGatewayPort clienteRepositoryPort) {
        return new FazerPedidoUseCase(pedidoRepositoryPort, produtoRepositoryPort, clienteRepositoryPort);
    }

    @Bean
    public ObterPedidosUseCasePort obterPedidosUseCasePort(PedidoGatewayPort pedidoRepositoryPort) {
        return new ObterPedidosUseCase(pedidoRepositoryPort);
    }
}
