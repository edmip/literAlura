package com.aluracursos.literalura;


import com.aluracursos.literalura.principal.Principal;
import com.aluracursos.literalura.repository.IAutorRepository;
import com.aluracursos.literalura.repository.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

    @Autowired
    private ILibroRepository repository;

	@Autowired
	private IAutorRepository repository2;


	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal(repository, repository2);
		principal.muestraElMennu();

	}
}
