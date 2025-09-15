package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlergiaDAO {
    // INSERIR
    public boolean inserir(String alergeno, String nome, String descricao) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD

        try {
            String instrucaoSQL = "INSERT INTO alergia VALUES(?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando os parâmetros da instrução
            pstmt.setString(1, alergeno);
            pstmt.setString(2, nome);
            pstmt.setString(3, descricao);
            if (pstmt.executeUpdate() > 0) { // executando o comando
                return true;
            } else {
                return false;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        } finally {
            conexao.desconectar(conn); // fechando a conexão como BD
        }
    } // inserir
    
    // ALTERAR
    public int alterarAlergeno(int id, String alergeno) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexao com o BD

        try {
            String instrucaoSQL = "UPDATE alergia SET alergeno = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando parâmetro na instrução
            pstmt.setString(1, alergeno); 
            pstmt.setInt(2, id);

            if (pstmt.executeUpdate() > 0) {
                return 1; // encontrou o registro e alterou
            } else {
                return 0;  // o registro não foi encontrado
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar(conn);
        }
    } // alterarAlergeno()

    public int alterarNomeAlergia(int id, String nome) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexao com o BD

        try {
            String instrucaoSQL = "UPDATE alergia SET nome = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando parâmetro na instrução
            pstmt.setString(1, nome); 
            pstmt.setInt(2, id);

            if (pstmt.executeUpdate() > 0) {
                return 1; // encontrou o registro e alterou
            } else {
                return 0;  // o registro não foi encontrado
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar(conn);
        }
    } // alterarNomeAlergia()

    public int alterarDescricaoAlergia(int id, String descricao) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexao com o BD

        try {
            String instrucaoSQL = "UPDATE alergia SET descricao = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);

            // setando parâmetro na instrução
            pstmt.setString(1, descricao); 
            pstmt.setInt(2, id);

            if (pstmt.executeUpdate() > 0) {
                return 1; // encontrou o registro e alterou
            } else {
                return 0;  // o registro não foi encontrado
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar(conn);
        }
    } // alterarDescricao()

    // DELETAR
    public int removerAlergia(int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexao com o BD

        try {
            String instrucaoSQL = "DELETE FROM alergia WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setInt(1, id); // setando parametro na instrução
            if (pstmt.executeUpdate() > 0) { // executando o comando SQL
                return 1; // conseguiu deletar
            } else {
                return 0; // não encontrou o registro
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn);
        }
    } // removerAlergia()
}
