package br.com.hbsis.projetocursos.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Alunos")
public class Aluno 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_alunos")
	private int idAlunos;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="idade")
	private String idade;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH} )
	@JoinColumn(name="id_turma")
	private Turma turma;
	
	
	public Aluno() {}

	

	@Override
	public String toString() 
	{
		return "Employee [id=" + idAlunos + ", firstName=" + nome + ", lastName=" + cpf + ", email=" + idade + "]";
	}



	public Aluno(String nome, String cpf, String idade, Turma turma) 
	{
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.turma = turma;
	}
	
	
	

}
