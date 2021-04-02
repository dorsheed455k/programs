/*
  DMOPC '17 Contest 2 P1 - 0-1 Knapsack
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 0-1_Knapsack {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        long[] v_i = new long[n];
        long[] c_i = new long[n];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            String[] ln = in.readLine().split(" ");
            v_i[i] = Long.parseLong(ln[1]);
            c_i[i] = Long.parseLong(ln[0]);

            if(v_i[i] > 0) {
                sum += c_i[i];
            }
        }
        System.out.println(sum);
    }
}
