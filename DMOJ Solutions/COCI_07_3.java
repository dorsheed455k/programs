/*
  COCI '07 Contest 3 #3 - Tajna 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s = in.readLine();

        System.out.println(decrypt(s));

    }

    public static String decrypt(String s) {
        int rr, ss, R, S;
        int n = s.length();
        StringBuilder str = new StringBuilder();

        R = 1;
        for (rr = 1; rr <= n; rr++) {
            ss = n / rr;
            if(rr <= ss && rr * ss == n)
                R = rr;
        }
        S = n / R;

        for (rr = 0; rr < R; rr++) {
            for (ss = 0; ss < S; ss++) {
                str.append(s.charAt(ss*R+rr));
            }
        }
        return str.toString();
    }
}
