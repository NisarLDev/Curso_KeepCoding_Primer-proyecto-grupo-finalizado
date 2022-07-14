package com.formacionspring.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info =@Info(title ="Api Clientes",version="1.0",description ="Crud completo api restfull"))
@SpringBootApplication
public class PrimerProyectoGrupoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimerProyectoGrupoApplication.class, args);
	}

}
