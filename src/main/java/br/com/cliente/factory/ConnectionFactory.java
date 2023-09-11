package br.com.cliente.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "root";
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cliente";
	
	public static Connection createConnectionToMySql() throws Exception {
		
		Class.forName("com..mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		Connection con = createConnectionToMySql();
		
		if(con!=null) {
			System.out.println("Conexão obtida com suesso");
			con.close();
		}
	}
}
