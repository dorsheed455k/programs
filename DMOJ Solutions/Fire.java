/*
  Another Avatar reference!
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fire {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n, k;
        String[] line1 = in.readLine().split(" ");

        n = Integer.parseInt(line1[0]);
        k = Integer.parseInt(line1[1]);

        int[] s = new int[n];
        String[] line2 = in.readLine().split(" ");

        for (int i = 0; i < n; i++) s[i] = Integer.parseInt(line2[i]);


        sortArr(s, n);

        int min = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if(j < k) {
                s[i] *= 2;
            }
            j++;
            if (s[i] < min) {
                min = s[i];
            }
        }
        System.out.println(min);
    }

    public static void sortArr(int[] s, int n) {
        for (int i = 0; i < n; i++) {
            int temp;
            for (int j = i+1;j < n; j++) {
                if(s[i] > s[j]) {
                    temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }
    }
}
