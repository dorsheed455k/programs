/*
  DMOPC '17 Contest 2 P0 - Secrets
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Secrets {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int x1, x2, x_0;
        int y1, y2, y_0;

        String[] l1 = in.readLine().split(" ");
        x1 = Integer.parseInt(l1[0]);
        y1 = Integer.parseInt(l1[1]);

        String[] l2 = in.readLine().split(" ");
        x2 = Integer.parseInt(l2[0]);
        y2 = Integer.parseInt(l2[1]);

        String[] l3 = in.readLine().split(" ");
        x_0 = Integer.parseInt(l3[0]);
        y_0 = Integer.parseInt(l3[1]);

        int d = Integer.parseInt(in.readLine());

        double dist_1 = Math.sqrt(Math.pow((x1 - x_0), 2) + Math.pow((y1 - y_0), 2));
        double dist_2 = Math.sqrt(Math.pow((x2 - x_0), 2) + Math.pow((y2 - y_0), 2));

        if (dist_1 <= d || dist_2 <= d) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
