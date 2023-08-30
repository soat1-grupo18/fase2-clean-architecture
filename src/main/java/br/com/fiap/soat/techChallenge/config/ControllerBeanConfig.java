package br.com.fiap.soat.techChallenge.config;

import br.com.fiap.soat.techChallenge.controllers.ClienteController;
import br.com.fiap.soat.techChallenge.controllers.PagamentoController;
import br.com.fiap.soat.techChallenge.controllers.PedidoController;
import br.com.fiap.soat.techChallenge.controllers.ProdutoController;
import br.com.fiap.soat.techChallenge.interfaces.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerBeanConfig {

    @Bean
    public ClienteController clienteController(CadastrarClienteUseCasePort cadastrarClienteUseCase,
                                               IdentificarClienteUseCasePort identificarClienteUseCase) {
        return new ClienteController(cadastrarClienteUseCase, identificarClienteUseCase);
    }

    @Bean
    public PedidoController pedidoController(FazerCheckoutPedidoUseCasePort fazerCheckoutPedidoUseCase,
                                             ObterTodosPedidosUseCasePort obterTodosPedidosUseCase,
                                             ObterPedidosEmAndamentoUseCasePort obterPedidosEmAndamentoUseCase,
                                             AtualizarStatusPedidoUseCasePort atualizarStatusPedidoUseCase) {
        return new PedidoController(fazerCheckoutPedidoUseCase, obterTodosPedidosUseCase, obterPedidosEmAndamentoUseCase, atualizarStatusPedidoUseCase);
    }

    @Bean
    public ProdutoController produtoController(CadastrarProdutoUseCasePort cadastrarProdutoUseCase,
                                               EditarProdutoUseCasePort editarProdutoUseCase,
                                               ExcluirProdutoUseCasePort excluirProdutoUseCase,
                                               ObterProdutosPorCategoriaUseCasePort obterProdutosPorCategoriaUseCase) {
        return new ProdutoController(cadastrarProdutoUseCase, editarProdutoUseCase, excluirProdutoUseCase, obterProdutosPorCategoriaUseCase);
    }

    @Bean
    public PagamentoController pagamentoController(ConsultarStatusPagamentoUseCasePort consultarStatusPagamentoUseCase,
                                                   ReceberConfirmacaoPagamentoUseCasePort receberConfirmacaoPagamentoUseCase) {
        return new PagamentoController(consultarStatusPagamentoUseCase, receberConfirmacaoPagamentoUseCase);
    }
}
