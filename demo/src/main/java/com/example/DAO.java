package com.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
    // public boolean verificaAdmin(String login, String senha, String nome){
    //     Conexao conexao = new Conexao();
    //     Connection conn = conexao.conectar(); // abrindo a conexão com o banco de dados

    //     try {
    //         String sql = "SELECT * FROM ADMINISTRADOR WHERE LOGIN = ? AND SENHA = ? AND USUARIO = ?";
    //         PreparedStatement pstm = conn.prepareStatement(sql);

    //         // passando os parâmetros para substituir na instrução
    //         pstm.setString(1, login);
    //         pstm.setString(2, senha);
    //         pstm.setString(3, nome);

    //         if(pstm.executeQuery()){ // executando a instrução SQL e verificando se teve alguma alteração
    //             return true;
    //         } else{
    //             return false;
    //         }

    //     } catch(SQLException sqle) {
    //         sqle.printStackTrace();
    //         return false;

    //     } finally {
    //         conexao.desconectar(conn); // fechando a conexão com o BD
    //     }
    // } // verificaAdmin()  

    public boolean verificaAdm(String usuario, String senha) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco de dados
        ResultSet rset = null;

        try {
            String instrucaoQuery = "SELECT * FROM ADMINISTRADOR WHERE USUARIO = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoQuery); 
            pstmt.setString(1, usuario); // setando o parâmetro na instrução
            rset = pstmt.executeQuery(); // executando a query no BD

            // caso seja encontrado um usuário com o nome fornecido, cai no while
            while (rset.next()) { 
                if (rset.getString("senha") == senha) { // verificando se a senha do usuario recebido é igual a senha recebida
                    return true;
                }
            }
        } catch(SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);
            return false;
        }
    } // verificaAdm()

    public ResultSet buscarAdm() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco
        ResultSet rset = null;

        try {
            String instrucao = "SELECT * FROM ADMINISTRADOR";
            PreparedStatement pstmt = conn.prepareStatement(instrucao);
            rset = pstmt.executeQuery();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);
            return rset;
        }  
    } // buscarAdm()
} // DAO