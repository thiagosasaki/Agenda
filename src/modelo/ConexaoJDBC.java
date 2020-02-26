package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJDBC {
	public static void main(String[] args) {
		try {
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/agendadb",
															"root",
															"admin");
			System.out.println("Conex�o estabelecida...");
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Conex�o n�o p�de ser estabelecida...");
			System.out.println(e.getMessage());
		}
		
		//Connection conn = ConnectionFactory.getConnection();
	}
}
