package br.com.fiap.soat.techChallenge.api.requests;

import br.com.fiap.soat.techChallenge.usecases.model.ComandoDeConfirmacaoDePagamento;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.UUID;

public class ConfirmacaoPagamentoRequest {

    @Parameter(description = "Não utilizado")
    private String id;
    @Parameter(description = "Não utilizado")
    private String live_mode;
    @Parameter(description = "Não utilizado")
    private String type;
    @Parameter(description = "Não utilizado")
    private String date_created;
    @Parameter(description = "Não utilizado")
    private String user_id;
    @Parameter(description = "Não utilizado")
    private String api_version;
    @Parameter(description = "Ação a ser processada. Somente a confirmação de pagamento é aceita no momento", example = "payment.created")
    private String action;
    @Parameter(description = "O id de pagamento registrado no checkout de pedido")
    private ConfirmacaoPagamentoDataRequest data;

    public ComandoDeConfirmacaoDePagamento toDomain() {
        return new ComandoDeConfirmacaoDePagamento(this.getAction(), UUID.fromString(this.getData().getId()));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLive_mode() {
        return live_mode;
    }

    public void setLive_mode(String live_mode) {
        this.live_mode = live_mode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public ConfirmacaoPagamentoDataRequest getData() {
        return data;
    }

    public void setData(ConfirmacaoPagamentoDataRequest data) {
        this.data = data;
    }
}
