/*
  DMOPC '17 Contest 4 P0 - Catch
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Catch {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;

        for (int i = 0; i < 3; i++) {
            String[] ln = in.readLine().split(" ");
            if (i == 0) {
                a = Integer.parseInt(ln[0]);
                b = Integer.parseInt(ln[1]);
            } else if (i == 1) {
                c = Integer.parseInt(ln[0]);
                d = Integer.parseInt(ln[1]);
            } else {
                e = Integer.parseInt(ln[0]);
                f = Integer.parseInt(ln[1]);
            }
        }

        long min1 = Dist(a, b, c, d);
        long min2 = Dist(a, b, e, f);
        long min3 = Dist(c, d, e, f);

        System.out.println(min1 + " " + min2 + " " + min3);

        long D = Math.min(min1, Math.min(min2, min3));

        System.out.println(D);
    }

    public static long Dist(int a, int b, int c, int d) {
        return (long) (Math.pow((d - b), 2) + Math.pow((c - a), 2));
    }
}
