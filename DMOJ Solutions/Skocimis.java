/*
  COCI '08 Contest 1 #1 - Skocimis
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Skocimis {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] kang = new int[3];

        String[] line = in.readLine().split(" ");

        for (int i = 0; i < 3; i++) {
            kang[i] = Integer.parseInt(line[i]);
        }

        if(kang[1] - kang[0] > kang[2] - kang[1]) {
            System.out.println(kang[1]-kang[0]-1);
        } else {
            System.out.println(kang[2]-kang[1]-1);
        }
    }
}
