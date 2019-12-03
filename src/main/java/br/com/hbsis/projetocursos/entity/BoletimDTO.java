package br.com.hbsis.projetocursos.entity;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoletimDTO 
{
	private int id;
	private float nota;


	public BoletimDTO transformBoletimIntoBoletimDTO(Boletim boletim) {

		BoletimDTO boletimDTO = BoletimDTO.builder()
				.id(boletim.getIdBoletim())
				.nota(boletim.getNota())
				.build();

		return boletimDTO;
	}
	
}
