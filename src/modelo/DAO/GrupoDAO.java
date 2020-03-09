package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import modelo.ConnectionFactory;
import modelo.Grupo;

public class GrupoDAO {
	
    public static void inserir(Grupo grupo){
        try{
            Connection conexao = ConnectionFactory.getConnection();
            String sql = "INSERT INTO grupo (codigo, nome, descricao) VALUES (" + grupo.getCodigo() + ", '" + grupo.getNome() + "', '" + grupo.getDescricao() + "')";
            Statement stmt = conexao.createStatement();
            stmt.execute(sql);
            stmt.close();
            conexao.close();
        }catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }

    }

    public static void atualizar(Grupo grupo){
        try{
            Connection conexao = ConnectionFactory.getConnection();
            String sql = "UPDATE grupo SET codigo = ?, nome = ?, descricao = ? WHERE codigo = ?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, grupo.getCodigo());
            pstm.setString(2, grupo.getNome());
            pstm.setString(3, grupo.getDescricao());
            pstm.setInt(4, grupo.getCodigo());
            pstm.execute();
            pstm.close();
            conexao.close();
        }catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static Grupo pesquisarPorCodigo(int codigo){
        Grupo grupoRetorno = null;
        try{
            Connection conexao = ConnectionFactory.getConnection();
            String sql = "SELECT codigo, nome, descricao FROM grupo WHERE codigo = ?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, codigo);
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
        return grupoRetorno;
    }
}