package br.com.boletojuros.core.port.oult;

import br.com.boletojuros.core.domain.BoletoCalculado;

public interface SalvarCalculoBoletoPort {

    void executar(BoletoCalculado boletoCalculado);
}
