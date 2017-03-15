package entities;

/**
 * Created by Andreas on 14/03/2017.
 */
public class Ovelse {

    private String navn;
    private String beskrivelse;

    public Ovelse (String navn,String beskrivelse) {
        this.navn = navn;
        this.beskrivelse=beskrivelse;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
    public String getBeskrivelse() {
        return this.beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse=beskrivelse;
    }
}
