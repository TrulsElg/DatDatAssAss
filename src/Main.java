import com.util.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import entities.*;
import implementations.TreningsLoggStyrer;


public class Main {
	Scanner reader;
	String testOvelser = "1.Markløft\n2.Benkpress\n3.Knebøy\n4.FapFapFap";
	String line = "------------------------------------------------------------------------------------------------------";
	String databaseNavn;
	public static String sqlBrukerNavn;
	public static String sqlPassword;


    public static void main(String[] args) {
		/*
		DatabaseManager dbc = new DatabaseManager();
        PersonDatabase pdb = new PersonDatabase();
		TableManager tbm = new TableManager();
		TableCreator tblc = new TableCreator();
		ObjectAdder oa = new ObjectAdder();
		*/

        Main tb = new Main();
		tb.init();
		tb.run();
    }

	private void init() {
		reader = new Scanner(System.in);

		System.out.print("Skriv inn brukernavn for sql-serveren din: ");
		sqlBrukerNavn = reader.nextLine();
		System.out.print("Skriv inn passord for sql-serveren din: ");
		sqlPassword = reader.nextLine();
		System.out.print("Skriv inn navnet på databasen din (om den ikke eksisterer blir den opprettet). NB!! Case sensitive. : ");
		databaseNavn = reader.nextLine();

		System.out.println("Brukernavn: " + sqlBrukerNavn + ". Passord: " + sqlPassword + ". Databasenavn: " + databaseNavn);
		System.out.println(line);

		DatabaseManager dbm = new DatabaseManager();
		dbm.createDatabase(sqlBrukerNavn, sqlPassword, databaseNavn);
		TableCreator tblc = new TableCreator();
		tblc.createTables(sqlBrukerNavn, sqlPassword, databaseNavn);

	}


	public void run(){
		Registrator reg = new Registrator();
		System.out.println("Treningsappen æTrene");
		System.out.println(line + "\n\n");
		boolean runWhile=true;
		while (runWhile) {
			reader = new Scanner(System.in);

			System.out.println("Meny");
			System.out.println(line);
			System.out.println("1.Registrer ny økt \n2.Registrer ny øvelse\n3.Se statistikk over treningsøkter de siste 30 dagene \n4.Se progresjon for individuell øvelse \n5.Fjern en øvelse fra databasen\n6.Exit\n\n\n\n");
			
			System.out.print("Skriv inn tall: ");
			int tall = reader.nextInt();
			
			switch (tall) {
				case 1:	reg.nyOkt();
					break;
				case 2: reg.newExercise(sqlBrukerNavn,sqlPassword,databaseNavn);
					break;
				case 3: statistics(sqlBrukerNavn,sqlPassword,databaseNavn);
					break;
				case 4: progression(sqlBrukerNavn,sqlPassword,databaseNavn);
					break;
				case 5:
					System.out.println("Du vil slette en øvelse");
					break;
				case 6:
					runWhile=false;
					System.out.println("Programmet er avsluttet. Takk for at du bruker æTrene!");
					break;
			} //End Switch
			
		}//End While
	}// Run
		

		

		public void statistics(String sqlUserName, String sqlPassword, String databaseNavn){
			TreningsLoggStyrer tls = new TreningsLoggStyrer();
			System.out.println(tls.getAntallTreningsOkter(sqlUserName,sqlPassword,databaseNavn,30));


		}
		
		public void progression(String sqlUserName, String sqlPassword, String databaseNavn){
			TreningsLoggStyrer tls = new TreningsLoggStyrer();
			ArrayList<Integer> progress = tls.getMaksloftProgress(sqlUserName,sqlPassword,databaseNavn,1);

			System.out.println(progress);
		}
		
		
}
	
