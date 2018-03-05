package crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControladorProduto {

    public static boolean salvarProduto(String nome, double preco, Date data) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-m-dd");
        String dataStr = format.format(data);
        String precoStr = (preco + "").replace(",", ".");
        String sql = String.format("INSERT INTO Produto(Name,preco,data) VALUES ('%s',%s,'%s')", nome, precoStr, dataStr);
        return BancoDados.executarComando(sql);
    }
    
    public static boolean excluirProduto(int id){
        String sql = String.format("DELETE FROM PRODUTO WHERE ID=%d",id);
        return BancoDados.executarComando(sql);
    }

    public static boolean editarProduto(int id, String nome, double preco, Date data) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-m-dd");
        String dataStr = format.format(data);
        String precoStr = (preco + "").replace(",", ".");
        String sql = String.format("UPDATE PRODUTO SET NAME='%s',PRECO=%s,DATA='%s' WHERE ID=%d", nome, precoStr, dataStr, id);
        return BancoDados.executarComando(sql);
    }

    public static List<Produto> retornarProdutos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        ResultSet rs = BancoDados.executarConsulta("SELECT * FROM PRODUTO");
        while (rs.next()) {
            Produto produto = new Produto(rs.getInt("ID"),
                    rs.getString("NAME"),
                    rs.getDouble("PRECO"),
                    rs.getDate("DATA"));
            produtos.add(produto);
        }
        if (produtos.isEmpty()) {
            return null;
        } else {
            return produtos;
        }
    }
    
}
