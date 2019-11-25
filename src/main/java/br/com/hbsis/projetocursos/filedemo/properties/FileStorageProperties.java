package br.com.hbsis.projetocursos.filedemo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix="file")
public class FileStorageProperties {
	private String uploadDir;
	


}
