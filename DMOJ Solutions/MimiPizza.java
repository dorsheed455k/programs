/*
  DMOPC '17 Contest 5 P0 - Mimi and Pizza
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MimiPizza {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int b = Integer.parseInt(in.readLine());
        int p = Integer.parseInt(in.readLine());
        char s = in.readLine().charAt(0);

        if(s == 'Y') {
            if (p * 5 <= b) {
                System.out.println("B");
                return;
            }
            if (p * 2 <= b) {
                System.out.println("D");
            }
        } else if(s == 'N') {
            if (p * 5 <= b) {
                System.out.println("A");
                return;
            }
            if (p * 2 <= b) {
                System.out.println("C");
            }
        } else {
            System.out.println("NO PIZZA");
        }
    }
}
