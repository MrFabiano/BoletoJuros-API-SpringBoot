package br.com.boletojuros.core.domain;

import br.com.boletojuros.core.enums.TipoBoleto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class BoletoCalculado {

    private String codigo;
    private BigDecimal valorOriginal;
    private BigDecimal valor;
    private LocalDateTime dataNascimento;
    private LocalDateTime dataPagamento;
    private BigDecimal juros;
    private TipoBoleto tipo;
}
