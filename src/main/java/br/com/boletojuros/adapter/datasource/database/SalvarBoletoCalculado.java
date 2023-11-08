package br.com.boletojuros.adapter.datasource.database;

import br.com.boletojuros.adapter.datasource.database.repository.BoletoCalculadoRepository;
import br.com.boletojuros.adapter.datasource.mapper.BoletoCalculadoMapper;
import br.com.boletojuros.core.domain.BoletoCalculado;
import br.com.boletojuros.core.port.oult.SalvarCalculoBoletoPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class SalvarBoletoCalculado implements SalvarCalculoBoletoPort {

    protected BoletoCalculadoRepository boletoCalculadoRepository;
    protected BoletoCalculadoMapper boletoCalculadoMapper;
    @Override
    public void executar(BoletoCalculado boletoCalculado) {
        var entity = boletoCalculadoMapper.toEntity(boletoCalculado);
        boletoCalculadoRepository.save(entity);
    }
}
