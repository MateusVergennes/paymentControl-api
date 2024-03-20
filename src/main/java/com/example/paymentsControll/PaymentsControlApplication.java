package com.example.paymentsControll;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "PaymentoControl API", version = "1", description = "API for PaymentControl"), servers = { @Server(url = "/") })
public class PaymentsControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentsControlApplication.class, args);
	}

}
