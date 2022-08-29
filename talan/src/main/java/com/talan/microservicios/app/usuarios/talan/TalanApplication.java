package com.talan.microservicios.app.usuarios.talan;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.tala.microservicios.app.usuarios.models.entity.alumno"})
public class TalanApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalanApplication.class, args);
	}

}
