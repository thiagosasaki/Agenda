package modelo.DAO;

import modelo.Contato;
import modelo.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ContatoDAO {
    public static void inserir(Contato contato){
        try{
            Connection conexao = ConnectionFactory.getConnection();
            String sql = "INSERT INTO contato(codigo, nome, telefone, grupo_codigo) VALUES (?, ?, ?, ?)";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, contato.getCodigo());
            pstm.setString(2, contato.getNome());
            pstm.setString(3, contato.getTelefone());
            pstm.setInt(4, contato.getGrupo().getCodigo());
            pstm.execute();
            pstm.close();
            conexao.close();
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void excluir(Contato contato){
        try {
            Connection conexao = ConnectionFactory.getConnection();
            String sql = "DELETE FROM contato WHERE codigo = ?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, contato.getCodigo());
            pstm.execute();
            pstm.close();
            conexao.close();
        }catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static Contato pesquisarPorCodigo(int codigo){
        Contato contatoRetorno = null;
        try{
            Connection conexao = ConnectionFactory.getConnection();
            String sql = "SELECT codigo, nome, telefone, codigo_grupo FROM contato WHERE codigo = ?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                contatoRetorno = new Contato(rs.getInt(1), rs.getString(2), rs.getString(3), GrupoDAO.pesquisarPorCodigo(rs.getInt(4)));
            }

        }catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
        return contatoRetorno;
    }

}