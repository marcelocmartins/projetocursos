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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Boletim")
public class Boletim 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_boletim")
	private int idBoletim;
	
	@Column(name="nota")
	private float nota;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH} )
	@JoinColumn(name="id_turma")
	private List<Turma> turma;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH} )
	@JoinColumn(name="id_professor")
	private Professor professor;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH} )
	@JoinColumn(name="id_alunos")
	private Aluno aluno;
	
	public Boletim() {}
	
	@Autowired
	public Boletim(float nota, Turma turma, Professor professor, Aluno aluno) 
	{
		this.nota = nota;
		this.professor = professor;
		this.aluno = aluno;
	}
	
	// add a convenience method add
	
		public void addBoletimTurma(Turma theTurma)
		{
			if(turma == null)
			{
				turma = new ArrayList<Turma>();
			}
			
			turma.add(theTurma);   
		}
		
		public void gerarBoletim(Aluno aluno, Turma turma)
		{
			
		}
		
		
	
}
