package entities;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Andreas on 14/03/2017.
 */
public class Treningsokt {
    private Date start;
    private Date slutt;
    private int dagsform;
    private ArrayList<Ovelse> ovelse = new ArrayList<Ovelse>();

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getSlutt() {
        return slutt;
    }

    public void setSlutt(Date slutt) {
        this.slutt = slutt;
    }

    public int getDagsform() {
        return dagsform;
    }

    public void setDagsform(int dagsform) {
        this.dagsform = dagsform;
    }
}
