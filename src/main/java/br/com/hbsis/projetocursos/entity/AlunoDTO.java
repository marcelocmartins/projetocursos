package br.com.hbsis.projetocursos.entity;

import java.util.List;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AlunoDTO {
	
	private int id;
	private String nome;
	private String cpf;
	private String idade;
	private List<BoletimDTO> boletimDTO;
	
}
