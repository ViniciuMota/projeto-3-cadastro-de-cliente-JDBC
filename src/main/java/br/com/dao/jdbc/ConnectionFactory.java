package main.java.br.com.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection connection;

    private ConnectionFactory() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null && !connection.isClosed()) {
            connection = initConnection();
        }
        return connection;
    }

    private static Connection initConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:15432/vendas", "postgres", "Admin");
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao obter a conexão com o banco de dados", e);
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao fechar a conexão com o banco de dados", e);
        }
    }
}