package br.com.boletojuros.adapter.datasource.database.entity;

import br.com.boletojuros.core.enums.TipoBoleto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private String dataNascimento = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    @Column(name = "data_pagamento")
    private String dataPagamento = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    private BigDecimal juros;
    private TipoBoleto tipo;
}
