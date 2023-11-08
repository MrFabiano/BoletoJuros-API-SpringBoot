package br.com.boletojuros.core.exception;

import br.com.boletojuros.core.enums.TipoExcecao;
import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {

    private final TipoExcecao tipoExcecao;


    public ApplicationException(TipoExcecao tipoExcecao) {
        this.tipoExcecao = tipoExcecao;
    }
}
