import java.util.Scanner;

public class Methods {




    // MAKE NEW KART
    public static void SetNewAcc(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите имя");
        String name = scan.nextLine();
        System.out.println("Введите фамилию");
        String surname = scan.nextLine();
        System.out.println("Введите серию и номер паспорта без пробела");
        String passport = scan.nextLine();

        String passw = null;
        boolean a = true;
        while (a){
            System.out.println("придумайте четырехзначный пинкод");
            passw = scan.nextLine();
            try {
                int check = Integer.parseInt(passw);
                if((check >= 1000 && check <= 9999)|| passw.equals("0000")){
                    a = false;
                }else {
                    System.out.println("Введите четырехзначное число");
                }
            }catch (Exception ex){
                System.out.println("Пароль должен состоять из цифр");
            }
        }

        String kart = Generator.Kart();
        String status = "aktive";
        String money = "0";

        System.out.println("номер вашей карты: " + kart);
        System.out.println("Ваш пароль: " + passw);
    Select sel = new Select();
    sel.getInsertAcc(name, surname, passport, kart, passw, money, status);
        LogInsert.set( LogInsert.time(),kart,"регистрация нового счета");
    }




    //AUTHENTIFICATION
    public static boolean auth(){
        Scanner scan= new Scanner(System.in);
        String passwStandart = null;
        String kart = null;
        boolean a = true;
        boolean re = false;
        boolean k = true;

        for (int count = 3; count>0; count--){
            if(k) {
                System.out.println("введите номер карты формата хххх-хххх-хххх-хххх");
                kart = scan.nextLine();
            }

            Select sel = new Select();
            passwStandart = sel.getAnswerMainAcc("passw", " and kart='" + kart + "'");

            if (passwStandart == null){
                System.out.println("карта не найдена");
                return re;
            }else{
                k = false;
            }
            if (IsBlocked.Check(kart)){
                System.out.println("карта активна");
            } else {
                System.out.println("Карта заблокирована");
                LogInsert.set( LogInsert.time(),kart,"попытка входа в заблокированный счет");
                return re;
            }

            System.out.println("введите pin, для отмены ввести единицу");
            LogInsert.set( LogInsert.time(),kart,"попытка входа в личный кабинет");
            String passw = scan.nextLine();
            if(passw.equals("1")){
                return re;
            }
            if (passwStandart.equals(passw)){
                MainClass.mainCheck = true;
                MainClass.workKart = kart;
                LogInsert.set( LogInsert.time(),kart,"вход в личный кабинет");
                System.out.println("Выполнен вход");
                System.out.println(passwStandart);
                re = true;
                break;
            }else {
                System.out.println("Пин не верный, осталось "+ (count-1) + "попытки");
                LogInsert.set( LogInsert.time(),kart,"попытка входа с неверным кодом");
            }
        }
        if (re==false){

            Select sel = new Select();
            sel.getUpdateMainAcc("status"," and kart='" + kart + "'", "Blocked");
            System.out.println("карта заблокирована");  //realizovat insert s izmeneniem statusa
            LogInsert.set( LogInsert.time(),kart,"блокировка карты после трех неверных попыток");
        }
        System.out.println(re);
        return re;
    }


public static void AdminAuth(){
    System.out.println("введите пароль");
    Scanner scan = new Scanner(System.in);
    String pass = scan.nextLine();
    if(pass.equals("admin")){
        MainClass.adminCheck = true;
        MainClass.workKart = "ADMIN";
        System.out.println("выполнен вход");
        LogInsert.set( LogInsert.time(),"ADMIN","выполнен вход");
    }
    else {
        System.out.println("пароль не верный");
        LogInsert.set( LogInsert.time(),"ADMIN","вход: не верный пароль");
    }
}







}
