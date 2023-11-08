package br.com.boletojuros.core.usecase;

import br.com.boletojuros.core.domain.BoletoCalculado;
import br.com.boletojuros.core.enums.TipoBoleto;
import br.com.boletojuros.core.enums.TipoExcecao;
import br.com.boletojuros.core.exception.ApplicationException;
import br.com.boletojuros.core.port.alt.ComplementoBoletoPort;
import br.com.boletojuros.core.port.oult.CalculoBoletoPort;
import br.com.boletojuros.core.port.oult.SalvarCalculoBoletoPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import br.com.boletojuros.core.domain.Boleto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
public class CalcularBoletoUseCase implements CalculoBoletoPort {

    private static final BigDecimal JUROS_DIARIOS = BigDecimal.valueOf(0.033);
    private final ComplementoBoletoPort complementoBoletoPort;
    private final SalvarCalculoBoletoPort salvarCalculoBoletoPort;

    @Override
    public BoletoCalculado executar(String codigo, LocalDate dataPagamento) {
        var boleto = complementoBoletoPort.executar(codigo);
        validar(boleto);

        //TODO - calcular boleto
        var diasVencidos = getDiasVencidos(boleto.getDataNascimento().toLocalDate(), dataPagamento);
        var valorJurosDia = JUROS_DIARIOS.multiply(boleto.getValor().divideToIntegralValue(BigDecimal.valueOf(100)));
        var juros = valorJurosDia.multiply(BigDecimal.valueOf(diasVencidos)).setScale(2, RoundingMode.HALF_EVEN);
        var boletoCalculado = BoletoCalculado.builder()
                .codigo(boleto.getCodigo())
                .dataPagamento(dataPagamento.atStartOfDay())
                .juros(juros)
                .dataNascimento(boleto.getDataNascimento())
                .valorOriginal(boleto.getValor())
                .valor(boleto.getValor().add(juros))
                .tipo(boleto.getTipo())
                .build();
        //TODO - salvar boleto
        salvarCalculoBoletoPort.executar(boletoCalculado);

        return boletoCalculado;
    }

    private void validar(Boleto boleto){
        if(boleto == null){
            throw new ApplicationException(TipoExcecao.BOLETO_INVALIDO);
        }
        if(boleto.getTipo() != TipoBoleto.XPTO){
            throw new ApplicationException(TipoExcecao.TIPO_BOLETO_INVALIDO);
        }
        if(boleto.getDataVencimento().isAfter(LocalDate.now().atStartOfDay())){
            throw new ApplicationException(TipoExcecao.BOLETO_NAO_VENCIDO);
        }
    }

    private Long getDiasVencidos(LocalDate dataNascimento, LocalDate dataPagamento){
        return ChronoUnit.DAYS.between(dataNascimento, dataPagamento);

    }
}
