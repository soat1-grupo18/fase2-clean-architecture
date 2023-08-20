package br.com.fiap.soat.techChallenge.usecases;
import br.com.fiap.soat.techChallenge.entities.Produto;
import br.com.fiap.soat.techChallenge.interfaces.usecases.CadastrarProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.gateways.ProdutoGatewayPort;

public class CadastrarProdutoUseCase implements CadastrarProdutoUseCasePort {
    private final ProdutoGatewayPort produtoGatewayPort;

    public CadastrarProdutoUseCase(ProdutoGatewayPort produtoGatewayPort) {
        this.produtoGatewayPort = produtoGatewayPort;
    }

    @Override
    public Produto execute(Produto produto) {
        return produtoGatewayPort.cadastrar(produto);
    }
}
