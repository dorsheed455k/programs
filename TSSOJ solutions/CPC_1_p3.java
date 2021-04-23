/*
  CPC 1 Problem 3 - Chika's Popularity Contest
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CPC {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());

        String[] arr = in.readLine().split(" ");

        int[] can = new int[t];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < arr.length; j++) {
                int x = Integer.parseInt(arr[j]);
                if (x == i+1) {
                    can[i] += 1;
                }
            }
        }

        for (int i = 0; i < t; i++) {
            System.out.println(can[i]);
        }
    }
}
