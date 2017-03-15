package entities;
import java.util.Calendar;
// import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Andreas on 14/03/2017.
 */
public class Treningsokt {
    private Calendar start;
    private Calendar slutt;
    private int dagsform;
    private ArrayList<Resultat> resultater = new ArrayList<Resultat>();

    public Treningsokt(int dagsform, ArrayList<Resultat> resultater, Calendar start, Calendar Slutt){
        this.dagsform=dagsform;
        this.resultater = resultater;
        this.start = start;
        this.slutt = slutt;
    }
    public Calendar getStart() {
        return start;
    }

    public void setStart(Calendar start) {
        this.start = start;
    }

    public Calendar getSlutt() {
        return slutt;
    }

    public void setSlutt(Calendar slutt) {
        this.slutt = slutt;
    }

    public int getDagsform() {
        return dagsform;
    }

    public void setDagsform(int dagsform) {
        this.dagsform = dagsform;
    }
}
