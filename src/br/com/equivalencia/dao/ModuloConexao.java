package br.com.equivalencia.dao;
import java.sql.*;
/**
 *
 * @author aalmeida
 */
public class ModuloConexao {
    
    public static Connection conector(){
        
        java.sql.Connection conexao = null;
        
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3308/equivalencia1";
        String user = "root";
        String password = "";
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,user,password);
            return conexao;
        } catch (Exception e) {
            return null;
        }
        
    }
    
}
