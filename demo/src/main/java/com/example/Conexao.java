package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class Conexao {
    Dotenv dotenv = Dotenv.load(); // carregando as informações do .env

    public Connection conectar(){
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            String usuario = dotenv.get("DB_USER");
            String senha = dotenv.get("DB_PASSWORD");
            String url = dotenv.get("DB_URL");
            conn = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida com sucesso!");
        }catch (SQLException sqle) {
            System.out.println("Erro ao conectar ao banco de dados: " + sqle.getMessage());
        }catch (ClassNotFoundException cnfe) {
            System.out.println("Driver JDBC não encontrado: " + cnfe.getMessage());
        }finally{return conn;}
    }

    public void desconectar(Connection conn){
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
}
