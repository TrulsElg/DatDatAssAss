package implementations;

import java.sql.*;
import java.util.Calendar;

import com.util.ConnectionConfig;
import com.util.TableManager;

public class TreningsLoggStyrer {

  public int getAntallTreningsOkter (int dager) throws SQLException {
      // Finner dato-grensen
      Calendar today = Calendar.getInstance();            // dato og tid akkurat nå
      today.set(Calendar.DATE, - dager);                  // trekker ifra gitt antall dager
      Date dato_grense = new Date(today.getTime().getTime());    // konveterer til sql.date objekt


      // Henter ut alle okter etter dato-grense i et ResultSet
      String sqlQuery = "SELECT * FROM treningsokt WHERE dato>'" + dato_grense + "'";
      Connection connection = null;
      Statement statement = null;
      ResultSet rs = null;
      int antallTreningsOkter = 0;

      try {
          connection = ConnectionConfig.getConnection("prosjekt");
          statement=connection.createStatement();

          rs = statement.executeQuery(sqlQuery);

          // Teller opp treningsOkter etter dato-grensen
          if (!rs.next()) {
              //then there are no rows.
              System.out.println("No records found");
          }
          else {
              do {
                  antallTreningsOkter++;
              } while (rs.next());
          }

      } catch (SQLException se){
          se.printStackTrace();
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
          if (rs != null){
              try {
                  rs.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }

          if (statement!=null) {
              try {
                  statement.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }

          if (connection!=null){
              try {
                  connection.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
      }



          return antallTreningsOkter;
      }
}
