/*
   COCI '09 Contest 1 #1 - Note
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[8];

        String[] line = in.readLine().split(" ");

        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        System.out.println(order(arr));
    }

    public static String order(int[] arr) {
       int a = 0;
       int d = 0;

        for (int i = 1; i < 8; i++) {
            if(arr[i] > arr[i-1]) {
                a++;
            } else if(arr[i] < arr[i-1]) {
                d++;
            }
        }
        
        if(a == arr.length-1) {
            return "ascending";
        } else if(d == arr.length-1) {
            return "descending";
        } else {
            return "mixed";
        }
    }
}
