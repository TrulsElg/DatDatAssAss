package entities;

/**
 * Created by Andreas on 14/03/2017.
 */
public class Ovelse {

    private int id;
    private String navn;
    private int belastning;
    private int antReps;
    private int antSett;

    public Ovelse (String navn, int belastning, int antReps, int antSett) {
        this.navn = navn;
        this.belastning = belastning;
        this.antReps = antReps;
        this.antSett = antSett;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
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
