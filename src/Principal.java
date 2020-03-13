import modelo.Contato;
import modelo.Grupo;
import modelo.Scripts;
import modelo.DAO.GrupoDAO;
import modelo.DAO.ContatoDAO;

import java.sql.Connection;
import java.util.List;

import modelo.ConnectionFactory;

public class Principal {
	public static void main(String[] args) {
		Connection conexao = ConnectionFactory.getConnection();
		Scripts s = new Scripts();
		
		Grupo G1 = new Grupo(1, "Família", "Discussões de família");
		Grupo G2 = new Grupo(2, "Faculdade", "Discussões acadêmicas");
		
		Contato C1 = new Contato(1, "Mãe", "(18) 99739-4777", G1);
		Contato C2 = new Contato(2, "Kanegae", "(18) 99812-6532", G2);
		
		GrupoDAO.inserir2(G2);

		List<Grupo> grupos = GrupoDAO.pesquisarTodos();

		s.selectGrupos(conexao);
		GrupoDAO.inserir(G1);
		GrupoDAO.atualizar(G1);
		GrupoDAO.pesquisarPorCodigo(G1.getCodigo());

	}
}
