package entities;


public class DevData {
    private String Dev;
    private String Jour;
    private int nbScripts;

    public DevData() {
    }

    public DevData(String Dev, String Jour, int nbScripts) {
        this.Dev = Dev;
        this.Jour = Jour;
        this.nbScripts = nbScripts;
    }

    public String getDev() {
        return Dev;
    }

    public String getJour() {
        return Jour;
    }

    public int getNbScripts() {
        return nbScripts;
    }

    public void setDev(String Dev) {
        this.Dev = Dev;
    }

    public void setJour(String Jour) {
        this.Jour = Jour;
    }

    public void setNbScripts(int nbScripts) {
        this.nbScripts = nbScripts;
    }
    
    
}
