package br.com.boletojuros.adapter.http;

import br.com.boletojuros.adapter.http.dto.CalculoBoletoRequest;
import br.com.boletojuros.adapter.http.dto.CalculoBoletoResponse;
import br.com.boletojuros.adapter.http.mapper.CalculoBoletoMapper;
import br.com.boletojuros.core.port.oult.CalculoBoletoPort;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/boleto")
@AllArgsConstructor
public class CalculoBoletoController {

    private CalculoBoletoPort port;
    private CalculoBoletoMapper mapper;

    @PostMapping("/calculo")
    @Operation(summary = "Calcular juros de um boleto")
    public ResponseEntity<CalculoBoletoResponse> calcularBoleto(@Valid @RequestBody CalculoBoletoRequest request){
        var boletoCalculado = port.executar(request.getCodigo(), LocalDate.from(request.getDataPagamento()));
        return ResponseEntity.ok(mapper.toDTO(boletoCalculado));
    }
}
