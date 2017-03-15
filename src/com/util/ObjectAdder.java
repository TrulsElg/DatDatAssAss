package com.util;

import entities.Ovelse;

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
        System.out.println("Det finnes "+antallOvelser+" i tabellen ovelser");


    }
}
