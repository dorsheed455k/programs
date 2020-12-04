/*
  COCI '08 Contest 6 #2 - Bazen
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int ax, ay;

        String[] line = in.readLine().split(" ");

        ax = Integer.parseInt(line[0]);
        ay = Integer.parseInt(line[1]);

        getEndCoord(ax, ay);

    }

    public static void getEndCoord(int ax, int ay) {
        float p, bx = 0, by = 0;

        p = (float) 250*250/2;

        if(ax == 0) {
            if(ay < 125) {
                bx = p/(250-ay);
                by = 250 - p/(250-ay);
            } else {
                bx = p/ay;
                by = 0;
            }
        }

        if(ay == 0) {
            if(ax < 125) {
                bx = 250 - p/(250-ax);
                by = p/(250-ax);
            } else {
                bx = 0;
                by = p/ax;
            }
        }

        if(ax > 0 && ay > 0) {
            if (ax > 125) {
                bx = 0;
                by = 250 - p/ax;
            } else {
                bx = 250 - p/ay;
                by = 0;
            }
        }
        System.out.printf("%.2f %.2f", bx, by);
    }
}
