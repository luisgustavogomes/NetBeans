package crud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BancoDados {

    public static Statement criarStatament() throws SQLException {
        String connString = null;
        try {
            connString = GerenciadorArquivo.lerArquivoClass();
        } catch (IOException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection conn = DriverManager.getConnection(connString);
        Statement st = conn.createStatement();
        return st;
    }

    public static boolean executarComando(String sql) {
        try {
            Statement st = criarStatament();
            return st.execute(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    public static ResultSet executarConsulta(String sql) {
        try {
            Statement st = criarStatament();
            return st.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

}
