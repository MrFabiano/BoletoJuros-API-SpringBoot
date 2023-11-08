package br.com.boletojuros.core.port.oult;

import br.com.boletojuros.core.domain.BoletoCalculado;

import java.time.LocalDate;

public interface CalculoBoletoPort {
    BoletoCalculado executar(String codigo, LocalDate dataPagamento);
}
