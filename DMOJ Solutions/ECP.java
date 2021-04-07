/*
  DMOPC '17 Contest 3 P1 - An Early Christmas Present 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ECP {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        String[] ln = in.readLine().split(" ");

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(ln[i]);

            if (x < min) {
                min = x;
            }
        }
        System.out.println(min);
    }
}
