/*
  COCI '11 Contest 1 #2 Matrix
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Matrix {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] ln = in.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                m[i][j] = Integer.parseInt(ln[j]);
            }
        }

        int best = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int a = m[i][j];
                int b = m[i][j];
                for (int k = 1; ; k++) {
                    if (i - k < 0 || j - k < 0 || i + k >= n || j + k >= n) break;
                    a += m[i-k][j-k] + m[i+k][j+k];
                    b += m[i-k][j+k] + m[i+k][j-k];
                    best = Math.max(best, a - b);
                }
            }

        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - 1; j++) {
                int a = 0, b = 0;
                int r1 = i, r2 = i + 1;
                int s1 = j, s2 = j + 1;
                for (int k = 1; ; k++) {
                    a += m[r1][s1] + m[r2][s2];
                    b += m[r1][s2] + m[r2][s1];
                    best = Math.max(best, a - b);
                    r1--; s1--; r2++; s2++;
                    if (r1 < 0 || s1 < 0 || r2 >= n || s2 >= n) break;
                }
            }

        System.out.println(best);
    }
}
