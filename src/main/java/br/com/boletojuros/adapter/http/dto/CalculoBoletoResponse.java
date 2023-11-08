package br.com.boletojuros.adapter.http.dto;

import br.com.boletojuros.core.enums.TipoBoleto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class CalculoBoletoResponse {

    private String codigo;
    @JsonProperty("data_vencimento")
    private LocalDateTime dataVencimento = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));;
    private BigDecimal valor;
    private TipoBoleto tipo;
}
