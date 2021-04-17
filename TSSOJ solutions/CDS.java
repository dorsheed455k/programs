/*
  Continuous Digits Sum
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CDS {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] s = in.readLine().split("");

        while (true) {
            int sum = digitGame(s);
            if (sum >= 0 && sum <= 9) {
                System.out.println(sum);
                break;
            } else {
                s = String.valueOf(sum).split("");
            }
        }
    }

    public static int digitGame(String[] s) {
        int sum = 0;
        for (int i = 0; i < s.length; i++) {
            sum += Integer.parseInt(s[i]);
        }

        return sum;
    }
}
