/*
  Mock CCC '19 Contest 1 J1 - Froggo the Frog
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FTF {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s = in.readLine();

        if (s.equals("Fly")) {
            System.out.println("don't eat!");
        } else {
            System.out.println("eat!");
        }
    }
}
