/*
  COCI '18 Contest 1 #1 Nadan
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Nadan {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int k = Integer.parseInt(in.readLine());

        for (int i = 1; i < k; i++) {
            System.out.println(i);
            n -= i;
        }
        System.out.println(n);
    }
}
