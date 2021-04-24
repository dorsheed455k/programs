/*
   A Binary Problem 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ABP {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        String[] ln = in.readLine().split(" ");

        int count = 0;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(ln[i]);
            count += x == 1? 1 : 0;
        }


        System.out.println(count % 2 == 0? "0" : "1");
    }
}
