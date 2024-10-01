package taf1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import connexion.Connexion;
import entities.DevData;
import static exojdbc.ExoJDBC.*;

public class TAF1 {

    public static void create() {
        Statement st = null;
        try {
            st = Connexion.getCn().createStatement();
            String req = " CREATE TABLE DevData ("
                    + "Developpeurs VARCHAR(32), "
                    + "Jour CHAR(11), "
                    + "NbScripts INTEGER)";
            st.executeUpdate(req);
        } catch (SQLException e) {
            System.out.println("Erreur SQL");
        } finally {
            try {
                st.close();
            } catch (SQLException ex) {
                System.out.println("Impossible de libérer les ressources");
            }
        }
    }

    public static void insert(DevData d) {
        Statement st = null;
        try {
            st = Connexion.getCn().createStatement();
            String req = "INSERT INTO DevData VALUES ('" + d.getDev() + "', '" + d.getJour() + "', " + d.getNbScripts() + ")";
            st.executeUpdate(req);
        } catch (SQLException e) {
            System.out.println("Erreur SQL");
        } finally {
            try {
                st.close();
            } catch (SQLException ex) {
                System.out.println("Impossible de libérer les ressources");
            }
        }
    }

    public static void main(String[] args) {
        requeteLibre();
    }

}
