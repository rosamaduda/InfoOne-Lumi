

public class IndustriaDAO {
    // INSERIR
    public boolean inserirIndustria(String cnpj, String nome, String objetivo, String email) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // onectando o BD

        try {
            String instrucaoSQL = "INSERT INTO usuario VALUES(?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, cnpj);
            pstmt.setString(2, nome);
            pstmt.setString(3, objetivo);
            pstmt.setString(4, email);
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
    } // inserirIndustria()

    // ALTERAR
    public int alterarCnpjIndustria(int id, String cnpj) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexao com o BD
    
        try {
            String instrucaoSQL = "UPDATE industria SET cnpj = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, cnpj);
            pstmt.setInt(2, id);
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
    } // alterarCnpjIndustria()

    public int alterarNomeIndustria(int id, String nome) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // conectando o BD

        try {
            String instrucaoSQL = "UPDATE industria SET nome = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, nome);
            pstmt.setInt(2, id);
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
    } // alterarNomeIndustria()    


    public int alterarObjetivoIndustria(int id, String objetivo) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // conectando o BD

        try {
            String instrucaoSQL = "UPDATE industria SET objetivo = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, objetivo);
            pstmt.setInt(2, id);
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
    } // alterarDescricaoIndustria()    
    
    
    public int alterarEmailIndustria(int id, String email) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexao com o BD

        try {
            String instrucaoSQL = "UPDATE industria SET email = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando parâmetros da instrução
            pstmt.setString(1, email);
            pstmt.setInt(2, id);
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
    } // alterarEmailIndustria()   

    // DELETAR
    public int deletarIndustria(int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexao com o BD

        try {
            String instrucaoSQL = "DELETE FROM industria WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(instrucaoSQL);
            // setando os parâmetros
            pstmt.setInt(1, id);
            if (pstmt.executeUpdate() > 0) { // executando a instrução
                return 1; // alteração ocorreu com sucesso
            } else {
                return 0; // o registro não existe
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1; // caiu no catch
        } finally {
            conexao.desconectar(conn);
        }
    }

    // SELECIONAR
    public List buscarIndustria() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar(); // abrindo a conexão com o BD
        ResultSet rset = null;
        List<Alergia> lista = new ArrayList<>(); 

        try {
            String instrucaoSQL = "SELECT * FROM industria";
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery(instrucaoSQL); // executando a query

            while (rset.next()) {
                Industria industria = new Industria(rset.getInt("id"), rset.getString("cnpj"), rset.getString("objetivo"), rset.getString("email"));
                
            }
        }
    }
} // IndustriaDAO