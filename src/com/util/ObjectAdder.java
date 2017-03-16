package com.util;

import entities.Ovelse;
import entities.Treningsokt;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by TrulsElg on 14/03/17.
 */
public class ObjectAdder {

    public void addOvelse(String sqlUserName, String sqlPassword, String databaseNavn,Ovelse ovelse){
        int antallOvelser = -1;
        TableManager tblm = new TableManager();
        antallOvelser = tblm.getRowsOfTable(sqlUserName, sqlPassword, databaseNavn, "ovelse");

        String sql = "INSERT INTO ovelse VALUES("+(antallOvelser+1)+",'"+ovelse.getNavn()+"','"+ovelse.getBeskrivelse()+"')";
        tblm.insertValues(sqlUserName, sqlPassword, databaseNavn,sql);
    }

}
