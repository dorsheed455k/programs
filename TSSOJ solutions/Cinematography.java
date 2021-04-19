import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cinematography {

    static int[] frames, c_i;
    static int[] r_shift;
    static int[] l_shift;
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        frames = new int[n];
        r_shift = new int[n];
        l_shift = new int[n];

        String[] ln = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            frames[i] = Integer.parseInt(ln[i]);
        }

        c_i = new int[n];
        ln = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            c_i[i] = Integer.parseInt(ln[i]);
        }

        int l, r;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (c_i[i] == frames[j]) {
                    l = Math.abs(i - j);
                    r = Math.abs(n - i - j);
                    System.out.println(Math.min(l, r));
                    return;
                }
            }
        }
    }
}
