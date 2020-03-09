package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Scripts {
	
	public void selectGrupo(Connection conexao, Grupo grupo) {
		Grupo grupoRetorno = null;
		try{
			String sql = "SELECT codigo, nome, descricao FROM grupo WHERE codigo = ?";
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, grupo.getCodigo());
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				grupoRetorno = new Grupo(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			System.out.println("Grupo " + grupoRetorno);
			rs.close();
			pstm.close();
			conexao.close();
		}catch (Exception e){
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void selectGrupos (Connection conexao){
		List<Grupo>	grupos = new ArrayList<Grupo>();
		try {
			String sql = "SELECT codigo, nome, descricao FROM grupo";
			PreparedStatement pstm = conexao.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Grupo grupo = new Grupo(rs.getInt(1), rs.getString(2), rs.getString(3));
				grupos.add(grupo);
			}
			rs.close();
			pstm.close();
			conexao.close();
		}catch (Exception e){
			System.out.println("Erro: " + e.getMessage());
		}
		
		System.out.println("--- LISTA DE GRUPOS ---\n");
		for(Grupo grupo : grupos) { //opção 1 
			System.out.println("Grupo " + grupo);
		}
		
		/*for(int i = 0; i < grupos.size(); i++){ //opção 2
			Grupo grupo = grupos.get(i);
			System.out.println("Grupo " + grupo);
		}*/
	}
	
	public void insertGrupoST(Connection conexao, int codigo, String nome, String descricao) {
		try {
			String sql = "INSERT INTO grupo(codigo, nome, descricao) " +
						"VALUES(" + codigo + ",'" + nome + "','" + descricao + "')";
			Statement stmt = conexao.createStatement();
			stmt.execute(sql);
			stmt.close();
			conexao.close();
			System.out.println("Dados inseridos!\n");
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		}
	}
	
	public void insertGrupoPST(Connection conexao, int codigo, String nome, String descricao) {
		try {
			String sql = "INSERT INTO grupo(codigo, nome, descricao) VALUES(?, ?, ?)";
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, codigo);
			pstm.setString(2, nome);
			pstm.setString(3, descricao);
			pstm.execute();
			pstm.close();
			conexao.close();
			System.out.println("Grupo inserido com sucesso!\n");
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		}
	}
	
	public void updateGrupo(Connection conexao, int codigo, String newNome, String newDescricao) {
		try {
			String sql = "UPDATE grupo set nome = ?, descricao = ?";
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, newNome);
			pstm.setString(2, newDescricao);
			pstm.execute();
			pstm.close();
			conexao.close();
			System.out.println("Grupo atualizado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		}
	}
	
	public void deleteGrupo(Connection conexao, int codigo) {
		try {
			String sql = "DELETE FROM grupo WHERE codigo = ?";
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, codigo);
			pstm.execute();
			pstm.close();
			conexao.close();
			System.out.println("Grupo excluído com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		}
	}
	
	public void insertContato(Connection conexao, int codigo, String nome, String telefone, Grupo grupo) {
		try {
			String sql = "INSERT INTO contato(codigo, nome, telefone, grupo_codigo) VALUES(?, ?, ?, ?)";
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, codigo);
			pstm.setString(2, nome);
			pstm.setString(3, telefone);
			pstm.setInt(4, grupo.getCodigo());
			pstm.execute();
			pstm.close();
			conexao.close();
			System.out.println("Contato inserido com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		}
	}
	
	public void updateContato(Connection conexao, int Codigo, String newNome, String newTelefone, Grupo newGrupo) {
		try {
			String sql = "UPDATE contato set nome = ?, telefone = ?, grupo = ?";
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, newNome);
			pstm.setString(2, newTelefone);
			pstm.setInt(3, newGrupo.getCodigo());
			pstm.execute();
			pstm.close();
			conexao.close();
			System.out.println("Contato atualizado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		}
	}
	
	public void deleteContato(Connection conexao, int codigo) {
		try {
			String sql = "DELETE FROM contato WHERE codigo = ?";
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, codigo);
			pstm.execute();
			pstm.close();
			conexao.close();
			System.out.println("Contato excluído com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		}
	}

}
