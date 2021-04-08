/*
  DMOPC '17 Contest 5 P1 - IOI 101 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOI_101 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] s = in.readLine().split("");

        replace(s);
    }

    public static void replace(String[] str) {

        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("0")) {
                System.out.print("O");
            } else if(str[i].equals("1")) {
                System.out.print("l");
            } else if(str[i].equals("3")) {
                System.out.print("E");
            } else if(str[i].equals("4")) {
                System.out.print("A");
            } else if(str[i].equals("5")) {
                System.out.print("S");
            } else if(str[i].equals("6")) {
                System.out.print("G");
            } else if(str[i].equals("8")) {
                System.out.print("B");
            } else if(str[i].equals("9")) {
                System.out.print("g");
            } else {
                System.out.print(str[i]);
            }
        }
    }
}
