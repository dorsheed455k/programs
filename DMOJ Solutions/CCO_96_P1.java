/*
  CCO'96 P1 - Train Swapping
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        while (n-- > 0) {
            int l = Integer.parseInt(in.readLine());

            int[] arr = new int[l];
            String[] str = in.readLine().split(" ");

            for (int i = 0; i < l; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            int swaps = numSwaps(arr);

            System.out.println("Optimal train swapping takes " + swaps + " swaps.");
        }
    }

    public static int numSwaps(int[] arr) {
        int swaps = 0;
        int temp;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swaps++;
                }
            }
        }
        return swaps;
    }
}
