package ma.projet.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.classes.Categorie;
import ma.projet.classes.Commande;
import ma.projet.classes.CommandeProduitPK;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.classes.Produit;
import ma.projet.service.CategorieService;
import ma.projet.service.CommandeService;
import ma.projet.service.LigneCommandeProduitService;
import ma.projet.service.ProduitService;

public class Test {

    public static void main(String[] args) {
        CategorieService cats = new CategorieService();
        ProduitService ps = new ProduitService();
        CommandeService cs = new CommandeService();
        LigneCommandeProduitService lcps = new LigneCommandeProduitService();

//        cats.create(new Categorie("CAT1", "Électronique"));
//        cats.create(new Categorie("CAT2", "Vêtements"));
//        ps.create(new Produit("PROD1", 1000, cats.findById(1)));
//        ps.create(new Produit("PROD2", 500, cats.findById(1)));
//        ps.create(new Produit("PROD3", 200, cats.findById(2)));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            cs.create(new Commande(sdf.parse("2024-04-03")));
//            cs.create(new Commande(sdf.parse("2024-05-06")));
//            cs.create(new Commande(sdf.parse("2024-06-23")));
//        } catch (ParseException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        LigneCommandeProduit lcp = new LigneCommandeProduit(cs.findById(7), ps.findById(4), 20);
//        lcp.setPk(new CommandeProduitPK(7, 4));
//        lcps.create(lcp);
//        LigneCommandeProduit lcp2 = new LigneCommandeProduit(cs.findById(8), ps.findById(5), 10);
//        lcp2.setPk(new CommandeProduitPK(8, 5));
//        lcps.create(lcp2);
//
//        LigneCommandeProduit lcp3 = new LigneCommandeProduit(cs.findById(9), ps.findById(6), 300);
//        lcp3.setPk(new CommandeProduitPK(9, 6));
//        lcps.create(lcp3);

        // Question 3: Afficher la liste des produits par catégorie
//        System.out.println("Test 3: Liste des produits par catégorie");
//        List<Categorie> categories = cats.findAll();
//        for (Categorie categorie : categories) {
//            System.out.println("Catégorie: " + categorie.getLibelle());
//            List<Produit> produits = ps.findByCategorie(categorie);
//            for (Produit produit : produits) {
//                System.out.println(" - " + produit.getReference() + ": " + produit.getPrix() + " DH");
//            }
//        }
        // Question 4: Afficher la liste des produits commandés entre deux dates
//        Scanner scanner = new Scanner(System.in);
//        try {
//            System.out.print("Entrez la date de début (format YYYY-MM-DD): ");
//            Date start = sdf.parse(scanner.nextLine());
//            System.out.print("Entrez la date de fin (format YYYY-MM-DD): ");
//            Date end = sdf.parse(scanner.nextLine());
//            List<Produit> produitsDate = ps.findByDate(start, end);
//            System.out.println("Produits commandés entre " + sdf.format(start) + " et " + sdf.format(end) + ":");
//            for (Produit p : produitsDate) {
//                System.out.println(p.getReference() + " - Prix: " + p.getPrix());
//            }
//        } catch (ParseException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }

        // Question 5: Afficher les produits commandés dans une commande donnée
//        System.out.println("\nTest 5: Produits commandés dans une commande donnée");
//        System.out.print("Entrez l'ID de la commande: ");
//        int commandeId = scanner.nextInt();
//        cs.afficherProduitsCommande(commandeId);
//        scanner.close();

        // Question 6: Afficher la liste des produits dont le prix est supérieur à 100 DH
        System.out.println("\nTest 6: Liste des produits dont le prix est supérieur à 100 DH");
        List<Produit> produits = ps.produitsPrixSuperieur(100);
        for (Produit p : produits) {
            System.out.println(p.getReference() + " - Prix: " + p.getPrix() + " DH");
        }

    }
}
