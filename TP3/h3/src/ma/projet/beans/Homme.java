package ma.projet.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "homme")
public class Homme extends Personne {

    public Homme() {
    }

    public Homme(String nom, String prenom, String tel, String adresse, Date dateNaissance) {
        super(nom, prenom, tel, adresse, dateNaissance);
    }
}
