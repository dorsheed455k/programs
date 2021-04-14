/*
  DMOPC '18 Contest 4 P1 - Dr. Henri and Differential Photometry
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Henri_DP {

    static int[] n_i = new int[1001];
    static double[] d_i = new double[1001];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(in.readLine());
        double m = Double.parseDouble(in.readLine());

        double res, ans = 0;
        String[] ln;
        for (int i = 0; i < k; i++) {
            ln = in.readLine().split(" ");
            n_i[i] = Integer.parseInt(ln[0]);
            res = m;
            for (int j = 1; j < ln.length; j++) {
                d_i[j-1] = Double.parseDouble(ln[j]);
                res += d_i[j-1];
            }
            ans += res;
        }
        ans = 1.0 * ans / k;
        System.out.printf("%.3f", ans);
    }
}
