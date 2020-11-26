/*
COCI '06 Contest 2 - ABC
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] num = new int[3];
        String[] line = in.readLine().split(" ");
        for (int i = 0; i < 3; i++) {
            num[i] = Integer.parseInt(line[i]);
        }
        String[] lett = in.readLine().split("");

        sort(num);
        int[] ord = new int[3];
        for (int i = 0; i < 3; i++) {
            if(lett[i].equals("A")) {
                ord[i] = num[0];
            } else if(lett[i].equals("B")) {
                ord[i] = num[1];
            } else {
                ord[i] = num[2];
            }
        }

        for (int i = 0; i < ord.length; i++) {
            System.out.print(ord[i] + " ");
        }
    }

    public static void sort(int[] num) {
        int t1;
        for (int i = 0; i < 3; i++) {
            for (int j = i+1; j < 3; j++) {
                if(num[j] < num[i]) {
                    t1 = num[i];
                    num[i] = num[j];
                    num[j] = t1;
                }
            }
        }
    }
}
