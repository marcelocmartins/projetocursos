package br.com.hbsis.projetocursos.entity;

import br.com.hbsis.projetocursos.entity.AlunoDTO.AlunoDTOBuilder;
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
	
}
