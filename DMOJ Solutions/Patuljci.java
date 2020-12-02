/*
  COCI '06 Contest 3 #1 - Patuljci
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        int[] dwarfs = list(arr);

        for (int i = 0; i < 9; i++) {
            if(dwarfs[i] == 0) {
                continue;
            }
            System.out.println(dwarfs[i]);
        }
    }

    public static int[] list(int[] arr) {
        int sum = 0;
        int[] dwarves = new int[9];
        for (int i = 0; i < 9; i++) {
            sum += arr[i];
        }

        int diff = sum - 100;
        int a = 0, b = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if(arr[i] + arr[j] == diff) {
                    a = arr[i];
                    b = arr[j];
                    break;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if(arr[i] != a && arr[i] != b) {
                dwarves[i] = arr[i];
            }
        }
        return dwarves;
    }
}
