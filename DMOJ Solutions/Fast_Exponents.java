/*
  DMOPC '16 Contest 4 P1 - Fast Exponents
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fast_Exponent {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        for (int i = 0; i < n; i++) {
            long t = Long.parseLong(in.readLine());
            if (isPower(t)) {
                System.out.println("T");
            } else {
                System.out.println("F");
            }
        }
    }

    public static boolean isPower(long x) {
        return (x & (x - 1)) == 0;
    }
}
