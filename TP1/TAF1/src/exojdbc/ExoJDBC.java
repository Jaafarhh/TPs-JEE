package exojdbc;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExoJDBC {

    public static void requeteLibre() {
        Statement st = null;
        try {
            st = Connexion.getCn().createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez votre requête SQL : ");
        String query = scanner.nextLine();

        ResultSet rs = null;

        try {
            rs = st.executeQuery(query);

            ResultSetMetaData rsMetaData = rs.getMetaData();
            int columnCount = rsMetaData.getColumnCount();
            System.out.println("Nombre de colonnes : " + columnCount);

            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Colonne " + i + " : " + rsMetaData.getColumnName(i)
                        + " (Type : " + rsMetaData.getColumnTypeName(i) + ")");
            }
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de l'exécution de la requête : " + e.getMessage());
        }

    }

    public static void dailyMaxScript() {
        try {
            Statement st = Connexion.getCn().createStatement();
            String req = "SELECT Developpeurs, jour, max(NbScripts)"
                    + "from DevData"
                    + " group by jour";

            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                System.out.println(rs.getString("Developpeurs") + " a réalisé le maximum de scripts le " + rs.getString("Jour") + " avec " + rs.getInt("max(NbScripts)") + " scripts.");
            }

        } catch (Exception e) {
            System.out.println("Erreur lors de recherche " + e.getMessage());
        }
    }

    public static void descendingScripts() {

        try {
            Statement st = Connexion.getCn().createStatement();
            String req = "SELECT Developpeurs, SUM(NbScripts) AS c  "
                    + "FROM DevData "
                    + "GROUP BY Developpeurs "
                    + "ORDER BY c DESC";

            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {

                System.out.println(rs.getString("Developpeurs") + " a réalisé " + rs.getInt("c") + " scripts au total");

            }
        } catch (Exception e) {
            System.out.println("Erreur lors du tri: " + e.getMessage());
        }

    }

    public static void weeklyTotalScripts() {
        try {
            Statement st = Connexion.getCn().createStatement();
            String req = "SELECT SUM(NbScripts) AS ts "
                    + "FROM DevData";
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {

                System.out.println("Le nombre total de scripts réalisés en une semaine est : " + rs.getInt("ts"));
            }

        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    public static void totalScripts() {
        try {
            Statement st = Connexion.getCn().createStatement();
            String req = "SELECT Developpeurs, SUM(NbScripts) AS ts "
                    + "FROM DevData "
                    + "GROUP BY Developpeurs "
                    + "ORDER BY ts DESC";

            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                System.out.println(rs.getString("Developpeurs") + " a réalisé " + rs.getInt("ts") + " scripts au total.");
            }
        } catch (Exception e) {
            System.out.println("Erreur lors du tri: " + e.getMessage());
        }
    }

}
