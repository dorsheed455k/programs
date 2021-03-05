import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kosarka {
  
    static int n, a, b;
    static int MAX = 48 * 60;
    static int[] d = new int[MAX];
  
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            int t, m, s;
            String[] ln = in.readLine().split("[\\s,:]");
            t = Integer.parseInt(ln[0]);
            m = Integer.parseInt(ln[1]);
            s = Integer.parseInt(ln[2]);
            if (t == 1) d[m * 60 + s] = 1;
            if (t == 2) d[m * 60 + s] = -1;
        }

        for (int i = 0; i < MAX; i++) {
            if (i > 0) d[i] += d[i - 1];
            if (d[i] > 0) a++;
            if (d[i] < 0) b++;
        }

        System.out.printf("%02d:%02d\n", a / 60, a % 60);
        System.out.printf("%02d:%02d\n", b / 60, b % 60);
    }
}
