package ca.uqac.BDD;

import java.sql.*;

public class bdd_avis {

    public static void afficher_table() throws SQLException {
        Connection conn = Connect.connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type='table'");
        System.out.println("Tables in the current database: ");
        while (rs.next()) {
            System.out.print(rs.getString(1));
            System.out.println();
        }
    }

    public static void main(String[] args) throws SQLException {
        bdd_avis test = new bdd_avis();
        test.afficher_table();
    }
}
