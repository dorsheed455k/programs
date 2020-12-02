/*
  COCI '07 Contest 2 #2 - Crne
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int v, h;
        int n = Integer.parseInt(in.readLine());

        h = n / 2;
        v = n - h;

        System.out.println((h+1) * (v+1));

    }
}
