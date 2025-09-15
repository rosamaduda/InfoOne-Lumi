package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IngredienteDAO {
    // INSERIR
    public boolean inserir(String descricao) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "INSERT INTO ingrediente (descricao) VALUES (?)";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando parâmetros na instrução
            pstmt.setString(1, descricao);

            if (pstmt.executeUpdate() > 0) { // executando o comando e verificando o retorno
                return true;
            } else {
                return false;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        } finally {
            conexao.desconectar(conn); // desconectando o BD
        }
    } // inserir()

    // ALTERAR
    public int alterarDescricaoIngrediente(int idString descricao) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "UPDATE ingrediente SET descricao = ? WHERE "
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        }
    }

    // DELETAR
    public int removerIngrediente(int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "DELETE FROM ingrediente WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1, id); // setando o parâmetro da instrução
            if (pstmt.executeUpdate() > 0) { // executando o comando e verificando o retorno
                return 1; // conseguiu executar a instrução
            } else {
                return 0; // não encontrou o registro
            }
        } catch (SQLException sqle) { 
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn);
        }
    }
}
