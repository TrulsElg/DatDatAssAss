package entities;
import

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Andreas on 14/03/2017.
 */
public class Treningsokt {
    private int id;
    private Date start;
    private Date slutt;
    private int dagsform;
    private ArrayList<Ovelse> ovelse = new ArrayList<Ovelse>();

}
