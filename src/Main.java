import com.util.DatabaseManager;
import com.util.ObjectAdder;
import com.util.TableCreator;
import com.util.TableManager;
import implementations.PersonDatabase;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import entities.*;


public class Main {
	Scanner reader;
	String testOvelser = "1.Markløft\n2.Benkpress\n3.Knebøy\n4.FapFapFap";
	String line = "------------------------------------------------------------------------------------------------------";


    public static void main(String[] args) {
		TableCreator tblc = new TableCreator();
		tblc.createTables("prosjekt");
		DatabaseManager dbc = new DatabaseManager();
        //dbc.createDatabase("Test");
        //dbc.deleteDatabase("Test");
        PersonDatabase pdb = new PersonDatabase();
        //pdb.createPersonTable("Test");
        //Person person = new Person("Truls","Elgaaen");
        //pdb.insert("Test");
        //pdb.deletePersonTable("Test");
        //pdb.makeQuery("Test");
		TableManager tbm = new TableManager();
		//tbm.makeQuery("Test","SELECT id, first_name, last_name FROM person");
		//Main tb = new Main();
		//tbm.dropTable("prosjekt", "resultater");
		tbm.deleteID("prosjekt", "ovelse",3);
		//tbm.makeQuery("Test","SELECT id, first_name, last_name FROM person");

		ObjectAdder oa = new ObjectAdder();
		//Ovelse ovelse = new Ovelse("Knebøy", "Skuldre over knær, gå ned til 90 grader i knærne og opp igjen i en sammenhengende bevegelse.");
		//oa.addOvelse(ovelse);


        Main tb = new Main();
		tb.run();
    }


	public void run(){
		System.out.println("Treningsappen æTrene");
		System.out.println(line + "\n\n");
		boolean runWhile=true;
		while (runWhile) {
			reader = new Scanner(System.in);

			System.out.println("Meny");
			System.out.println(line);
			System.out.println("1.Registrer ny økt \n2.Registrer ny øvelse\n3.Se statistikk over treningsøkter de siste 30 dagene \n4.Se progresjon for individuell øvelse \n5.Exit\n\n\n\n");
			
			System.out.print("Skriv inn tall: ");
			int tall = reader.nextInt();
			
			switch (tall) {
			case 1:	newSession();
			break;
			case 2: newExercise();
			break;
			case 3: statistics();
			break;
			case 4: progression();
			break;
			case 5: 
				runWhile=false;
				System.out.println("Programmet er avsluttet. Takk for at du bruker æTrene!");
				break;
			} //End Switch
			
		}//End While
	}// Run
		
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
		
		public void newSession(){
			Calendar start = Calendar.getInstance();

			
			
			System.out.println("Skriv inn dagsform for treningsøkten som et tall 1-10:\n");
			int dagsform = reader.nextInt();

			boolean runWhile =  true;
			ArrayList<Resultat> results = new ArrayList<Resultat>();
			while(runWhile){
				System.out.println("Tast inn nr for øvelse i databasen du ønsker å legge til denne økten:\n"
						+ line + "\n" +testOvelser); //TODO henting fra SQL
				int numExercise = reader.nextInt();
				
				System.out.println("Skriv inn resultat i følgende format:\n"
						+ "Belastning,Antall Sett,Antall Reps");
				String[] enkeltResultat = reader.nextLine().split(",");

				results.add(new Resultat(Integer.parseInt(enkeltResultat[0]),Integer.parseInt(enkeltResultat[1]),Integer.parseInt(enkeltResultat[2]))); //int belastning, int antSett, int antReps
			} //End While
			Calendar slutt = Calendar.getInstance();
			Treningsokt okt = new Treningsokt(dagsform,results, start, slutt );

		}
		public void statistics(){
			
			
		}
		
		public void progression(){
			
		}
		
		
}
	
