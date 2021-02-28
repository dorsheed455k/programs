/*
 CCC_21_S1 - Crazy Fencing
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Secret_Instructions {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String n = in.readLine();
        String prev = "";

        while (!n.equals("99999")) {

            int sum = (n.charAt(0) - '0') + (n.charAt(1) - '0');

            if (sum % 2 == 1) {
                System.out.print("left ");
                prev = "left ";
            } else if(sum % 2 == 0) {
                if (sum != 0) {
                    System.out.print("right ");
                    prev = "right ";
                } else {
                    System.out.print(prev);
                }
            }
            System.out.println(n.substring(2));

            n = in.readLine();

        }
    }
}
