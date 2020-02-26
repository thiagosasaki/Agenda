import modelo.Grupo;

import java.sql.Connection;
import java.sql.Statement;

import modelo.ConnectionFactory;
import modelo.Contato;

public class Principal {
	public static void main(String[] args) {
		Grupo G1 = new Grupo(1, "Família", "Discussões de família");
		Grupo G2 = new Grupo(2, "Faculdade", "Discussões acadêmicas");
		
		System.out.println("---GRUPOS---\n");
		
		System.out.println("Grupo " + G1.toString());
		System.out.println("Descrição: " + G1.getDescricao() + "\n");
		
		System.out.println("Grupo " + G2.toString());
		System.out.println("Descrição: " + G2.getDescricao() + "\n\n");
		
		
		//Inserindo Grupo 1 - Início
		try {
			Connection conexao = ConnectionFactory.getConnection();
			String sql = "INSERT INTO grupo(codigo,nome,descricao) " +
						"VALUES(" + G1.getCodigo() + ",'" + G1.getNome() + "','" + G1.getDescricao() + "')";
			Statement stmt = conexao.createStatement();
			stmt.execute(sql);
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		}
		
		//Inserindo Grupo 1 - Fim
		
		Contato C1 = new Contato(1, "Mãe", "(18) 99739-4777", G1);
		Contato C2 = new Contato(2, "Kanegae", "(18) 99812-6532", G2);
		
		System.out.println("---CONTATOS---\n");
		
		System.out.println("Contato " + C1.toString());
		System.out.println("Telefone: " + C1.getTelefone());
		System.out.println("Grupo " + C1.getGrupo().toString() + "\n");
		
		System.out.println("Contato " + C2.toString());
		System.out.println("Telefone: " + C2.getTelefone());
		System.out.println("Grupo " + C2.getGrupo().toString());
	
	}
}
