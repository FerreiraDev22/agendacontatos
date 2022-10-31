package br.com.cotiinformatica.entities;

import java.util.Date;

import br.com.cotiinformatica.enums.TipoContato;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contato {

	private Integer idContato;
	private String nome;
	private String telefone;
	private String email;
	private Date dataNascimento;
	private TipoContato tipo;
	private Usuario usuario;
	
}
