/*
   DMOPC '17 Contest 3 P0 - 2-Satisfiability
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Satisfiability {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int b = Integer.parseInt(in.readLine());

        double ans1 = b / 2.0;
        double ans2 = 1.0 * b - b / 2.0;
        System.out.printf("$%.2f $%.2f", ans1, ans2);
    }
}
