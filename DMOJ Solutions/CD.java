/*
   DMOPC '15 Contest 3 P2 - Cheesecake Distribution
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CD {
    static long[] arr;
    static long tmp = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        arr = new long[n];
        String[] ln = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(ln[i]);
            tmp += arr[i];
        }

        if (tmp % ln.length != 0) {
            System.out.println("Impossible");
        } else {
            long perfect = tmp / ln.length;
            long result = 0;
            for (int i = 0; i < ln.length; i++) {
                if (arr[i] > perfect) {
                    result += arr[i] - perfect;
                }
            }
            System.out.println(result);
        }
    }
}
