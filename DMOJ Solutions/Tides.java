/*
  DMOPC '14 Contest 8 P2 - Tides
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tides {

    static int[] a = new int[1010];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        String[] ln = in.readLine().split(" ");

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(ln[i]);
            min = Math.min(min, a[i]);
            max = Math.max(max, a[i]);
        }

        for (int i = 0; i < n; i++) {
            if (flag && i > 0 && a[i-1] >= a[i]) {
                System.out.println("unknown");
                return;
            }
            if (a[i] == min) {
                flag = true;
            } else if (a[i] == max) {
                if (i == 0) {
                    System.out.println("unknown");
                    return;
                }
                flag = false;
            }
        }
        System.out.println(max - min);
    }
}
