package br.com.cotiinformatica.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// atributos
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String HOST = "jdbc:postgresql://localhost:5432/bd_agendacontatos1";
	private static final String USER = "postgres";
	private static final String PASS = "johnny";

	// método para abrir e retornar uma conexão com o PostGreSQL
	public static Connection createConnection() throws Exception {
		Class.forName(DRIVER);
		return DriverManager.getConnection(HOST, USER, PASS);
	}
}
