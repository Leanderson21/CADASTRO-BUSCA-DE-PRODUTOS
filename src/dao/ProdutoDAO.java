
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
    private Statement stm;
    private ResultSet rst;
    private ArrayList<Produto> lista = new ArrayList<>();
    
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
            throw new RuntimeException("erro 1"+erro);
        }
    }
        
        public void alterar(Produto produto){
            try{
                stmt = conn.prepareStatement("UPDATE produto SET descricao =? , preco = ? WHERE cod_produto = ?");
                stmt.setString(1, produto.getDescricao());
                stmt.setDouble(2, produto.getPreco());
                stmt.setInt(3, produto.getCod_produto());
                stmt.execute();
                stmt.close();
            }catch(Exception erro){
                throw new RuntimeException("erro 2:"+erro);
            }
        }
        
        public void deletar(int valor){
            try{
                stm = conn.createStatement();
                stm.execute("DELETE FROM produto WHERE cod_produto="+valor);
                stm.close();
            }catch(Exception erro){
                throw new RuntimeException("erro 3:"+erro);
            }
        }
        
        public ArrayList<Produto> listarTodos(){
                String sql = "SELECT * FROM produto";
            try{
                stm = conn.createStatement();
                rst = stm.executeQuery(sql);
                           while(rst.next()){
                           Produto produto = new Produto();
                            produto.setCod_produto(rst.getInt("cod_produto"));
                            produto.setDescricao(rst.getString("descricao"));
                            produto.setPreco(rst.getDouble("preco"));
                            lista.add(produto);
                    }
            }catch(Exception erro){
                throw new RuntimeException("erro 4:"+erro);
            }
            return lista;
        }
        
    }
    





