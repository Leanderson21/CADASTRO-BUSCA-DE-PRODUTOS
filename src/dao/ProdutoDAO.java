
package dao;

import java.sql.Connection;
import model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

public class ProdutoDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rst;
    private Statement smt;
    
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
            stmt = conn.prepareStatement("UPDATE produto SET descricao = ?, preco = ? WHERE cod_produto = ? ");
            stmt.setString(1, produto.getDescricao());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getCod_produto());
            stmt.execute();
            stmt.close();
        }catch(Exception erro){
            throw new RuntimeException("erro: "+erro);
        }
    }
    
    public void excluir(int valor){
        try{
            smt = conn.createStatement();
            smt.execute("DELETE FROM produto WHERE cod_produto ="+valor);
            smt.close();
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