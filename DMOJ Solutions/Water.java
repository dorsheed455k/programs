/*
   And another avatar reference
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Water {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        sortArray(arr, 3);

        System.out.println(arr[0] - arr[2]);

    }


    public static void sortArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int temp;
            for (int j = i+1;j < n; j++) {
                if(arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
