/*
  Range_Sum_Queries.java
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RSQ {

    static int n, q;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        arr = new int[n];
        String[] ln = in.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(ln[i]);
        }

        q = Integer.parseInt(in.readLine());

        for (int i = 0; i < q; i++) {
            ln = in.readLine().split(" ");
            int a = Integer.parseInt(ln[0]) - 1;
            int b = Integer.parseInt(ln[1]) - 1;
            int sum = 0;
            for (int j = a; j <= b ; j++) {
                sum += arr[j];
            }
            System.out.println(sum);
        }
    }
}
