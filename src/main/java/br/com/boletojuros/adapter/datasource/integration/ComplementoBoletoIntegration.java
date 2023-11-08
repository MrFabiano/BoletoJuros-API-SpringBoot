package br.com.boletojuros.adapter.datasource.integration;

import br.com.boletojuros.adapter.datasource.integration.client.ComplementoBoletoClient;
import br.com.boletojuros.adapter.datasource.mapper.BoletoMapper;
import br.com.boletojuros.core.domain.Boleto;
import br.com.boletojuros.core.port.alt.ComplementoBoletoPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ComplementoBoletoIntegration implements ComplementoBoletoPort {

    private final ComplementoBoletoClient complementoBoletoClient;
    private final BoletoMapper boletoMapper;

    @Override
    public Boleto executar(String codigo) {
        var boletoDTO = complementoBoletoClient.getBoleto(codigo);
        return boletoMapper.toDomain(boletoDTO);
    }
}
