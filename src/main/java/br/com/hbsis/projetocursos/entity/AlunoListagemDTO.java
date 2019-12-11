package br.com.hbsis.projetocursos.entity;

import java.util.List;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AlunoListagemDTO {
	
	private int id;
	private String nome;
	private String cpf;
	private Integer idade;
	private String turma;
	private Integer idTurma;
	private List<String> boletim;

	public AlunoListagemDTO transformAlunoIntoAlunoListagem(Aluno aluno, String turma, Integer turmaId, List<String> boletim) {

		return AlunoListagemDTO.builder()
				.id(aluno.getIdAlunos())
				.cpf(aluno.getCpf())
				.nome(aluno.getNome())
				.idade(aluno.getIdade())
				.turma(turma)
				.idTurma(turmaId)
				.boletim(boletim)
				.build();
	}
}