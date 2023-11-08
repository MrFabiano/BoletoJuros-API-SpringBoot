package br.com.boletojuros.core.domain;

import br.com.boletojuros.core.enums.TipoBoleto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class Boleto {

    private String codigo;
    private LocalDateTime dataNascimento = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    private LocalDateTime dataVencimento = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));;
    private BigDecimal valor;
    private TipoBoleto tipo;

}
