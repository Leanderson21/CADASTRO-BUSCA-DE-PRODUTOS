
package table;
import model.Produto;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;


public class ProdutoTableModel extends AbstractTableModel {

    public static final int COL_COD_PRODUTO = 0;
    public static final int COL_DESCRICAO = 1;
    public static final int COL_PRECO = 2;
    public ArrayList<Produto> lista;
    
    
    public ProdutoTableModel(ArrayList<Produto> l){
        lista = new ArrayList<Produto>(l);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int linhas, int colunas) {
        Produto produto = lista.get(linhas);
        if (colunas == COL_COD_PRODUTO) return produto.getCod_produto();
        if (colunas == COL_DESCRICAO) return produto.getDescricao();
        if (colunas == COL_PRECO) return produto.getPreco();
        return "";
        
    }
    
    @Override
        public String getColumnName(int colunas){
        if (colunas == COL_COD_PRODUTO) return "código";
        if (colunas == COL_DESCRICAO) return "descricao";
        if (colunas == COL_PRECO) return "preco";
        return "";
        }
    
}
