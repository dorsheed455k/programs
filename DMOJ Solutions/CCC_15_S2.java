
/* CCC '15 S2 - Jerseys */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jearsy {
    static int j, a, MAX = 1000001;
    static int[] clothes = new int[MAX];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        j = Integer.parseInt(in.readLine());
        a = Integer.parseInt(in.readLine());

        for (int i = 1; i <= j; i++) {
            char c = in.readLine().charAt(0);

            if (c == 'S')
                clothes[i] = 0;
            else if(c == 'M')
                clothes[i] = 1;
            else if (c == 'L')
                clothes[i] = 2;
        }

        is_compatible(in);

    }

    public static void is_compatible(BufferedReader in) throws IOException {
        int ans = 0;
        for (int i = 1; i <= a; i++) {
            int n; char jersy_i;
            int s = 0;
            String[] ln = in.readLine().split(" ");
            jersy_i = ln[0].charAt(0);
            n = Integer.parseInt(ln[1]);

            if (jersy_i == 'S') {
                s = 0;
            } else if(jersy_i == 'M') {
                s = 1;
            } else if (jersy_i == 'L') {
                s = 2;
            }

            if(1 <= n && n <= j && clothes[n] >= s) {
                ans++;
                clothes[n] = -1;
            }
        }
        System.out.println(ans);
    }
}
