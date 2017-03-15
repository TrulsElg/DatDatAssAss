package entities;

/**
 * Created by Andreas on 15/03/2017.
 */
public class Resultat {

    private int belastning;
    private int antReps;
    private int antSett;

    public Resultat(int belastning, int antSett, int antReps){
        this.belastning=belastning;
        this.antReps=antReps;
        this.antSett=antSett;
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
