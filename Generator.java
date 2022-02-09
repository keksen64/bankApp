import java.util.Random;

public class Generator {
    public static String Kart(){
        String re = null;
        Random ran1 = new Random(System.currentTimeMillis()+23);
        int i1 = ran1.nextInt(8999)+1000;
        String s1 = Integer.toString(i1);
        Random ran2 = new Random(System.currentTimeMillis()+54);
        int i2 = ran2.nextInt(8999)+1000;
        String s2 = Integer.toString(i2);
        Random ran3 = new Random(System.currentTimeMillis()+32);
        int i3 = ran3.nextInt(8999)+1000;
        String s3 = Integer.toString(i3);
        Random ran4 = new Random(System.currentTimeMillis()+22);
        int i4 = ran4.nextInt(8999)+1000;
        String s4 = Integer.toString(i4);

        re=s1 + "-" + s2 + "-" + s3 + "-" + s4;

        return re;
    }
}
