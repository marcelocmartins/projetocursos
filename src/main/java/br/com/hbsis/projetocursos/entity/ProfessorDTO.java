package br.com.hbsis.projetocursos.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProfessorDTO
{
	private int idProfessor;
	private String nomeProfessor;

	public ProfessorDTO transformProfessorIntoProfessorDTO (Professor professor) {

		return ProfessorDTO.builder()
				.idProfessor(professor.getIdProfessor())
				.nomeProfessor(professor.getNomeProfessor())
				.build();
	}

	public Professor transformProfessorDTOIntoProfessor (ProfessorDTO professorDTO) {


		return Professor.builder()
				.idProfessor(professorDTO.getIdProfessor())
				.nomeProfessor(professorDTO.getNomeProfessor())
				.build();
	}
}
