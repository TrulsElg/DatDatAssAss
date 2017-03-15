package com.util;
import java.sql.*;

/**
 * Created by TrulsElg on 14/03/17.
 */
public class TableManager {

    public void createTable(String databaseNavn, String sqlString) {
        //Takes in name of database to create table in and the string of sql commands to create the table with it's values
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionConfig.getConnection(databaseNavn);
            statement = connection.createStatement();
            statement.execute(sqlString);
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

    public void dropTable(String databaseNavn, String tableNavn) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionConfig.getConnection(databaseNavn);
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE "+tableNavn);
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

    public void insertValues(String databaseNavn, String sqlInsert) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;

        try {
            connection=ConnectionConfig.getConnection(databaseNavn);

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

    public ResultSet makeQuery(String databaseNavn, String sqlQuery){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            connection = ConnectionConfig.getConnection(databaseNavn);
            statement=connection.createStatement();

            rs = statement.executeQuery(sqlQuery);
            //tellResultSet(rs);

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

        return rs;
    }

    private void tellResultSet(ResultSet rs) throws SQLException{
        int resultat= 0;
        if (!rs.next()) {
            //then there are no rows.
            System.out.println("No records found");
        }
        else {
            do {
                resultat++;
            } while (rs.next());
        }

        System.out.println(resultat + " antall resultater");
    }
}
