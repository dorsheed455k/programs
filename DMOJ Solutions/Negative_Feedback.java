/*
   DMOPC '16 Contest 3 P0 - Negative Feedback
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Negative_Feedback {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        double vIn, rF, rG;

        String[] ln = in.readLine().split(" ");

        vIn = Integer.parseInt(ln[0]);
        rF = Integer.parseInt(ln[1]);
        rG = Integer.parseInt(ln[2]);

        double vOut = vIn * (1 + (rF/rG));

        System.out.printf("%.2f", vOut);
    }
}
