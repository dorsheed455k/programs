/*
    CCC_21_J2 - Silent_Auction
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silent_Auction {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        
        int max = Integer.MIN_VALUE;
        String winner = "";

        while (n-- > 0) {
            String s = in.readLine();
            int p = Integer.parseInt(in.readLine());

            if(p > max) {
                max = p;
                winner = s;
            }
        }

        System.out.println(winner);
    }
}
