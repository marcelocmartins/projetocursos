package br.com.hbsis.projetocursos.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="Boletim")
public class Boletim 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_boletim")
	private int idBoletim;
	
	@Column(name="nota")
	private double nota;
	
	@OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH} )
	@JoinColumn(name="id_turma")
	private Turma turma;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH} )
	@JoinColumn(name="id_professor")
	private Professor professor;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH} )
	@JoinColumn(name="id_alunos")
	private Aluno aluno;

}
