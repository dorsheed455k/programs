/*
   DMOPC '18 Contest 1 P0 - Sorting 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortingP0 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[3];


        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        if (isSorted(arr)) {
            System.out.println("Good job!");
        } else {
            System.out.println("Try again!");
        }
    }

    public static boolean isSorted(int[] arr) {

        for (int i = 1; i < 3; i++) {
            if (arr[i-1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}
