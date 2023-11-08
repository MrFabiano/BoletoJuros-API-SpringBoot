package br.com.boletojuros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = {"br.com.boletojuros.adapter.datasource.mapper"})
public class BoletojurosApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoletojurosApplication.class, args);
	}

}
