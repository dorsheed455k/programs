/*
  COCI '06 Contest 1 #1 - Modulo
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> arr = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(in.readLine());
            if(!arr.contains((n %42))) {
                arr.add(n %42);
                count++;
            }
        }

        System.out.println(count);

    }
}
