import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Natjecanje {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n, s, r;

        String[] l1 = in.readLine().split(" ");

        n = Integer.parseInt(l1[0]);
        s = Integer.parseInt(l1[1]);
        r = Integer.parseInt(l1[2]);

        int[] s_i = new int[n];
        int[] r_i = new int[n];

        String[] l2 = in.readLine().split(" ");
        String[] l3 = in.readLine().split(" ");

        for (int i = 0; i < s; i++) {
            int a = Integer.parseInt(l2[i]);
            a--;
            s_i[a] = 1;
        }

        for (int i = 0; i < r; i++) {
            int a = Integer.parseInt(l3[i]);
            a--;
            if(s_i[a] == 1) {
                s_i[a] = 0;
            } else {
                r_i[a] = 1;
            }
        }

        int sol = 0;
        for (int i = 0; i < n; i++) {
            if(s_i[i] == 1) {
                if(i > 0 && r_i[i - 1] == 1) {
                    r_i[i - 1] = 0;
                    s_i[i] = 0;
                } else if(i < n - 1 && r_i[i + 1] == 1) {
                    r_i[i + 1] = 0;
                    s_i[i] = 0;
                } else {
                    sol++;
                }
            }
        }
        System.out.println(sol);
    }
}
