import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LogInsert extends Father{
    public static void set(String time, String who, String action){
        String dbURL = "jdbc:sqlite:test.db";
        Connection dbCon = null;
        String ins ="INSERT INTO log_data( time, who, action) VALUES( '" + time + "', '" + who + "', '" + action + "')";
        String ins_copy ="INSERT INTO log_data_copy( time, who, action) VALUES( '" + time + "', '" + who + "', '" + action + "')";
        System.out.println(ins);
        try {
            //getting database connection to MySQL server
            Class.forName("org.sqlite.JDBC");
            dbCon = DriverManager.getConnection(dbURL);
            System.out.println("ok from select");


            Statement stmt = dbCon.createStatement();
            stmt.execute(ins);
            Statement stmt_copy = dbCon.createStatement();
            stmt_copy.execute(ins_copy);


        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();

        }
    }

    public static String time(){
        String time= new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(Calendar.getInstance().getTime());
        return time;
    }
    public static void Truncate(){
        String dbURL = "jdbc:sqlite:test.db";
        Connection dbCon = null;
        String ins ="DELETE FROM log_data;";
        System.out.println(ins);
        try {
            //getting database connection to MySQL server
            Class.forName("org.sqlite.JDBC");
            dbCon = DriverManager.getConnection(dbURL);
            System.out.println("ok from select");


            Statement stmt = dbCon.createStatement();
            stmt.execute(ins);
            LogInsert.set( LogInsert.time(),"ADMIN","очистка таблицы событий");


        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();

        }
    }
}
