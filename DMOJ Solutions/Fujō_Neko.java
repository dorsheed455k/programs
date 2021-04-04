/*
  DMOPC '17 Contest 1 P1 - Fujō Neko
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fujō_Neko {

    static boolean checkRow[] = new boolean[1002];
    static boolean checkCol[] = new boolean[1002];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int r, c, q;

        String[] ln = in.readLine().split(" ");
        r = Integer.parseInt(ln[0]);
        c = Integer.parseInt(ln[1]);

        for (int i = 0; i < r; i++) {
           String[] l1 = in.readLine().split("");
            for (int j = 0; j < c; j++) {
                if (l1[j].equals("X")) {
                    checkCol[j] = true;
                    checkRow[i] = true;
                }
            }
        }

        q = Integer.parseInt(in.readLine());

        for (int i = 0; i < q; i++) {
            String[] l2 = in.readLine().split(" ");
            int x = Integer.parseInt(l2[0]);
            int y = Integer.parseInt(l2[1]);

            if (checkRow[y-1] == true || checkCol[x-1] == true) {
                System.out.println("Y");
            } else {
                System.out.println("N");
            }
        }
    }
}
