/*
  COCI '07 Contest 5 #1 Tri 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int a, b, c;

        String[] line = in.readLine().split(" ");
        a = Integer.parseInt(line[0]);
        b = Integer.parseInt(line[1]);
        c = Integer.parseInt(line[2]);

        equation(a, b, c);
    }

    public static void equation(int a, int b, int c) {

            if(a - b == c) {
                System.out.println(a + "-" + b + "=" + c);
            } else if(a + b == c) {
                System.out.println(a + "+" + b + "=" + c);
            } else if(a*b == c) {
                System.out.println(a + "*" + b + "=" + c);
            } else if(a/b == c) {
                System.out.println(a + "/" + b + "=" + c);
            } else if(b - c == a) {
                System.out.println(a + "=" + b + "-" + c);
            } else if(b + c == a) {
                System.out.println(a + "=" + b + "+" + c);
            } else if(b * c == a) {
                System.out.println(a + "=" + b + "*" + c);
            } else if(b / c == a) {
                System.out.println(a + "=" + b + "/" + c);
            }
    }
}
