package br.com.hbsis.projetocursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//
//import br.com.hbsis.projetocursos.filedemo.properties.FileStorageProperties;

@SpringBootApplication
//@EnableConfigurationProperties({FileStorageProperties.class})
public class ProjetocursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetocursosApplication.class, args);
	}

}
