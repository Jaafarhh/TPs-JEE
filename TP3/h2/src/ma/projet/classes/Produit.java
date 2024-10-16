package ma.projet.classes;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery(name = "Produit.findByPrixSuperieur",
            query = "SELECT p FROM Produit p WHERE p.prix > :prix"),
    @NamedQuery(
            name = "getProduitsByDate",
            query = "SELECT lcp.produit FROM LigneCommandeProduit lcp JOIN lcp.commande c WHERE c.date BETWEEN :start AND :end"
    )
})
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "reference")
    private String reference;

    @Column(name = "prix")
    private float prix;

    @ManyToOne
    @JoinColumn(name = "categorie")
    private Categorie categorie;

    @OneToMany(mappedBy = "produit")
    private List<LigneCommandeProduit> LigneCommandeProduit;

    public Produit() {
    }

    public Produit(String reference, float prix) {
        this.reference = reference;
        this.prix = prix;
    }

    public Produit(String reference, float prix, Categorie categorie) {
        this.reference = reference;
        this.prix = prix;
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<LigneCommandeProduit> getLigneCommandeProduit() {
        return LigneCommandeProduit;
    }

    public void setLigneCommandeProduit(List<LigneCommandeProduit> LigneCommandeProduit) {
        this.LigneCommandeProduit = LigneCommandeProduit;
    }

    @Override
    public String toString() {
        return "Produit{" + "reference=" + reference + ", prix=" + prix + ", categorie=" + categorie + ", LigneCommandeProduit=" + LigneCommandeProduit + '}';
    }

}
