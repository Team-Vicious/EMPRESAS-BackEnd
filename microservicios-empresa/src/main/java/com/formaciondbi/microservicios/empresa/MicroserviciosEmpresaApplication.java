package com.formaciondbi.microservicios.empresa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviciosEmpresaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosEmpresaApplication.class, args);
	}

}
