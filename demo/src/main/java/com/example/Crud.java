package com.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Crud {
    public boolean verificaAdmin(String login,String senha,String nome){
        Conexao conexao=new Conexao();
        Connection conn=null;
        try{
            conn=conexao.conectar();
            String sql="SELECT * FROM ADMINISTRADOR WHERE LOGIN=? AND SENHA=? AND USUARIO=?";
            PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setString(1,login);
            pstm.setString(2,senha);
            pstm.setString(3,nome);
            if(pstm.executeUpdate()==1){
                return true;
            }else{
                return false;
            }


        }catch(SQLException e){
            return false;

    }finally{
            conexao.desconecar(conn);
        }
    }  
}