import com.util.DatabaseManager;
import implementations.PersonDatabase;
import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

Scanner reader = new Scanner(System.in);
String testOvelser = "1.Markløft\n2.Benkpress\n3.Knebøy\n4.FapFapFap";
String line = "------------------------------------------------------------------------------------------------------";

public class Main {

    public static void main(String[] args) {
        DatabaseManager dbc = new DatabaseManager();
        //dbc.createDatabase("Test");
        //dbc.deleteDatabase("Test");
        PersonDatabase pdb = new PersonDatabase();
        //pdb.createPersonTable("Test");
        //Person person = new Person("Truls","Elgaaen");
        //pdb.insert("Test");
        //pdb.deletePersonTable("Test");
        pdb.makeQuery("Test");
        Main tb = new Main();
		tb.run();
    }
	
	public static void main(String[] args) {
		Main tb = new Main();
		tb.run();
	}

	public void run(){
		System.out.println("Treningsappen æTrene");
		System.out.println(line + "\n\n");
		boolean runWhile=true;
		while (runWhile) {
			
			System.out.println("Meny");
			System.out.println(line);
			System.out.println("1.Registrer ny økt \n2.Registrer ny øvelse\n3.Se statistikk over treningsøkter de siste 30 dagene \n4.Se progresjon for individuell øvele \n5.Exit\n\n\n\n");
			
			System.out.println("Skriv inn tall: ");
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
			System.out.println("Registrer ny øvelse på følgende format:\n"
					+ "Navn,Beskrivelse,Type('U' for Utholdenhet og 'S' for Styrke)");
			String[] exercise = reader.nextLine().split(",");
		}
		
		public void newSession(){
	 		Calendar start = Calendar.getInstance();

			
			
			System.out.println("Skriv inn treningsøkten på følgende format:\n"
					+ "dato,start,slutt,dagsform");
			String[] session = reader.nextLine().split(",");
			
			boolean runWhile =  true;
			while(runWhile){
				System.out.println("Tast inn nr for øvelse i databasen du ønsker å legge til denne økten:\n"
						+ line + "\n" +testOvelser); //TODO henting fra SQL
				int numExercise = reader.nextInt();
				
				System.out.println("Skriv inn i følgende format:\n"
						+ "Belastning,Sett,Reps,Kommentar");
				String[] resultOvelse = reader.nextLine().split(",");
				
			} //End While
	 		Calendar slutt = Calendar.getInstance();

		}
		public void statistics(){
			
			
		}
		
		public void progression(){
			
		}
		
		
}
	
