package ma.projet.test;

import java.util.Date;
import ma.projet.beans.Employe;
import ma.projet.beans.Message;
import ma.projet.service.EmployeService;
import ma.projet.service.MessageService;

public class Messagerie {

    public static void main(String[] args) {
        // Test EmployeService
        EmployeService es = new EmployeService();

        // Création des employés
//        es.create(new Employe("LACHGAR", "Mohamed"));
//        es.create(new Employe("RAMI", "ALI"));
//        es.create(new Employe("SAFI", "Fatima"));

        // Modification d'un employé
//        Employe e = es.getById(6);
//        if (e != null) {
//            e.setNom("ALAOUI");
//            e.setPrenom("Manale");
//            es.update(e);
//        }

        // Suppression d'un employé
//        es.delete(es.getById(4));

        // Liste des employés
        for (Employe emp : es.getAll()) {
            System.out.println(emp.getNom());
        }

        // Test MessageService
        MessageService ms = new MessageService();

        // Création des messages
        ms.create(new Message("Réunion", "Réunion de fin d'année", new Date(), es.getById(6), es.getById(7)));
        ms.create(new Message("Réunion", "Réunion de fin d'année", new Date(), es.getById(6), es.getById(8)));
        ms.create(new Message("Stage", "Stage à Marrakech", new Date(), es.getById(7), es.getById(6)));
        ms.create(new Message("Stage", "Stage à Marrakech", new Date(), es.getById(7), es.getById(9)));

        // Affichage des messages reçus par l'employé 3
        for (Message m : ms.getAll()) {
            if (m.getEmpRecepteur().getId() == 3) {
                System.out.println(m.getSujet());
            }
        }
    }
}
