package br.com.boletojuros.adapter.http.exception;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ErrorResponse {

    private List<String> mensagens = new ArrayList<>();
    private String erro;
    private int codigo;
    private Date timesTamp;
    private String path;
}
