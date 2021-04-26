/*
   A Subtracting Problem
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ASP {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        for (int i = 0; i < n; i++) {
            String[] ln = in.readLine().split(" ");
            int a = Integer.parseInt(ln[0]);
            int b = Integer.parseInt(ln[1]);

            if (a < b) {
                System.out.println(a-b);
            } else {
                System.out.println(b - a);
            }
        }
    }
}
