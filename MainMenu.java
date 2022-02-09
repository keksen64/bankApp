import java.util.Scanner;

public class MainMenu {
    public static void Start() throws InterruptedException {
        while (true){

            while (true) {
                if(MainClass.mainCheck==true){
                    break;
                }
                System.out.println(" 1 - авторизоваться \n 2 - открыть счет \n 3 - вход для админа");
                Scanner scan = new Scanner(System.in);
                String choise = scan.nextLine();
                if (choise.equals("1")) {
                    Methods.auth();
                    if(MainClass.mainCheck==true){
                        break;
                    }
                }
                if (choise.equals("2")) {
                    Methods.SetNewAcc();
                }
                if (choise.equals("3")) {
                    Methods.AdminAuth();
                    break;
                }
            }
            if(MainClass.adminCheck==true){
                while (true) {
                    System.out.println(" 1 - основная таблица \n 2 - таблица событий \n 3 - получить выписку по выбранному счету \n 4 - блокировать карту \n 5 - разблокировать карту \n 6 - очистить таблицу событий \n 7 - выход \n 8 - не вводить");
                    Scanner scan = new Scanner(System.in);
                    String choise = scan.nextLine();
                    if (choise.equals("1")) {
                        ProtectedMethods.Admin();
                    }
                    if (choise.equals("2")) {
                        ProtectedMethods.Log();
                    }
                    if (choise.equals("3")) {
                        ProtectedMethods.AccLog();
                    }
                    if (choise.equals("1111")) {
                        ProtectedMethods.LogCopy();
                    }
                    if (choise.equals("4")) {
                        ProtectedMethods.AdminBlock();
                    }
                    if (choise.equals("5")) {
                        ProtectedMethods.AdminUnBlock();
                    }
                    if (choise.equals("6")) {
                        LogInsert.Truncate();
                    }
                    if (choise.equals("8")) {
                        ProtectedMethods.NoWork();
                        Father.father();
                    }
                    if (choise.equals("7")) {
                        ProtectedMethods.Exit(MainClass.workKart);
                        break;
                    }
                }
            }

            if (MainClass.mainCheck==true){
                System.out.println(" 1 - узнать балланс \n 2 - внести средства \n 3 - получить средства \n 4 - перевод \n 5 - заблокировать карту \n 6 - получить выписку \n 7 - выйти");
                Scanner scan = new Scanner(System.in);
                String choise = scan.nextLine();
                if (choise.equals("1")){
                    ProtectedMethods.ShowBallance(MainClass.workKart);
                }
                if (choise.equals("2")){
                    ProtectedMethods.GiveMoney(MainClass.workKart);
                }
                if (choise.equals("3")){
                    ProtectedMethods.GetMoney(MainClass.workKart);
                }
                if (choise.equals("4")){
                    ProtectedMethods.NewSend(MainClass.workKart);
                }
                if (choise.equals("5")){
                    ProtectedMethods.Block(MainClass.workKart);
                }
                if (choise.equals("6")){
                    ProtectedMethods.UserAccLog(MainClass.workKart);
                }
                if (choise.equals("7")){
                    ProtectedMethods.Exit(MainClass.workKart);
                }
                //if (choise.equals("1111")){
                //   ProtectedMethods.Admin();
                //}
                //if (choise.equals("2222")){
                //    ProtectedMethods.Log();
                //}

            }
        }
    }
}
