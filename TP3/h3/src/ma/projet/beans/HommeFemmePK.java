package ma.projet.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class HommeFemmePK implements Serializable {

    private int femme_id;
    private int homme_id;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    public HommeFemmePK() {
    }

    public HommeFemmePK(int femme_id, int homme_id, Date dateDebut) {
        this.femme_id = femme_id;
        this.homme_id = homme_id;
        this.dateDebut = dateDebut;
    }

    public int getFemmeId() {
        return femme_id;
    }

    public void setFemmeId(int femme_id) {
        this.femme_id = femme_id;
    }

    public int getHommeId() {
        return homme_id;
    }

    public void setHommeId(int homme_id) {
        this.homme_id = homme_id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
}
