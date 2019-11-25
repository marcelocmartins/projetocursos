package br.com.hbsis.projetocursos.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Turma")
public class Turma 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_turma")
	private int idTurma;
	
	@Column(name="nome_turma")
	private String nomeTurma;
	
	@Column(name="materia")
	private String materia;
	
	@Column(name="numero_alunos")
	private int numeroAlunos;
	
	@OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH} )
	@JoinColumn(name="id_professor")
	private List<Professor> professor;
	
	public Turma() {}
	
	@Autowired
	public Turma(String nomeTurma, String materia, int numeroAlunos, Professor professor) 
	{
		this.nomeTurma = nomeTurma;
		this.materia = materia;
		this.numeroAlunos = numeroAlunos;
	}
	
	
	
	// add a convenience method add
	
	public void addProfessorATurma(Professor theProfessor)
	{
		if(professor == null)
		{
			professor = new ArrayList<Professor>();
		}
		
		professor.add(theProfessor);   
	}
	

}
