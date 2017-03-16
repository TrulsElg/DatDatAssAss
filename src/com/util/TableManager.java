package com.util;
import java.sql.*;

/**
 * Created by TrulsElg on 14/03/17.
 */
public class TableManager {

    public void createTable(String sqlUserName, String sqlPassword, String databaseNavn, String sqlString) {
        //Takes in name of database to create table in and the string of sql commands to create the table with it's values
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionConfig.getConnection(sqlUserName, sqlPassword, databaseNavn);
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

    public void dropTable(String sqlUserName, String sqlPassword, String databaseNavn, String tableNavn) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionConfig.getConnection(sqlUserName, sqlPassword, databaseNavn);
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE " + tableNavn);
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

    public void insertValues(String sqlUserName, String sqlPassword, String databaseNavn, String sqlInsert) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;

        try {
            connection=ConnectionConfig.getConnection(sqlUserName, sqlPassword, databaseNavn);

            statement = connection.createStatement();
            statement.executeUpdate(sqlInsert);
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

    public void insertStartValues(String sqlUserName, String sqlPassword, String databaseNavn) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;

        try {
            connection=ConnectionConfig.getConnection(sqlUserName, sqlPassword, databaseNavn);

            statement = connection.createStatement();
            String sql = "INSERT ignore INTO ovelse VALUES (1,'Push-ups', 'Du vet hvordan du tar en push-up...')";
            statement.executeUpdate(sql);
            sql = "INSERT ignore INTO ovelse VALUES (2, 'Benkpress', 'Hvordan å ta benkpress mon tro')";
            statement.executeUpdate(sql);
            sql = "INSERT ignore INTO ovelse VALUES (3, 'Arnoldpress', 'Google it')";
            statement.executeUpdate(sql);

            sql = "INSERT ignore INTO treningsokt VALUES (1, '2017-03-15', '12:30:00', '14:00:00', 5, 'æTrene')";
            statement.executeUpdate(sql);
            sql = "INSERT ignore INTO treningsokt VALUES (2, '2016-03-15', '12:30:00', '14:00:00', 5, 'Skal æ trene?')";
            statement.executeUpdate(sql);
            sql = "INSERT ignore INTO treningsokt VALUES (3, '2017-03-16', '12:30:00', '14:00:00', 5, 'No har æ trænt')";
            statement.executeUpdate(sql);

            sql = "INSERT ignore INTO resultater VALUES (1, 2, 40, 12, 3)";
            statement.executeUpdate(sql);
            sql = "INSERT ignore INTO resultater VALUES (1, 2, 45, 12, 3)";
            statement.executeUpdate(sql);
            sql = "INSERT ignore INTO resultater VALUES (1, 2, 50, 12, 3)";
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

    public ResultSet makeQuery(String sqlUserName, String sqlPassword, String databaseNavn, String sqlQuery){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            connection = ConnectionConfig.getConnection(sqlUserName, sqlPassword, databaseNavn);
            statement=connection.createStatement();

            rs = statement.executeQuery(sqlQuery);
            tellResultSet(rs);

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

    public int getRowsOfTable(String sqlUserName, String sqlPassword, String databaseNavn, String tableNavn){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            connection = ConnectionConfig.getConnection(sqlUserName, sqlPassword, databaseNavn);
            statement=connection.createStatement();

            rs = statement.executeQuery("SELECT * FROM "+tableNavn);
            rows=tellResultSet(rs);

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

        return rows;
    }

    public int tellResultSet(ResultSet rs) throws SQLException{
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

        return resultat;
    }

    public void deleteID(String sqlUserName, String sqlPassword, String databaseNavn, String tableNavn, int ID){
        Connection connection = null;
        Statement statement = null;

        try {
            connection=ConnectionConfig.getConnection(sqlUserName,sqlPassword,databaseNavn);
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM "+tableNavn+" WHERE id = "+ID);

        }catch (SQLException se) {
            se.printStackTrace();
        }catch (Exception e) {
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

}
