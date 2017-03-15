package com.util;

import entities.Ovelse;
import entities.Treningsokt;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by TrulsElg on 14/03/17.
 */
public class ObjectAdder {

    public void addOvelse(Ovelse ovelse){
        int antallOvelser = -1;
        TableManager tblm = new TableManager();
        antallOvelser = tblm.getRowsOfTable("prosjekt", "ovelse");

        String sql = "INSERT INTO ovelse VALUES("+(antallOvelser+1)+",'"+ovelse.getNavn()+"','"+ovelse.getBeskrivelse()+"')";
        tblm.insertValues("prosjekt",sql);
    }

    public void addTreningsokt (Treningsokt tokt) {
        int antallTreningsokter = -1;
        TableManager tblm = new TableManager();
        antallTreningsokter = tblm.getRowsOfTable("prosjekt", "treningsokt");

    }
}