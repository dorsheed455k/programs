/* Avatar Reference! */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int x, y;
        int x1, y1, x2, y2;

        String[] line1 = in.readLine().split(" ");

        x = Integer.parseInt(line1[0]);
        y = Integer.parseInt(line1[1]);

        String[] line2 = in.readLine().split(" ");

        System.out.println(isTrapped(x, y, line2)? "Yes" : "No");
    }


    public static boolean isTrapped(int x, int y, String[] line) {
       int x1 = Integer.parseInt(line[0]);
       int y1 = Integer.parseInt(line[1]);
       int x2 = Integer.parseInt(line[2]);
       int y2 = Integer.parseInt(line[3]);

        return x > x1 && x < x2 &&
                y > y1 && y < y2;
    }
}
