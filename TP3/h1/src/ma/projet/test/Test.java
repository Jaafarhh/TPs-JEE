package ma.projet.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {

    public static void main(String[] args) {
        ProduitService produitService = new ProduitService();

        // Créer cinq produits
//        produitService.create(new Produit("Dell", "REF001", new Date(2024 - 1900, 01, 01), 150.0, "Laptop"));
//        produitService.create(new Produit("HP", "REF002", new Date(2024 - 1900, 02, 15), 200.0, "Desktop"));
//        produitService.create(new Produit("Apple", "REF003", new Date(2024 - 1900, 03, 10), 300.0, "Tablet"));
//        produitService.create(new Produit("Samsung", "REF004", new Date(2024 - 1900, 04, 12), 250.0, "Phone"));
//        produitService.create(new Produit("Asus", "REF005", new Date(2024 - 1900, 05, 05), 100.0, "Monitor"));

            // Afficher tous les produits
//        List<Produit> produits = produitService.findAll();
//        for (Produit p : produits) {
//            System.out.println(p.toString());
//        }
//
//        // Afficher les informations du produit dont l'id est 2
//        Produit produit = produitService.findById(2);
//        System.out.println(produit.toString());
//
//        // Supprimer le produit dont l'id est 3
//        produitService.delete(produitService.findById(3));
//
//        // Modifier les informations du produit dont l'id est 1
//        Produit p1 = produitService.findById(1);
//        p1.setPrix(175.0);
//        produitService.update(p1);
//
////        Afficher les produits avec un prix supérieur à 100 DH
//        for (Produit p : produitService.findAll()) {
//            if (p.getPrix() > 100) {
//                System.out.println(p.toString());
//            }
//        }
//
        // Afficher les produits commandés entre deux dates
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Entrez la date de début (format YYYY-MM-DD): ");
            Date start = sdf.parse(scanner.nextLine());
            System.out.print("Entrez la date de fin (format YYYY-MM-DD): ");
            Date end = sdf.parse(scanner.nextLine());
            List<Produit> produitsDate = produitService.findByDate(start, end);
            System.out.println("Produits commandés entre " + start + " et " + end + ":");
            for (Produit p : produitsDate) {
                System.out.println(p.getRef() + " - Date d'achat: " + p.getDateAchat());
            }
            scanner.close();
        } catch (ParseException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
