
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    
    private String db;
    private String user;
    private String password;
    private String host;
    
    public ConnectionFactory(){
        this.db = "mercado";
        this.host = "localhost";
        this.user = "root";
        this.password = "";
    }
    
    public Connection getConexao(){
        try{
            return DriverManager.getConnection("jdbc:mysql://"+this.host+"/"+this.db, this.user, this.password);
        }catch(Exception erro){
            throw new RuntimeException("erro: "+erro);
        }
    }
        
    
    
}


