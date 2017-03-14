import com.util.DatabaseManager;
import implementations.PersonDatabase;

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
    }
}
