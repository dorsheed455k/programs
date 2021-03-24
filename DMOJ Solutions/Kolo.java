/*
  COCI '10 Contest 7 #2 Kolo
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kolo {

    static int n, k;
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] l1 = in.readLine().split(" ");
        n = Integer.parseInt(l1[0]);
        k = Integer.parseInt(l1[1]);

        char[] a = new char[n];
        for (int i = 0; i < n; i++) a[i] = '?';

        int x = 0;
        while (k-- > 0) {
            char c; int s;
            String[] l2 = in.readLine().split(" ");
            s = Integer.parseInt(l2[0]);
            c = l2[1].charAt(0);
            while (s-- > 0) {
                x++;
              if (x == n) x = 0;
            }
            if (a[x] != '?' && a[x] != c) {
                System.out.println("!");
                return;
            }
            a[x] = c;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (a[i] == a[j] && a[i] != '?') {
                    System.out.println("!");
                    return;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[x]);
            x--;
            if (x == -1) x = n-1;
        }
        System.out.println();
    }
}
