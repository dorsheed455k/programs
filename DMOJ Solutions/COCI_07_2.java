/*
  COCI '07 Contest 2 #1 - Bijele
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[6];
        int[] n = {1, 1, 2, 2, 2, 8};

        String[] line = in.readLine().split(" ");

        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(line[i]);
            System.out.print(n[i] - arr[i] + " ");
        }


    }
}
