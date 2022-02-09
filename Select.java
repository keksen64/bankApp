import java.sql.*;

public class Select extends Father {

    private Connection dbCon = null;


   // private String dbURL = "jdbc:sqlite:test.db";
    /*private String what;
    private String from;
    private String where;


    public Select(String what, String from, String where) {
        this.what = what;
        this.from = from;
        this.where = where;
    }

    public Select( String from, String where ){
        this.from = from;
        this.where = where;
    }


     */

    String sql = "UPDATE warehouses SET name = ? , "
            + "capacity = ? "
            + "WHERE id = ?";

    //HUEVIY UPDATE
    public void getUpdate(String what,  String from, int where) {
        String upd = "UPDATE " + from + " SET  name = ? " + " WHERE id = ? ";

        try {
            //getting database connection to MySQL server
            Class.forName("org.sqlite.JDBC");
            dbCon = DriverManager.getConnection(dbURL);
            System.out.println("ok from select");


            PreparedStatement pstmt = dbCon.prepareStatement(upd);
            System.out.println("22");
            //pstmt.setString(1, "testTable");
            pstmt.setString(1, what);
            pstmt.setInt(2, where);
            System.out.println("22");
            System.out.println(pstmt);
            pstmt.executeUpdate();
            System.out.println("es");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();


        }
    }

    //HUEVIY INSERT
    public void getInsert(int what, String what1, String from) {
        String ins ="INSERT INTO " + from + " VALUES(?,?)";
        System.out.println(ins);
        try {
            //getting database connection to MySQL server
            Class.forName("org.sqlite.JDBC");
            dbCon = DriverManager.getConnection(dbURL);
            System.out.println("ok from select");


            PreparedStatement pstmt = dbCon.prepareStatement(ins);
            pstmt.setInt(1, what);
            pstmt.setString(2, what1);
            pstmt.executeUpdate();
            System.out.println("es");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();

        }
    }

    //ПОЛНЫЙ ОТВЕТ
    public void getAnswerAcc(String what, String where) {
        String req = "select " + what + " from main_acc where 1=1 " + where + ";";
        System.out.println(req);
        try {
            //getting database connection to MySQL server
            Class.forName("org.sqlite.JDBC");
            dbCon = DriverManager.getConnection(dbURL);
            System.out.println("ok from select");


            Statement stmt = dbCon.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id") + " | name: "+ rs.getString("name") + " | surname: " + rs.getString("surname") + " | passport: " + rs.getString("passport") + " | kart: " + rs.getString("kart") + " | passw: " + rs.getString("passw") + " | money: " + rs.getInt("money") + " | status: " + rs.getString("status"));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();

        }
    }








    //INSERT DLYA NOVOGO AKK
    public void getInsertAcc(String name, String surname, String passport, String kart, String passw, String money, String status) {
        String from = "main_acc ( name, surname, passport, kart, passw, money, status)";
        String ins ="INSERT INTO " + from + " VALUES( '" + name + "', '" + surname + "', '" + passport + "', '" + kart + "', '" + passw + "', '" + money + "', '" + status + "')";
        System.out.println(ins);
        try {
            //getting database connection to MySQL server
            Class.forName("org.sqlite.JDBC");
            dbCon = DriverManager.getConnection(dbURL);
            System.out.println("ok from select");


            Statement stmt = dbCon.createStatement();
            stmt.execute(ins);


        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();

        }
    }
    //единичное значение
    public String getAnswerMainAcc(String what, String where) {
        String req = "select " + what + " from main_acc where 1=1 " + where + ";";
        System.out.println(req);
        String a = null;
        try {
            //getting database connection to MySQL server
            Class.forName("org.sqlite.JDBC");
            dbCon = DriverManager.getConnection(dbURL);
            System.out.println("ok from select");


            Statement stmt = dbCon.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while (rs.next()) {
                a=  rs.getString(what);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return a;
    }






    public void getUpdateMainAcc(String what, String where, String set) {
        String upd = "UPDATE main_acc SET  " + what + " = '" + set + "' where 1=1 " + where + ";";
        System.out.println(upd);

        String a = null;
        try {
            //getting database connection to MySQL server
            Class.forName("org.sqlite.JDBC");
            dbCon = DriverManager.getConnection(dbURL);
            System.out.println("ok from select");
            Statement stmt = dbCon.createStatement();
            stmt.execute(upd);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
/*
    public void commit (){
        String upd = "commit;";
        System.out.println(upd);
        try {
            //getting database connection to MySQL server
            Class.forName("org.sqlite.JDBC");
            dbCon = DriverManager.getConnection(dbURL);
            System.out.println("ok from select");
            Statement stmt = dbCon.createStatement();
            stmt.execute(upd);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

 */


    public void getLog(String what, String where) {
        String req = "select " + what + " from log_data where 1=1 " + where + ";";
        System.out.println(req);
        try {
            //getting database connection to MySQL server
            Class.forName("org.sqlite.JDBC");
            dbCon = DriverManager.getConnection(dbURL);
            System.out.println("ok from select");


            Statement stmt = dbCon.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id") + " | time: "+ rs.getString("time") + " | who: " + rs.getString("who") + " | action: " + rs.getString("action") );
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();

        }
    }
    public void getLogCopy(String what, String where) {
        String req = "select " + what + " from log_data_copy where 1=1 " + where + ";";
        System.out.println(req);
        try {
            //getting database connection to MySQL server
            Class.forName("org.sqlite.JDBC");
            dbCon = DriverManager.getConnection(dbURL);
            System.out.println("ok from select");


            Statement stmt = dbCon.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while (rs.next()) {
                System.out.println("COPY|| id: " + rs.getInt("id") + " | time: "+ rs.getString("time") + " | who: " + rs.getString("who") + " | action: " + rs.getString("action") );
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();

        }
    }





}
