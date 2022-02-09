import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PrepearingStart {


    public static void Check(){
         String dbURL = "jdbc:sqlite:test.db";
        Connection dbCon = null;
        try {
            //getting database connection to MySQL server
            Class.forName("org.sqlite.JDBC");
            dbCon = DriverManager.getConnection(dbURL);
            System.out.println("ok");


            Statement stmt = dbCon.createStatement();
            stmt.execute("CREATE TABLE if not exists 'main_acc' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'surname' text, 'passport' text not null, 'kart' text not null, 'passw' text not null, 'money' integer, 'status' text not null);");

            Statement stmt1 = dbCon.createStatement();
            stmt1.execute("CREATE TABLE if not exists 'log_data' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'time' text, 'who' text, 'action' text);");

            Statement stmt2 = dbCon.createStatement();
            stmt2.execute("CREATE TABLE if not exists 'log_data_copy' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'time' text, 'who' text, 'action' text);");

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();

        }
    }

    public static void Ben(){
        String dbURL = "jdbc:sqlite:test.db";
        Connection dbCon = null;
        try {
            //getting database connection to MySQL server
            Class.forName("org.sqlite.JDBC");
            dbCon = DriverManager.getConnection(dbURL);
            System.out.println("ok");



            Select sel = new Select();
            sel.getInsertAcc("Benjamin", "Linus", "4815162342", "4484-7213-4838-7880", "1234", "0", "aktive");

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();

        }
    }
}
