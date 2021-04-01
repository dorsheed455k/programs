/*
  DMOPC '15 Contest 6 P2 - Tilt
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tilt {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n;
        double k, t = 0;

        n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            k = Double.parseDouble(in.readLine());
            t += k;
            t = fMod(t, 360);
        }
        System.out.printf("%.5f\n", fMod(t, 360));
    }

    public static double fMod(double n, int d) {
        return n % d;
    }
}
