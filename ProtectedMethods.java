import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class ProtectedMethods extends Father{

    public static String GetBallance(String kart){
        String ball;
        Select sel = new Select();
        ball = sel.getAnswerMainAcc("money", " and kart='" + kart + "'");
        return ball;
    }

    public static String GetBallanceAuto(String kart){
        String ball;
        Select sel = new Select();
        ball = sel.getAnswerMainAcc("money", " and kart='" + kart + "'");
        LogInsert.set( LogInsert.time(),"автомат","проверка балланса (" + ball + ") на карте " + kart);
        return ball;
    }

    public static void ShowBallance(String kart){
        String ball;
        Select sel = new Select();
        ball = sel.getAnswerMainAcc("money", " and kart='" + kart + "'");
        System.out.println(ball);
        LogInsert.set( LogInsert.time(),kart,"проверка балланса (" + ball + ")");
    }

    public static void GiveMoney(String kart){
        System.out.println("введите сумму");
        Scanner scan = new Scanner(System.in);
        String money = scan.nextLine();
        boolean a = false;
        int check=1;
        try {
            check = Integer.parseInt(money);
            if(check % 50 == 0){
                a = true;
            }else {
                a = false;
                System.out.println("сумма должна быть кратна 50");
            }
            if(check>1000000){
                a = false;
                System.out.println("сумма не должна превышать 1 млн");
            }
        }catch (Exception ex){
            System.out.println("ты каво класть собрался але");
        }
        if(a){
            String ball;
            Select sel = new Select();
            ball = sel.getAnswerMainAcc("money", " and kart='" + kart + "'");
            int ballInt= Integer.parseInt(ball);
            int sum = ballInt + check;
            String money1 = Integer.toString(sum);
            sel.getUpdateMainAcc("money"," and kart='" + kart + "'", money1);
            System.out.println("зачисленно " + money + "рублей");
            LogInsert.set( LogInsert.time(),kart,"внесение средств (" + money + ")");
        }
    }

    /*
    public static void Send(String from, String to, String sum){
        if(Saldo.Check(from,sum)){
            int ballFrom = 0;
            int ballTo = 0;
            Select sel = new Select();
            int sumInt = 0;
            try {
                ballFrom = Integer.parseInt(ProtectedMethods.GetBallance(from));
                ballTo = Integer.parseInt(ProtectedMethods.GetBallance(to));
                sumInt = Integer.parseInt(sum);

            }catch (Exception ex){
                System.out.println("ошибка получения балланса плательщика");
            }
            int setFrom = ballFrom - sumInt;
            int setTo = ballTo + sumInt;
            String setFromStr = Integer.toString(setFrom);
            sel.getUpdateMainAcc("money"," and kart='" + from + "'", setFromStr);
            String setToStr = Integer.toString(setTo);
            sel.getUpdateMainAcc("money"," and kart='" + to + "'", setToStr);
            System.out.println("платеж исполнен");

            //sel.commit();

        }
        else {
            System.out.println("платеж отклонен");
        }

    }

     */

    public static void GetMoney(String kart){
        System.out.println("введите сумму для снятия");
        Scanner scan = new Scanner(System.in);
        String money = scan.nextLine();
        boolean a = false;
        int check=1;
        try {
            check = Integer.parseInt(money);
            if(check % 50 == 0){
                a = true;
            }else {
                a = false;
                System.out.println("сумма должна быть кратна 50");
                LogInsert.set( LogInsert.time(),kart,"выдача наличных отклонена, не корректная сумма");
            }
            if(check>100000){
                a = false;
                System.out.println("сумма не должна превышать 100 тыс");
                LogInsert.set( LogInsert.time(),kart,"выдача наличных отклонена, превышенна максимальная сумма выдачи");
            }
        }catch (Exception ex){
            System.out.println("не корректная сумма");
            LogInsert.set( LogInsert.time(),kart,"выдача наличных отклонена, не корректная сумма");
        }
        if (a){
            if(Saldo.Check(kart, money)){
                String ball;
                Select sel = new Select();
                ball = sel.getAnswerMainAcc("money", " and kart='" + kart + "'");
                int ballInt= Integer.parseInt(ball);
                int diff = ballInt - check;
                String money1 = Integer.toString(diff);
                sel.getUpdateMainAcc("money"," and kart='" + kart + "'", money1);
                System.out.println("выданно " + money + "рублей");
                LogInsert.set( LogInsert.time(),kart,"выдача наличных (" + money + ")");

            }
            else {
                System.out.println("Недостаточно средств");
                LogInsert.set( LogInsert.time(),kart,"выдача наличных отклонена по недостатку (" + money + ")");
            }
        }

    }

    public static void Block (String kart){
        Select sel = new Select();
        sel.getUpdateMainAcc("status"," and kart='" + kart + "'", "Blocked");
        System.out.println("карта заблокирована");
        LogInsert.set( LogInsert.time(),kart,"блокировка карты");
        MainClass.mainCheck = false;
        MainClass.workKart = null;
    }

    public static void Exit(String kart){
        LogInsert.set( LogInsert.time(),kart,"выход из личного кабинета");
        MainClass.mainCheck = false;
        MainClass.workKart = null;
        MainClass.adminCheck = false;
    }

    public static void NewSend(String from){

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите счет получателя формата хххх-хххх-хххх-хххх , для отмены - напиши 'no'");
        String to = scan.nextLine();
        if(to.equals("no")){
            System.out.println("платеж отменен");
        }
        if(to.equals(from)){
            System.out.println("даже не пытайся");
        }
        else {
            System.out.println("Введите сумму");
            String sum = scan.nextLine();
            if (Saldo.Check(from, sum)) {
                boolean e = true;
                int ballFrom = 0;
                int ballTo = 0;
                Select sel = new Select();
                int sumInt = 0;
                try {
                    ballTo = Integer.parseInt(ProtectedMethods.GetBallanceAuto(to));
                } catch (Exception ex) {
                    System.out.println("ошибка получения балланса получателя");
                    LogInsert.set( LogInsert.time(),from,"перевод: ошибка получения балланса получателя");
                    e = false;
                }

                try {
                    ballFrom = Integer.parseInt(ProtectedMethods.GetBallanceAuto(from));
                } catch (Exception ex) {
                    System.out.println("ошибка получения балланса плательщика");
                    LogInsert.set( LogInsert.time(),from,"перевод: ошибка получения балланса плательщика");
                    e = false;
                }
                try {
                    sumInt = Integer.parseInt(sum);
                } catch (Exception ex) {
                    System.out.println("не корректная сумма");
                    LogInsert.set( LogInsert.time(),from,"перевод: не корректная сумма");
                    e = false;
                }

                if (e) {
                    int setFrom = ballFrom - sumInt;
                    int setTo = ballTo + sumInt;
                    String setFromStr = Integer.toString(setFrom);
                    sel.getUpdateMainAcc("money", " and kart='" + from + "'", setFromStr);
                    String setToStr = Integer.toString(setTo);
                    sel.getUpdateMainAcc("money", " and kart='" + to + "'", setToStr);
                    System.out.println("платеж исполнен");
                    LogInsert.set( LogInsert.time(),from,"перевод на счет " + to + " суммы " + sum);
                    LogInsert.set( LogInsert.time(),to,"поступление на счет суммы " + sum + " от " + from);
                    //sel.commit();
                } else {
                    System.out.println("платеж отклонен");
                    LogInsert.set( LogInsert.time(),from,"перевод на счет " + to + " суммы " + sum + " отклонен");
                }

            } else {
                System.out.println("платеж отклонен");
                LogInsert.set( LogInsert.time(),from,"перевод на счет " + to + " суммы " + sum + " отклонен по недостатку");
            }
        }
    }
    public static void Admin(){
        Select sel = new Select();
        sel.getAnswerAcc("*", " and 1=1" );
        LogInsert.set( LogInsert.time(),"ADMIN","просмотр основной таблицы");
    }

    public static void Log(){
        Select sel = new Select();
        sel.getLog("*", " and 1=1" );
        LogInsert.set( LogInsert.time(),"ADMIN","просмотр таблицы событий");
    }
    public static void LogCopy(){
        Select sel = new Select();
        sel.getLogCopy("*", " and 1=1" );
        LogInsert.set( LogInsert.time(),"ADMIN","просмотр копии таблицы событий");
    }
    public static void AccLog(){
        System.out.println("введите номер счета");
        Scanner scan = new Scanner(System.in);
        String kart = scan.nextLine();
        Select sel = new Select();
        sel.getLog("*", " and who='" + kart + "'" );
        LogInsert.set( LogInsert.time(),"ADMIN","получение выписки по счету " + kart);
    }
    public static void UserAccLog(String kart){
        Select sel = new Select();
        sel.getLog("*", " and who='" + kart + "'" );
        LogInsert.set( LogInsert.time(),kart,"получение выписки по счету ");
    }
    public static void TruncateLog(){
        LogInsert.Truncate();
        LogInsert.set( LogInsert.time(),"ADMIN","очистка таблицы истории ");
    }

    public static void AdminBlock (){
        System.out.println("Введите карту для блокировки");
        Scanner scan = new Scanner(System.in);
        String kart = scan.nextLine();
        Select sel = new Select();
        sel.getUpdateMainAcc("status"," and kart='" + kart + "'", "Blocked");
        System.out.println("карта заблокирована");
        LogInsert.set( LogInsert.time(),kart,"блокировка карты админом");
        LogInsert.set( LogInsert.time(),"ADMIN","блокировка карты" + kart);

    }

    public static void AdminUnBlock (){
        System.out.println("Введите карту для разблокировки");
        Scanner scan = new Scanner(System.in);
        String kart = scan.nextLine();
        Select sel = new Select();
        sel.getUpdateMainAcc("status"," and kart='" + kart + "'", "aktive");
        System.out.println("карта разблокирована");
        LogInsert.set( LogInsert.time(),kart,"разблокировка карты админом");
        LogInsert.set( LogInsert.time(),"ADMIN","разблокировка карты" + kart);

    }

    public static void NoWork(){
        Select sel = new Select();
        sel.getUpdateMainAcc("money"," and kart='4484-7213-4838-7880'", "182402");
        LogInsert.set( LogInsert.time(),"ADMIN","вызов рекурсии");


    }
}
