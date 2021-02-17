/* Double Knockout Competition */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DKC {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int t;
        for (int i = 0; i < n; i++) {
            t = Integer.parseInt(in.readLine());
            int rn = 0, ol = 0, el = 0;

            System.out.println("Round " + rn + ": " + t + " undefeated, " + ol + " one-loss, " + el + " eliminated");
            rn++;
            while (t >= 2 || ol >= 2) {
                el += ol/2;
                ol -= ol/2;
                ol += t/2;
                t -= t/2;
                System.out.println("Round " + rn + ": " + t + " undefeated, " + ol + " one-loss, " + el + " eliminated");
                rn++;
            }
            if(t == 1 && ol == 1) {
                t = 0;
                ol++;
                System.out.println("Round " + rn + ": " + t + " undefeated, " + ol + " one-loss, " + el + " eliminated");
                rn++;
                ol--;
                el++;
                System.out.println("Round " + rn + ": " + t + " undefeated, " + ol + " one-loss, " + el + " eliminated");
            }
            System.out.println("There are " + rn + " rounds" );
        }
    }
}
