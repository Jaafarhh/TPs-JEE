package ma.projet.classes;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "commande")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToMany(mappedBy = "commande")
    private List<LigneCommandeProduit> ligneCommandeProduits;

    public Commande() {
    }

    public Commande(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<LigneCommandeProduit> getLigneCommandeProduits() {
        return ligneCommandeProduits;
    }

    public void setLigneCommandeProduits(List<LigneCommandeProduit> ligneCommandeProduits) {
        this.ligneCommandeProduits = ligneCommandeProduits;
    }

}
