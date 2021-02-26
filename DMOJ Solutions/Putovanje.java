import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Putovanje {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n, c;

        String[] l1 = in.readLine().split(" ");
        n = Integer.parseInt(l1[0]);
        c = Integer.parseInt(l1[1]);

        int[] w_i = new int[n];

        String[] l2 = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            w_i[i] = Integer.parseInt(l2[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int left = c;
            int curr = 0;
            for (int j = i; j < n; j++) {
                if (w_i[j] <= left) {
                    left -= w_i[j];
                    curr += 1;
                }
            }
            ans = Math.max(ans, curr);
        }
        System.out.println(ans);
    }
}
