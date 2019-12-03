package br.com.hbsis.projetocursos.entity;

import lombok.*;

import java.util.List;

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
	private Integer idade;
	private TurmaDTO turmaDTO;


	public Aluno transformAlunoDTOIntoAluno(AlunoDTO alunoListagemDTO, Turma turma) {

		return Aluno.builder()
				.cpf(alunoListagemDTO.getCpf())
				.nome(alunoListagemDTO.getNome())
				.idade(alunoListagemDTO.getIdade())
				.turma(turma)
				.build();

	}

	public AlunoDTO transformAlunoIntoAlunoDTO(Aluno aluno, Turma turma) {

		TurmaDTO theTurmaDTO = new TurmaDTO().transformTurmaIntoPojo(turma);

		return AlunoDTO.builder()
				.id(aluno.getIdAlunos())
				.cpf(aluno.getCpf())
				.nome(aluno.getNome())
				.idade(aluno.getIdade())
				.turmaDTO(theTurmaDTO)
				.build();
	}

}