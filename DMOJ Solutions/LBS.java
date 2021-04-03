/*
   DMOPC '16 Contest 3 P1 - Leading Basic Shots
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LBS {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(in.readLine());
        String s = in.readLine();
        int n2 = Integer.parseInt(in.readLine());

        if (s.equals("Infront")) {
            System.out.println(n1 - n2);
        } else if(s.equals("Behind")) {
            System.out.println(n1 + n2);
        }
    }
}
