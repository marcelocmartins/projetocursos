package br.com.hbsis.projetocursos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Professor")
public class Professor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_professor")
	private int idProfessor;
	
	@Column(name="nome_professor")
	private String nomeProfessor;
	
	public Professor() {}

	public Professor(String nomeProfessor) 
	{
		this.nomeProfessor = nomeProfessor;
	}
	
	
}
