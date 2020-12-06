/*
    COCI '09 Contest 7 #1 - Spavanac
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int h, m;

        String[] line = in.readLine().split(" ");

        h = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        System.out.println(timeStamp(h, m));

    }

    public static String timeStamp(int hrs, int min) {

        int dur = 0;
        while (dur < 45) {
            min--;
            if(min < 0) {
                min = 59;
                hrs--;
            }
            if(hrs < 0) {
                hrs = 23;
            }
            dur++;
        }

        return hrs + " " + min;
    }
}
