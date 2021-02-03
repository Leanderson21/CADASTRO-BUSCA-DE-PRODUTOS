
package dao;

import java.sql.Connection;
import model.Produto;
import java.sql.PreparedStatement;

public class ProdutoDAO {
    private Connection conn;
    private PreparedStatement stmt;
    
    
    public ProdutoDAO(){
        conn = new ConnectionFactory().getConexao();
    }
    
    public void inserir(Produto produto){
        try{
            stmt = conn.prepareStatement("INSERT INTO produto(descricao,preco) VALUES(?,?)");
            stmt.setString(1, produto.getDescricao());
            stmt.setDouble(2, produto.getPreco());
            stmt.execute();
            stmt.close();
        }catch(Exception erro){
            throw new RuntimeException("erro: "+erro);
        }
    }
    
    
    public void alterar(Produto produto){
        try{
            
        }catch(Exception erro){
            throw new RuntimeException("erro: "+erro);
        }
    }
    
    
}



/*
package dao;

import java.sql.Connection;
import model.Produto;
import java.sql.PreparedStatement;

public class ProdutoDAO {
    
    private Connection conn;
    private PreparedStatement stmt;
    
    
    public ProdutoDAO(){
        conn = new ConnectionFactory().getConexao();
    }
    
    public void inserir(Produto produto){
        try{
            stmt = conn.prepareStatement("INSERT INTO produto(descricao,preco) VALUES(?,?)");
            stmt.setString(1, produto.getDescricao() );
            stmt.setDouble(2, produto.getPreco());
            stmt.execute();
            stmt.close();
            
        }catch(Exception erro){
            throw new RuntimeException("erro: "+erro);
            }
    }
} */