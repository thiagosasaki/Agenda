import modelo.Grupo;
import modelo.Scripts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import modelo.ConnectionFactory;
import modelo.Contato;

public class Principal {
	public static void main(String[] args) {
		Connection conexao = ConnectionFactory.getConnection();
		Scripts s = new Scripts();
		
		Grupo G1 = new Grupo(1, "Família", "Discussões de família");
		Grupo G2 = new Grupo(2, "Faculdade", "Discussões acadêmicas");
		
		System.out.println("---GRUPOS---\n");
		
		System.out.println("Grupo " + G1.toString());
		System.out.println("Descrição: " + G1.getDescricao() + "\n");
		
		System.out.println("Grupo " + G2.toString());
		System.out.println("Descrição: " + G2.getDescricao() + "\n\n");
		
		Contato C1 = new Contato(1, "Mãe", "(18) 99739-4777", G1);
		Contato C2 = new Contato(2, "Kanegae", "(18) 99812-6532", G2);
		
		System.out.println("---CONTATOS---\n");
		
		System.out.println("Contato " + C1.toString());
		System.out.println("Telefone: " + C1.getTelefone());
		System.out.println("Grupo " + C1.getGrupo().toString() + "\n");
		
		System.out.println("Contato " + C2.toString());
		System.out.println("Telefone: " + C2.getTelefone());
		System.out.println("Grupo " + C2.getGrupo().toString());
		
		//Inserindo Grupo 1 - Statement
		//s.insertGrupoST(conexao, 4, "Teste2", "Testando function 2");
		
		//Inserindo Grupo 2 - PreparedStatement
		//s.insertGrupoPST(conexao, 3, "Teste", "Testando function");

		//Inserindo Contato
		//s.insertContato(conexao, 3, "Teste", "(18) 99814-7505", G2);
		
		//Atualizando Contato
		//s.updateContato(conexao, 3, "TesteUpdate", "(18) 99814-7505", G1);
		
		//Excluindo Contato
		s.deleteContato(conexao, 3);

	}
}
