package ma.projet.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name = "Femme.marriedTwiceOrMore",
            query = "SELECT f FROM Femme f WHERE (SELECT COUNT(m) FROM Mariage m WHERE m.femme.id = f.id) >= 2")
})
@Table(name = "femme")
public class Femme extends Personne {

    public Femme() {
    }

    public Femme(String nom, String prenom, String tel, String adresse, Date dateNaissance) {
        super(nom, prenom, tel, adresse, dateNaissance);
    }
}
