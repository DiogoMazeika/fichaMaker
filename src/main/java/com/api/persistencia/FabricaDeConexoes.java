package com.api.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Classe é responsável pela
// conexão com o banco de dados
class FabricaDeConexoes {

    private final static String URL = "jdbc:sqlite://localhost:3306/rpg";
    private final static String user = "root";
    private final static String senha = "univille";

    // Design Pattern: Method Factory, Fábrica por método
    public static Connection get() throws SQLException {
        return DriverManager.getConnection(URL, user, senha);
    }

}
