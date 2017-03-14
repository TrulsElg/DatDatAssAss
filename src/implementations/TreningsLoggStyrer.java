package implementations;

import java.sql.*;
import java.util.Calendar;

import com.util.TableManager;

public class TreningsLoggStyrer {

  public int getAntallTreningsOkter (int dager) throws SQLException {
          // Finner dato-grensen
          Calendar today = Calendar.getInstance();            // dato og tid akkurat nå
          today.set(Calendar.DATE, - dager);                  // trekker ifra gitt antall dager
          Date dato_grense = new Date(today.getTime().getTime());    // konveterer til sql.date objekt

          // Henter ut alle okter etter dato-grense i et ResultSet
          String sqlQuery = "SELECT * FROM treningsokt WHERE dato>" + dato_grense;
          TableManager tls = new TableManager();
          ResultSet rs = tls.makeQuery("root", sqlQuery);

          // Teller opp treningsOkter etter dato-grensen
          int antallTreningsOkter= 0;
          if (!rs.next()) {
              //then there are no rows.
              System.out.println("No records found");
          }
          else {
              do {
                  antallTreningsOkter++;
              } while (rs.next());
          }

          return antallTreningsOkter;
      }
}
