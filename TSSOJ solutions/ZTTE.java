/*
  Zeroes to the End
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZTTE {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] num = in.readLine().split("");

        String zeros = "";

        for (int i = 0; i < num.length; i++) {
            if (num[i].equals("0")) {
                zeros += "0";
                continue;
            }
            System.out.print(num[i]);
        }
        for (int i = 0; i < zeros.length(); i++) {
            System.out.print(zeros.charAt(i));
        }
    }
}
