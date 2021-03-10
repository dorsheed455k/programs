import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Telefoni {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int d, n;
        String[] ln = in.readLine().split(" ");

        n = Integer.parseInt(ln[0]);
        d = Integer.parseInt(ln[1]);

        int last = 0;
        int ans = 0;
        String[] desks = in.readLine().split(" ");
        for (int i = 0; i < n; ++i) {
            int x = Integer.parseInt(desks[i]);
            if (x == 1) last = i;
            if (i - last == d) {
                ++ans;
                last = i;
            }
        }
        System.out.println(ans);
    }
}
