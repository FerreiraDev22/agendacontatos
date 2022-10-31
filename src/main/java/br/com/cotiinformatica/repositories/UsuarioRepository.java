package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class UsuarioRepository {

	// m�todo para cadastrar um usu�rio no banco de dados
	public void create(Usuario usuario) throws Exception {

		//abrindo conex�o com o banco de dados
		Connection connection = ConnectionFactory.createConnection();
		
		//escrevendo um comando SQL no banco de dados
		PreparedStatement statement = connection.prepareStatement("insert into usuario(nome, email, senha) values(?, ?, ?)");
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getEmail());
		statement.setString(3, usuario.getSenha());
		statement.execute();
		
		//fechando a conex�o
		connection.close();
	}

}
