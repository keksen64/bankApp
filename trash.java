public class trash /*

    Connection dbCon = null;
    String req = "select * from testTable;";
    String sql ="create table testTable (id integer, name text);";
    String ins ="INSERT INTO testTable(id,name) VALUES(?,?)";

    try {
        //getting database connection to MySQL server
        Class.forName("org.sqlite.JDBC");
        dbCon = DriverManager.getConnection(dbURL);
        System.out.println("ok");


        Statement stmt = dbCon.createStatement();
        stmt.execute("CREATE TABLE if not exists 'main_acc' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'surname' text, 'passport' text not null, 'kart' text not null, 'passw' text not null, 'money' integer, 'status' text not null);");


        //PreparedStatement pstmt = dbCon.prepareStatement(ins);
        //pstmt.setInt(1, 1);
        //pstmt.setString(2, "capacity");
        //pstmt.executeUpdate();
        //System.out.println("es");

    } catch (SQLException | ClassNotFoundException ex) {
        ex.printStackTrace();

    }























/*String from = "main_acc ( time, who, action)";
        String ins ="INSERT INTO log_data( time, who, action) VALUES( '00:00', 'ee', 'test')";
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

         */
/*
        try {
            //getting database connection to MySQL server
            Class.forName("org.sqlite.JDBC");
            dbCon = DriverManager.getConnection(dbURL);
            System.out.println("ok");


            Statement stmt = dbCon.createStatement();
            stmt.execute("CREATE TABLE if not exists 'log_data' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'time' text, 'who' text, 'action' text);");


            //PreparedStatement pstmt = dbCon.prepareStatement(ins);
            //pstmt.setInt(1, 1);
            //pstmt.setString(2, "capacity");
            //pstmt.executeUpdate();
            //System.out.println("es");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();

        }

        try {
            //getting database connection to MySQL server
            Class.forName("org.sqlite.JDBC");
            dbCon = DriverManager.getConnection(dbURL);
            System.out.println("ok");


            Statement stmt = dbCon.createStatement();
            stmt.execute("CREATE TABLE if not exists 'log_data_copy' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'time' text, 'who' text, 'action' text);");


            //PreparedStatement pstmt = dbCon.prepareStatement(ins);
            //pstmt.setInt(1, 1);
            //pstmt.setString(2, "capacity");
            //pstmt.executeUpdate();
            //System.out.println("es");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();

        }
*/

        //sel.getUpdate("keke","testTable",2);
        //sel.getAnswerAcc("*", " and 1=1" );
        //sel.getInsertAcc();
        //Methods.SetNewAcc();
        //if (Methods.auth()){
        //    System.out.println("Выполнен вход");
        //}else {
        //    System.out.println("Вход не выполнен");
        //}

        //Methods.SetNewAcc();
        //ProtectedMethods.GiveMoney("0000-0000-0000-0000");
        //ProtectedMethods.Send("0000-0000-0000-0000", "1111-1111-1111-1111", "1");
        //ProtectedMethods.GetMoney("0000-0000-0000-0000");
        //boolean a = Methods.auth();
        //System.out.println(a);

        //System.out.println(ProtectedMethods.GetBallance("0000-0000-0000-0000"));
        //System.out.println(ProtectedMethods.GetBallance("1111-1111-1111-1111"));

        //System.out.println(System.currentTimeMillis());

        //sel.getAnswerAcc("*", " and 1=1" );

        //

 {
}
