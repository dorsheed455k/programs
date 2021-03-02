/*
   COCI '15 Contest 1 #3 Baloni
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baloni {

    static int max = 100000;
    static int[] c_i = new int[max];
    static int[] m = new int[max];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        String[] ln = in.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            c_i[i] = Integer.parseInt(ln[i-1]);
        }

        int resp = 0;
        for (int i = 1; i <= n; i++) {
            if (m[c_i[i]] == 0) {
                resp++;
                m[c_i[i]-1]++;
            } else {
                m[c_i[i]]--;
                m[c_i[i]-1]++;
            }
        }
        System.out.println(resp);
    }
}
