package aplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.Properties;

public class DB {

    private static Connection conexao;

    public static Properties getPropriedades() throws IOException {
        Properties propriedades = new Properties();
        FileInputStream arquivo = new FileInputStream("./db.properties");
        propriedades.load(arquivo);
        return propriedades;
    }

    public static Connection getConexao() throws SQLException {
        if (conexao == null) {
            try {
                Properties p = DB.getPropriedades();
                conexao = DriverManager.getConnection(p.getProperty("host"), p.getProperty("user"), p.getProperty("password"));
            } catch (IOException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }
        return conexao;
    }

    public static void closeConnection() {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar o Statement: " + e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar o ResultSet: " + e.getMessage());
            }
        }
    }
}