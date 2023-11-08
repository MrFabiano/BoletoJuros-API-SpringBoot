package br.com.boletojuros.core.enums;

public enum TipoExcecao {

    BOLETO_INVALIDO {
        @Override
        public String getMessageError() {
            return "O boleto encontrado é inválido";
        }
    },
    TIPO_BOLETO_INVALIDO {
        @Override
        public String getMessageError() {
            return "Infelizmente só podemos calcular o juros dos boleto XPTO";
        }
    },
    BOLETO_NAO_VENCIDO {
        @Override
        public String getMessageError() {
            return "O boleto informado ainda não está vencido";
        }
    };

    public abstract  String getMessageError();
}

