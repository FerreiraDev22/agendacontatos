package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.cotiinformatica.dtos.TipoQuantidadeDto;
import br.com.cotiinformatica.entities.Contato;
import br.com.cotiinformatica.enums.TipoContato;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class ContatoRepository {

	// método para cadastrar um contato no banco de dados
	public void create(Contato contato) throws Exception {

		Connection connection = ConnectionFactory.createConnection();

		PreparedStatement statement = connection.prepareStatement(
				"insert into contato(nome, telefone, email, datanascimento, tipo, idusuario) values(?,?,?,?,?,?)");

		statement.setString(1, contato.getNome());
		statement.setString(2, contato.getTelefone());
		statement.setString(3, contato.getEmail());
		statement.setDate(4, java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(contato.getDataNascimento())));
		
		Integer tipo = 0;
		switch(contato.getTipo()) {
		case FAMILIA: tipo = 1; break;
		case AMIGOS: tipo = 2; break;
		case TRABALHO: tipo = 3; break;
		case OUTROS: tipo = 4; break;
		}
		
		statement.setInt(5, tipo);
		statement.setInt(6, contato.getUsuario().getIdUsuario());
		statement.execute();

		connection.close();
	}

	// método para atualizar um contato no banco de dados
	public void update(Contato contato) throws Exception {

		Connection connection = ConnectionFactory.createConnection();

		PreparedStatement statement = connection.prepareStatement(
				"update contato set nome=?, telefone=?, email=?, datanascimento=?, tipo=? where idcontato=?");

		statement.setString(1, contato.getNome());
		statement.setString(2, contato.getTelefone());
		statement.setString(3, contato.getEmail());
		statement.setDate(4, java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(contato.getDataNascimento())));

		Integer tipo = 0;
		switch(contato.getTipo()) {
		case FAMILIA: tipo = 1; break;
		case AMIGOS: tipo = 2; break;
		case TRABALHO: tipo = 3; break;
		case OUTROS: tipo = 4; break;
		}
		
		statement.setInt(5, tipo);		
		statement.setInt(6, contato.getIdContato());
		statement.execute();

		connection.close();
	}

	// método para excluir um contato no banco de dados
	public void delete(Contato contato) throws Exception {

		Connection connection = ConnectionFactory.createConnection();

		PreparedStatement statement = connection.prepareStatement("delete from contato where idcontato=?");

		statement.setInt(1, contato.getIdContato());
		statement.execute();
		connection.close();
	}
	
	// método para consultar os contatos de um usuário
	public List<Contato> findByUsuario(Integer idUsuario) throws Exception {
		
		Connection connection = ConnectionFactory.createConnection();
		
		PreparedStatement statement = connection.prepareStatement
				("select * from contato where idusuario=? order by nome");
		
		statement.setInt(1, idUsuario);
		ResultSet resultSet = statement.executeQuery();
		
		List<Contato> lista = new ArrayList<Contato>();
		
		while(resultSet.next()) {
			
			Contato contato = new Contato();
			
			contato.setIdContato(resultSet.getInt("idcontato"));
			contato.setNome(resultSet.getString("nome"));
			contato.setEmail(resultSet.getString("email"));
			contato.setTelefone(resultSet.getString("telefone"));
			contato.setDataNascimento(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("datanascimento")));
			
			Integer tipo = resultSet.getInt("tipo");
			switch(tipo) {
			case 1: contato.setTipo(TipoContato.FAMILIA); break;
			case 2: contato.setTipo(TipoContato.AMIGOS); break;
			case 3: contato.setTipo(TipoContato.TRABALHO); break;
			case 4: contato.setTipo(TipoContato.OUTROS); break;
			}
			
			lista.add(contato); //adicionando o contato dentro da lista
		}
		
		connection.close();
		return lista; //retornando a lista
	}
	
	// método para consultar 1 contato através do id do contato e do id do usuário
	public Contato findById(Integer idContato, Integer idUsuario) throws Exception {
		
		Connection connection = ConnectionFactory.createConnection();
		
		PreparedStatement statement = connection.prepareStatement
				("select * from contato where idcontato=? and idusuario=?");
		
		statement.setInt(1, idContato);
		statement.setInt(2, idUsuario);
		ResultSet resultSet = statement.executeQuery();
		
		Contato contato = null; //vazio
		
		if(resultSet.next()) {
			
			contato = new Contato();
			
			contato.setIdContato(resultSet.getInt("idcontato"));
			contato.setNome(resultSet.getString("nome"));
			contato.setEmail(resultSet.getString("email"));
			contato.setTelefone(resultSet.getString("telefone"));
			contato.setDataNascimento(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("datanascimento")));

			Integer tipo = resultSet.getInt("tipo");
			switch(tipo) {
			case 1: contato.setTipo(TipoContato.FAMILIA); break;
			case 2: contato.setTipo(TipoContato.AMIGOS); break;
			case 3: contato.setTipo(TipoContato.TRABALHO); break;
			case 4: contato.setTipo(TipoContato.OUTROS); break;
			}
		}
		
		connection.close();
		return contato; //retornando o objeto
	}
	
	//Método para consultar a quantidade de contatos por tipo
	public List<TipoQuantidadeDto> countByTipo(Integer idUsuario) throws Exception {
		
		//abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.createConnection();
		
		//escrevendo a consulta
		String query = "select "
					 + "case "
					 + "when tipo = 1 then 'FAMILIA' "
					 + "when tipo = 2 then 'AMIGOS' "
					 + "when tipo = 3 then 'TRABALHO' "
					 + "when tipo = 4 then 'OUTROS' "
					 + "end "
					 + "as tipo, "
					 + "count(*) as quantidade "
					 + "from contato "
					 + "where idusuario = ? "
					 + "group by tipo";
		
		//executando a consulta no banco de dados
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, idUsuario);
		ResultSet resultSet = statement.executeQuery();
		
		List<TipoQuantidadeDto> lista = new ArrayList<TipoQuantidadeDto>();
		
		while(resultSet.next()) {
			
			TipoQuantidadeDto dto = new TipoQuantidadeDto();
			dto.setTipo(resultSet.getString("tipo"));
			dto.setQuantidade(resultSet.getInt("quantidade"));
			
			lista.add(dto);
		}
		
		connection.close();
		return lista;
	}
	
}















