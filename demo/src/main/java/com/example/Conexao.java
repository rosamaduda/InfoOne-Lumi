package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class Conexao {
    Dotenv dotenv = Dotenv.load();
    public Connection conectar(){
        Connection conn=null;
        try{
            Class.forName("org.postgresql.Driver");
            String usuario=dotenv.get("USUARIO");
            String senha=dotenv.get("SENHA");
            String url=dotenv.get("URL");
            conn= DriverManager.getConnection(url,usuario,senha);
            System.out.println("Conexão estabelecida com sucesso!");
    }catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }catch (ClassNotFoundException f) {
            System.out.println("Driver JDBC não encontrado: " + f.getMessage());
        }finally{return conn;}
    }



    public void desconecar(Connection conn){
        try{
            if(conn!=null && !conn.isClosed()){
                conn.close();
            }
        }catch (SQLException e) {
            e.getMessage();
        }
    }
    
}
