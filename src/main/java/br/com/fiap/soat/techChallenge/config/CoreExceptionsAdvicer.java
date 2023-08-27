package br.com.fiap.soat.techChallenge.config;

import br.com.fiap.soat.techChallenge.exceptions.ClienteNaoEncontradoException;
import br.com.fiap.soat.techChallenge.exceptions.ConfirmacaoDePagamentoInvalidaException;
import br.com.fiap.soat.techChallenge.exceptions.PedidoNaoEncontradoException;
import br.com.fiap.soat.techChallenge.exceptions.ProdutoNaoEncontradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CoreExceptionsAdvicer {
    @ExceptionHandler(value = { ProdutoNaoEncontradoException.class })
    protected ResponseEntity<String> handleProdutoNaoEncontradoException(ProdutoNaoEncontradoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(value = { ClienteNaoEncontradoException.class })
    protected ResponseEntity<String> handleClienteNaoEncontradoException(ClienteNaoEncontradoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(value = { PedidoNaoEncontradoException.class })
    protected ResponseEntity<String> handlePedidoNaoEncontradoException(PedidoNaoEncontradoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(value = { ConfirmacaoDePagamentoInvalidaException.class })
    protected ResponseEntity<String> handleConfirmacaoDePagamentoInvalidaException(ConfirmacaoDePagamentoInvalidaException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
