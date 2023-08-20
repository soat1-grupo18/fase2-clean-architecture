package br.com.fiap.soat.techChallenge.config;

import br.com.fiap.soat.techChallenge.controllers.ClienteController;
import br.com.fiap.soat.techChallenge.controllers.PedidoController;
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
    public ClienteController clienteController(CadastrarClienteUseCasePort cadastrarClienteUseCase,
                                               IdentificarClienteUseCasePort identificarClienteUseCase) {
        return new ClienteController(cadastrarClienteUseCase, identificarClienteUseCase);
    }

    @Bean
    public PedidoController pedidoController(FazerPedidoUseCasePort fazerPedidoUseCase, ObterPedidosUseCasePort obterPedidosUseCase) {
        return new PedidoController(fazerPedidoUseCase, obterPedidosUseCase);
    }

    @Bean
    public CadastrarClienteUseCasePort cadastrarClienteUseCasePort(ClienteGatewayPort clienteGatewayPort) {
        return new CadastrarClienteUseCase(clienteGatewayPort);
    }

    @Bean
    public IdentificarClienteUseCasePort identificarClienteUseCasePort(ClienteGatewayPort clienteGatewayPort) {
        return new IdentificarClienteUseCase(clienteGatewayPort);
    }

    @Bean
    public CadastrarProdutoUseCase cadastrarProdutoUseCasePort(ProdutoGatewayPort produtoGatewayPort) {
        return new CadastrarProdutoUseCase(produtoGatewayPort);
    }

    @Bean
    public EditarProdutoUseCase editarProdutoUseCasePort(ProdutoGatewayPort produtoGatewayPort) {
        return new EditarProdutoUseCase(produtoGatewayPort);
    }

    @Bean
    public ExcluirProdutoUseCase excluirProdutoUseCasePort(ProdutoGatewayPort produtoGatewayPort) {
        return new ExcluirProdutoUseCase(produtoGatewayPort);
    }

    @Bean
    public ObterProdutosPorCategoriaUseCasePort identificarProdutoUseCasePort(ProdutoGatewayPort produtoGatewayPort) {
        return new ObterProdutosPorCategoriaUseCase(produtoGatewayPort);
    }

    @Bean
    public FazerPedidoUseCasePort fazerPedidoUseCasePort(PedidoGatewayPort pedidoGatewayPort, ProdutoGatewayPort produtoGatewayPort, ClienteGatewayPort clienteGatewayPort) {
        return new FazerPedidoUseCase(pedidoGatewayPort, produtoGatewayPort, clienteGatewayPort);
    }

    @Bean
    public ObterPedidosUseCasePort obterPedidosUseCasePort(PedidoGatewayPort pedidoGatewayPort) {
        return new ObterPedidosUseCase(pedidoGatewayPort);
    }
}
