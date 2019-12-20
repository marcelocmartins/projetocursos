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
	private double nota;
	private int alunoId;
	private int turmaId;
	private int professorId;


	public BoletimDTO transformBoletimIntoBoletimDTO(Boletim boletim) {

		BoletimDTO boletimDTO = BoletimDTO.builder()
				.id(boletim.getIdBoletim())
				.nota(boletim.getNota())
				.alunoId(boletim.getAluno().getIdAlunos())
				.professorId(boletim.getProfessor().getIdProfessor())
				.turmaId(boletim.getTurma().getIdTurma())
				.build();

		return boletimDTO;
	}
	
}
