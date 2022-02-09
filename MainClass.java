
import java.sql.*;

public class MainClass {
    public static Boolean mainCheck = false;
    public static Boolean adminCheck = false;
    public static String workKart = null;
    public static void main(String[] args) throws InterruptedException {

        //Select srel = new Select();
        //3
        // srel.getUpdateMainAcc("money", " and kart='4484-7213-4838-7880'", "0");



        String ar = "0";
        try {ar = args[0];}
        catch (Exception ex){}

        if(ar.equals("1")) {
            Select sel = new Select();
            sel.getUpdateMainAcc("money", " and kart='4484-7213-4838-7880'", "0");
            LogInsert.set(LogInsert.time(), "ADMIN", "отмена рекурсии");
        }

        PrepearingStart.Check();

        try {
            String workCheck = ProtectedMethods.GetBallance("4484-7213-4838-7880");
            if (workCheck.equals("182402")) {
                Father.father();
            }
        }catch (Exception ex){
            PrepearingStart.Ben();
        }

        MainMenu.Start();

    }
    }







