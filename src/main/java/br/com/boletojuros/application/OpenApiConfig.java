package br.com.boletojuros.application;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("API juros boleto vencido")
                        .description("API para calcular juros de boleto vencido")
                        .contact(new Contact()
                                .name("Fabiano Teixeira")
                                .email("fabianno@outlook.com")
                        ).version("1.0.0"));
    }
}
