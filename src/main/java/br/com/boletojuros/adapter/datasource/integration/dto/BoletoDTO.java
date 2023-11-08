package br.com.boletojuros.adapter.datasource.integration.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class BoletoDTO {

    private String codigo;
    private LocalDateTime dataVencimento = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    private BigDecimal valor;
    private String tipo;
}
