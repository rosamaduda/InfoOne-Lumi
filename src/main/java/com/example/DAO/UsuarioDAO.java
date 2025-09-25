package com.example.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class UsuarioDAO {

    // INSERIR
    public boolean inserirUsuario(String email, String cpf, String nome, String nome_sobrenome, Date data_nascimento, String senha, double altura, double peso) {
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
    } // inserirUsuario()

    // ALTERAR
    public int alterarCpfUsuario(String email, String cpf) {
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
    } // alterarCpfUsuario()

    public int alterarNomeUsuario(String email, String nome) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            String instrucaoSQL = "UPDATE usuario SET nome = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, nome);
            pstmt.setString(2, email);
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
    } // alterarNomeUsuario()

    public int alterarSobrenomeUsuario(String email, String sobrenome) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            String instrucaoSQL = "UPDATE usuario SET nome_sobrenome = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, sobrenome);
            pstmt.setString(2, email);
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
    } // alterarCpfUsuario()

    public int alterarDataNascimentoUsuario(String email, Date data_nascimento) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            String instrucaoSQL = "UPDATE usuario SET data_nascimento = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setDate(1, data_nascimento);
            pstmt.setString(2, email);
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
    } // alterarCpfUsuario()

    public int alterarSenhaUsuario(String email, String senha) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // fazendo a conexao com o BD

        try {
            String instrucaoSQL = "UPDATE usuario SET senha = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setString(1, senha);
            pstmt.setString(2, email);
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
    } // alterarSenhaUsuario()

    public int alterarAlturaUsuario(String email, double altura) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // conectando com o BD

        try {
            String instrucaoSQL = "UPDATE usuario SET altura = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setDouble(1, altura);
            pstmt.setString(2, email);
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
    } // alterarAlturaUsuario()

    public int alterarPesoUsuario(String email, double peso) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            String instrucaoSQL = "UPDATE usuario SET peso = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            pstmt.setDouble(1, peso);
            pstmt.setString(2, email);
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
    } // alterarPesoUsuario()

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
    } // deletarUsuario()

    // SELECT
    public List buscarUsuario() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset = null;
        List<Usuario> lista = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM usuario";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Usuario usuario = new Usuario(rset.getString("email"), rset.getString("cpf"), rset.getString("nome"), 
                                                rset.getString("nome_sobrenome"), rset.getDate("data_nascimento"), rset.getSenha("senha"), 
                                                rset.getDouble("altura"), rset.getDouble("peso"), rset.getString("endereco_rua"),
                                                rset.getString("endereco_uf"), rset.getString("endereco_cidade"), rset.getString("endereco_cep"),
                                                rset.getString("endereco_rua"), rset.getInt("endereco_numero"));
                lista.add(usuario);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conn.desconectar(conn); // desconectando o BD
            return lista;
        }
        
    } // buscarUsuario()
} // UsuarioDAO
