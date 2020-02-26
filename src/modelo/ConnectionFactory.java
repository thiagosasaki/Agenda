package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection(){
        Connection conexao = null;
        try{
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/agendadb", "root", "admin");
        }catch(SQLException excecao){
        	System.out.println("Conexão não pôde ser estabelecida...");
        }
        return conexao;
    }
}