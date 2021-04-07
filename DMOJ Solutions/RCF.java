/*
   DMOPC '17 Contest 4 P1 - Ribbon Colouring Fun
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RCF {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n, q, x, y;
        long sum = 0, b = 0;
        int[] diff = new int[100010];

        String[] ln = in.readLine().split(" ");

        n = Integer.parseInt(ln[0]);
        q = Integer.parseInt(ln[1]);


        for (int i = 0; i < q; i++) {
          ln = in.readLine().split(" ");
          x = Integer.parseInt(ln[0]);
          y = Integer.parseInt(ln[1]);
          diff[x]++; diff[y]--;
        }

        for (int i = 0; i <= n; i++) {
            sum += diff[i];
            b += sum > 0? 1 : 0;
        }
        System.out.println((n-b) + " " + b);
    }
}
