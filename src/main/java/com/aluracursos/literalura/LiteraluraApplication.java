package com.aluracursos.literalura;

import com.aluracursos.literalura.mensajes.Mensajes;
import com.aluracursos.literalura.principal.Principal;
import com.aluracursos.literalura.repository.ILibroRepository;
import com.aluracursos.literalura.service.ConsumoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

    @Autowired
    private ILibroRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal(repository);
		principal.muestraElMennu();


	}
}
