package br.com.boletojuros.adapter.datasource.database.entity;

import br.com.boletojuros.core.enums.TipoBoleto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Table
@Entity(name = "boleto_calculado")
public class BoletoCalculadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    @Column(name = "valor_original")
    private BigDecimal valorOriginal;

    private BigDecimal valor;

    @Column(name = "data_nascimento")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataNascimento;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "data_pagamento")
    private LocalDateTime dataPagamento;

    private BigDecimal juros;
    private TipoBoleto tipo;
}
