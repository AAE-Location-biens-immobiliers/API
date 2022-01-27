package ca.uqac.BDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    /**
     * Permet de se connecter à la base de données.
     * @return conn
     */
    static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:BDD/BDD_sharaloc.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
