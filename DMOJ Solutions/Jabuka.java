/*
  COCI '08 Contest 5 #2 - Jabuka
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int r, g;

        String[] line = in.readLine().split(" ");

        r = Integer.parseInt(line[0]);
        g = Integer.parseInt(line[1]);

        splitApples(r, g);
    }

    public static void splitApples(int red, int green) {
        int i = 1;
        int rapples, gapples;
        while (i*i <= red) {
            if(red % i == 0) {
                if(green % i == 0) {
                    rapples = red / i;
                    gapples = green / i;
                    System.out.println(i + " " + rapples + " " + gapples);
                }
                if(i*i != red && green % (red / i) == 0){
                    rapples = i;
                    gapples = green / (red / i);
                    System.out.println((red/i) + " " + rapples + " " + gapples);
                }
            }
            i++;
        }
    }
}
