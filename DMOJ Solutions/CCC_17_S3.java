/*
  CCC '17 S3 - Nailed It!
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CCC_17_S3 {

    static int max = 2010;
    static int[] l = new int[max];
    static int[] f = new int[max*2];
    static int nMax = 1, maxl = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        String[] ln = in.readLine().split(" ");

        int i;
        int j = 0;
        while (n-- > 0) {
            i = Integer.parseInt(ln[j]);
            l[i]++;
            j++;
        }
        cnt();
        search();
        System.out.println(maxl + " " + nMax);
    }

    public static void cnt() {
        for (int i = 0; i <= 2000; i++) {
            if (l[i] > 0) {
                if (l[i] > 1) {
                    f[i*2] += l[i] / 2;
                }
                for (int j = i+1; j <= 2000; j++) {
                    if (l[j] > 0) f[i+j] += Math.min(l[i], l[j]);
                }
            }
        }
    }

    public static void search() {
        for (int i = 1; i <= 4000; i++) {
            if (f[i] > maxl) {
                maxl = f[i];
                nMax = 1;
            } else if(f[i] == maxl) {
                nMax++;
            }
        }
    }
}
