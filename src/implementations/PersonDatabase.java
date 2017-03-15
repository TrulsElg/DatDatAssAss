package implementations;

import com.util.ConnectionConfig;
import entities.Person;

import java.sql.*;

/**
 * Created by TrulsElg on 14/03/17.
 */
public class PersonDatabase {

    public void createPersonTable(String databaseNavn) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionConfig.getConnection(databaseNavn);
            statement = connection.createStatement();
            String sql = "";
            statement.execute("CREATE TABLE IF NOT EXISTS person(id INTEGER not NULL AUTO_INCREMENT, " +
                    "first_name VARCHAR(55), last_name VARCHAR(55), PRIMARY KEY (id))");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void deletePersonTable (String databaseNavn) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionConfig.getConnection(databaseNavn);
            statement=connection.createStatement();

            String sql = "DROP TABLE person";

            statement.executeUpdate(sql);
        } catch (SQLException se){
          se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    }

    public void insert(String databaseNavn) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;

        try {
            connection=ConnectionConfig.getConnection(databaseNavn);
            /*
            preparedStatement=connection.prepareStatement("INSERT INTO person (id,first_name, last_name)," +
                    "VALUES (?, ?, ?)");
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2, "My");
            preparedStatement.setString(3, "Name");
            preparedStatement.executeUpdate();
            */


            statement = connection.createStatement();
            String sql = "INSERT INTO person " +
                    "VALUES (2,'Mich', 'Hoyer')";
            statement.executeUpdate(sql);


        }catch (SQLException se) {
            se.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void makeQuery(String databaseNavn){
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionConfig.getConnection(databaseNavn);
            statement=connection.createStatement();

            String sqlQuery = "SELECT id, first_name, last_name FROM person";
            ResultSet rs = statement.executeQuery(sqlQuery);

            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }

        } catch (SQLException se){
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    }
}
