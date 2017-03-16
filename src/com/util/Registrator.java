package com.util;

import entities.Ovelse;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Created by TrulsElg on 15/03/17.
 */
public class Registrator {

    public void nyOkt () {
        Scanner input = new Scanner(System.in);
        String date = "intet svar";


        while (date.equals("intet svar")) {
            System.out.print("Bruk dagens dato? (y/n): ");
            String answer = input.nextLine();
            answer = answer.toLowerCase();
            if (answer.equals("y")){
                SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
                date = sdf.format(new Date());
                String [] dateStrings = date.split("/");
                date = dateStrings[2] + "-" + dateStrings[1] + "-" + dateStrings[0];
            } else if (answer.equals("n")){
                System.out.print("Skriv inn dato på formen yyyy-mm-dd: ");
                date = input.nextLine();
            }
        }

        System.out.print("Skriv starttid for økten (hh:mm): ");
        String startTid = input.nextLine()+":00";

        System.out.print("Skriv sluttid for økten (hh:mm): ");
        String endTid = input.nextLine()+":00";



        System.out.print("Skriv inn dagsform for treningsøkten som et tall 1-10: ");
        int dagsform = input.nextInt();

        input.nextLine();

        System.out.print("Legg til notat om treningsøkten: ");
        String notat = input.nextLine();

        System.out.println("Treningsøkten består av:\n" +
                "Dato: "+date+"\nStarttid: "+startTid+"\nSluttid: "+endTid+"\n" +
                "Dagsform: "+dagsform+"\nNotat: "+notat);

        System.out.println("\n------------------------------\n");
    }
    public void newExercise(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------------------");
        System.out.println("Registrer ny øvelse");
        System.out.println("-------------------\n");

        System.out.print("Skriv navnet til øvelsen: ");
        String navn = scanner.nextLine();
        //System.out.println("Du ga øvelsen navnet: " + navn);

        System.out.print("Gi øvelsen en beskrivelse: ");
        String beskrivelse = scanner.nextLine();
        //System.out.println("Du la til beskrivelsen: '"+beskrivelse+"'");

        //String[] exercise = reader.nextLine().split(",");
        Ovelse ovelse = new Ovelse(navn, beskrivelse);

        ObjectAdder oa = new ObjectAdder();
        oa.addOvelse(ovelse);

        System.out.println("Du har oprettet øvelsen '" + ovelse.getNavn() + "' med beskrivelsen:\n" + ovelse.getBeskrivelse());
        System.out.println("\n------------------------------\n");
    }

}
