public class Saldo {

    public static boolean Check(String kart, String sum){
        boolean answer = false;
        boolean tr = false;
        int check = 1;
        int ballCheck = 0;
        String ball = "0";
        Select sel = new Select();
        ball = sel.getAnswerMainAcc("money", " and kart='" + kart + "'");

        try {
            check = Integer.parseInt(sum);
            ballCheck = Integer.parseInt(ball);
            tr = true;
        }
        catch (Exception ex){
            System.out.println("ошибка получения балланса");
        }
        if (tr){
            if(check<=ballCheck){
                answer = true;
            }
        }
        else {
            System.out.println("Средств недостаточно");
        }

        return answer;
    }
}
