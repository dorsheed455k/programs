/*
  CCC _00_J1 - Calendar
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calender {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] ln = in.readLine().split(" ");
        int s = Integer.parseInt(ln[0]);
        int n = Integer.parseInt(ln[1]);
        int c = s;
        System.out.println("Sun Mon Tue Wed Thr Fri Sat");

        for (int i = 1; i < c; i++) {
            System.out.print("    ");
        }
        for (int i = 1; i <= n; i++) {
            print(i);
            c++;
            if (c == 8 || i == n) {
                System.out.println();
                c = 1;
            } else {
                System.out.print(" ");
            }
        }
    }

    public static void print(int a) {
        System.out.printf("%3d", a);
    }
}
