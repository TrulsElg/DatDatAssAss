package com.util;

import entities.Ovelse;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by TrulsElg on 14/03/17.
 */
public class ObjectAdder {

    public void addOvelse(Ovelse ovelse){
        int antallOvelser = 0;
        TableManager tblm = new TableManager();
        String sqlQuery = "SELECT * FROM ovelse>";
        ResultSet rs = tblm.makeQuery("prosjekt", sqlQuery);
        try {
            antallOvelser = tblm.tellResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Det finnes "+antallOvelser+" i tabellen");
    }
}
