package ma.projet.classes;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ligneCommandeProduit")
public class LigneCommandeProduit {

    @EmbeddedId
    private CommandeProduitPK pk;

    @ManyToOne
    @JoinColumn(name = "commande", insertable = false, updatable = false)
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "produit", insertable = false, updatable = false)
    private Produit produit;

    private int quantite;

    public LigneCommandeProduit() {
    }

    public LigneCommandeProduit(Commande commande, Produit produit, int quantite) {

        this.commande = commande;
        this.produit = produit;
        this.quantite = quantite;
    }

    public CommandeProduitPK getPk() {
        return pk;
    }

    public void setPk(CommandeProduitPK pk) {
        this.pk = pk;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

}
