package br.com.fiap.soat.techChallenge.config;

import br.com.fiap.soat.techChallenge.adapter.driven.adapter.CadastraClienteAdapter;
import br.com.fiap.soat.techChallenge.adapter.driven.adapter.IdentificaClienteAdapter;
import br.com.fiap.soat.techChallenge.core.ports.driver.CadastraClienteUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.driver.IdentificaClienteUseCasePort;
import br.com.fiap.soat.techChallenge.core.usecases.CadastraClienteUseCase;
import br.com.fiap.soat.techChallenge.core.usecases.IdentificaClienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CadastraClienteUseCasePort cadastraClienteUseCasePort(CadastraClienteAdapter cadastraClienteAdapter) {
        return new CadastraClienteUseCase(cadastraClienteAdapter);
    }

    @Bean
    public IdentificaClienteUseCasePort identificaClienteUseCasePort(IdentificaClienteAdapter identificaClienteAdapter) {
        return new IdentificaClienteUseCase(identificaClienteAdapter);
    }
}
