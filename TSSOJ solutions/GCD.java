/*
  Greatest Common Divisor
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GCD {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int num1 = Integer.parseInt(in.readLine());
        int num2 = Integer.parseInt(in.readLine());

        int rm;
        while (num2 != 0) {
            rm = num1 % num2;
            num1 = num2;
            num2 = rm;
        }

        System.out.println(num1);
    }
}
