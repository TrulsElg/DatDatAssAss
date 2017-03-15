package com.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by TrulsElg on 14/03/17.
 */
public class TableCreator {

    public void createAllTables() {
        TableManager tbm = new TableManager();
        String sqlOvelse;
        String projectName = "prosjekt";

        //Oppretter øvelse-tabell
        sqlOvelse = "CREATE TABLE IF NOT EXIST ovelse(INT id NOT NULL, navn VARCHAR(50), beskrivelse VARCHAR(500), PRIMARY KEY (id))";
        tbm.createTable(projectName, sqlOvelse);


    }


    public void createTables(String databaseNavn) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionConfig.getConnection(databaseNavn);
            statement = connection.createStatement();

            //Oppretter en tabell for øvelser
            statement.execute("CREATE TABLE IF NOT EXISTS ovelse(id INTEGER NOT NULL, navn VARCHAR(55)," +
                    " beskrivelse VARCHAR(500), PRIMARY KEY(id))");

            //Oppretter en tabell for treningsøkter
            statement.execute("CREATE TABLE IF NOT EXISTS treningsokt(id INTEGER NOT NULL, dato DATE ," +
                    " tidStart TIME, tidSlutt TIME, dagsform INTEGER, notat VARCHAR(500), PRIMARY KEY(id))");

            //Oppretter tabell for resultater
            statement.execute("CREATE TABLE IF NOT EXISTS resultater(treningsoktID INTEGER NOT NULL, " +
                    "ovelseID INTEGER NOT NULL, belastning INTEGER, reps INTEGER, sets INTEGER, " +
                    "FOREIGN KEY(treningsoktID) REFERENCES treningsokt(id), " +
                    "FOREIGN KEY(ovelseID) REFERENCES ovelse(id))");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}