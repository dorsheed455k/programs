/*
  CCC '21 S2 - Modern Art
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CCC_21_S2 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(in.readLine());
        int n = Integer.parseInt(in.readLine());
        int k = Integer.parseInt(in.readLine());

        int[] row = new int[m+1];
        int[] col = new int[n+1];
        for (int i = 0; i < k; i++) {
            char c;
            int j;
            String[] ln = in.readLine().split(" ");
            c = ln[0].charAt(0);
            j = Integer.parseInt(ln[1]);
            if (c == 'R') {
                row[j] ^= 1;
            } else {
                col[j] ^= 1;
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ans += row[i] ^ col[j];
            }
        }
        System.out.println(ans);
    }
}
