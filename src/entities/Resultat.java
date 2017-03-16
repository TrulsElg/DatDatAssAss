package entities;

/**
 * Created by Andreas on 15/03/2017.
 */
public class Resultat {

    private int belastning;
    private int antReps;
    private int antSett;
    private String navn_ovelse; //Id øvelse
    private int id_TreningsOkt;

    public Resultat(int belastning, int antSett, int antReps, String navn_ovelse, int id_TreningsOkt){
        this.belastning=belastning;
        this.antReps=antReps;
        this.antSett=antSett;
        this.navn_ovelse=navn_ovelse;
        this.id_TreningsOkt=id_TreningsOkt;
    }

    public int getBelastning() {
        return belastning;
    }

    public void setBelastning(int belastning) {
        this.belastning = belastning;
    }

    public int getAntReps() {
        return antReps;
    }

    public void setAntReps(int antReps) {
        this.antReps = antReps;
    }

    public int getAntSett() {
        return antSett;
    }

    public void setAntSett(int antSett) {
        this.antSett = antSett;
    }
}
