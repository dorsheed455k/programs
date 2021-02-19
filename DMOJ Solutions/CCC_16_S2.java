/* CCC '16 S2 -  Tandem Bicycle */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tandem_Bicycle {

    static int q, n;
    static int[] d_i, p_i;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        q = Integer.parseInt(in.readLine());
        n = Integer.parseInt(in.readLine());

        d_i = new int[n];
        p_i = new int[n];

        String[] l1 = in.readLine().split(" ");
        String[] l2 = in.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            d_i[i] = Integer.parseInt(l1[i]);
            p_i[i] = Integer.parseInt(l2[i]);
        }
        sort(d_i);
        sort(p_i);

        int total = 0;
        if (q == 2) {
            for (int i = 0; i < n; i++) {
               total += Math.max(d_i[n-i-1], p_i[i]);
            }
        } else {
            for (int i = 0; i < n; i++) {
                total += Math.max(d_i[n-i-1], p_i[n-i-1]);
            }
        }

        System.out.println(total);
    }

    public static void sort(int[] arr) {
        int tp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    tp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tp;
                }
            }
        }
    }
}
