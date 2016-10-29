import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class andmebaas {
    String name;
    double power = 0;
    double voolutarve = 0;
    double voolKokku = 0;
    int channels = 0;
    int dmx = 0;
    ArrayList tootjaAndmebaasist = new ArrayList();
    ArrayList nimiAndmebaasist = new ArrayList();


    // Andmebaasi loomine
    public void createDatabase() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:devices.db");
            System.out.println("Andmebaas loodud.");

            // Tabeli loomine
            stmt = c.createStatement();
            String sql = "CREATE TABLE DEVICES " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " POWER            DOUBLE     NOT NULL, " +
                    " CHANNELS        INT)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Tabel loodud.");

    }

    // Tekstifaili lugemine
    private Scanner x;

    public void openFile() {
        try {
            x = new Scanner(new File("data.txt"));
        } catch (Exception e) {
            System.out.println("Faili ei leitud");
        }
    }

    public void readFile() {
        boolean tableExists = false;
        while (x.hasNext()) {
            String a = x.next();
            String b = x.next();
            String d = x.next();
            String e = x.next();
            String value = "VALUES (" + a + ", '" + b + "', " + d + ", " + e + " );";
            sql(value);

        }
    }

    public void closeFile() {
        x.close();
    }

    //Faili andmed tabelisse
    public void sql(String value) {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:devices.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:devices.db");
            Statement stmt = null;
            c.setAutoCommit(false);
            //  System.out.println("Opened database successfully");

            stmt = c.createStatement();

            String sql = "INSERT INTO DEVICES (ID,NAME,POWER,CHANNELS) " +
                    value;
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }

    // Seadmete nimed drop-down menüüsse
    public ArrayList getSeadmed() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = null;
            c = DriverManager.getConnection("jdbc:sqlite:devices.db");
            c.setAutoCommit(false);
            Statement stmt = null;
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM DEVICES;");
            while (rs.next()) {
                String name = rs.getString("name");
                nimiAndmebaasist.add(name);
            }
            System.out.println("getSeadmed" + nimiAndmebaasist);
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return nimiAndmebaasist;



}}
