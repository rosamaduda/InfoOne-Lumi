package com.example.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    // INSERIR
    public boolean inserir(String email, String cpf, String nome, String nome_sobrenome, Date data_nascimento, String senha, double altura, double peso) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o banco de dados
    
        try {
            String instrucaoSQL = "INSERT INTO usuario VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, email);
            pstmt.setString(2, cpf);
            pstmt.setString(3, nome);
            pstmt.setString(4, nome_sobrenome);
            pstmt.setDate(5, data_nascimento);
            pstmt.setDouble(6, altura);
            pstmt.setDouble(7, peso);
            pstmt.setString(8, email);
            if (pstmt.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        } finally {
            conexao.desconectar(conn);
        }
    } // inserir()

    // ALTERAR
    public int alterarCpf(String email, String cpf) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            String instrucaoSQL = "UPDATE usuario SET cpf = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, email);
            pstmt.setString(2, cpf);
            if (pstmt.executeUpdate() > 0) {
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // algum outro problema aconteceu
        } finally {
            conexao.desconectar(conn); // desconecta do BD
        }
    } // alterarCpf()

    public int alterarNome(String email, String nome) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            String instrucaoSQL = "UPDATE usuario SET nome = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, email);
            pstmt.setString(2, nome);
            if (pstmt.executeUpdate() > 0) {
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // algum outro problema aconteceu
        } finally {
            conexao.desconectar(conn); // desconecta do BD
        }
    } // alterarNome()

    public int alterarSobrenome(String email, String sobrenome) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            String instrucaoSQL = "UPDATE usuario SET nome_sobrenome = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, email);
            pstmt.setString(2, sobrenome);
            if (pstmt.executeUpdate() > 0) {
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // algum outro problema aconteceu
        } finally {
            conexao.desconectar(conn); // desconecta do BD
        }
    } // alterarCpf()

    public int alterarDataNascimento(String email, Date data_nascimento) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            String instrucaoSQL = "UPDATE usuario SET data_nascimento = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, email);
            pstmt.setDate(2, data_nascimento);
            if (pstmt.executeUpdate() > 0) {
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // algum outro problema aconteceu
        } finally {
            conexao.desconectar(conn); // desconecta do BD
        }
    } // alterarCpf()

    public int alterarSenha(String email, String senha) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // fazendo a conexao com o BD

        try {
            String instrucaoSQL = "UPDATE usuario SET senha = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, email);
            pstmt.setString(2, senha);
            if (pstmt.executeUpdate() > 0) {
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // algum outro problema aconteceu
        } finally {
            conexao.desconectar(conn); // desconecta do BD
        }
    } // alterarSenha()

    public int alterarAltura(String email, double altura) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // conectando com o BD

        try {
            String instrucaoSQL = "UPDATE usuario SET altura = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, email);
            pstmt.setDouble(2, altura);
            if (pstmt.executeUpdate() > 0) {
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // algum outro problema aconteceu
        } finally {
            conexao.desconectar(conn); // desconecta do BD
        }
    } // alterarAltura()

    public int alterarPeso(String email, double peso) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            String instrucaoSQL = "UPDATE usuario SET peso = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, email);
            pstmt.setDouble(2, peso);
            if (pstmt.executeUpdate() > 0) {
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // algum outro problema aconteceu
        } finally {
            conexao.desconectar(conn); // desconecta do BD
        }
    } // alterarPeso()

    // DELETE
    public boolean deletarUsuario(String email) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // conectando com o BD

        try {
            String instrucaoSQL = "DELETE FROM usuario WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, email);// setando parâmetro da instrução
            if (pstmt.executeUpdate() > 0){
                return true;
            } else {
                return false;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        } finally {
            conexao.desconectar(conn);
        }
    }
} // UsuarioDAO
