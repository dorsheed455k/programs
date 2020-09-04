import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Natrij {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] t1 = in.readLine().split(":");
        String[] t2 = in.readLine().split(":");

        int h1 = Integer.parseInt(t1[0]);
        int m1 = Integer.parseInt(t1[1]);
        int s1 = Integer.parseInt(t1[2]);


        int h2 = Integer.parseInt(t2[0]);
        int m2 = Integer.parseInt(t2[1]);
        int s2 = Integer.parseInt(t2[2]);

        System.out.println(cal_TimeDiff(h1, m1, s1, h2, m2, s2));

    }

    public static String cal_TimeDiff(int h1, int m1, int s1, int h2, int m2, int s2) {
        int sdiff, mdiff, hdiff;

        hdiff =  h2 - h1;
        mdiff =  m2 - m1;
        sdiff =  s2 - s1;

        if(sdiff < 0) {
            sdiff += 60;
            mdiff--;
        }

        if(mdiff < 0) {
            mdiff += 60;
            hdiff--;
        }

        if(hdiff < 0) {
            hdiff += 24;
        }

        if(hdiff == 0 && mdiff == 0 && sdiff == 0) {
            hdiff = 24;
        }

        String line = (hdiff < 10? "0" + hdiff : hdiff) + ":" + (mdiff < 10? "0" + mdiff : mdiff) + ":" + (sdiff < 10? "0" + sdiff : sdiff);
        return line;
    }
}
