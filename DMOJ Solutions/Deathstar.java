import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Deathstar {

    static int MAX = 1005;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] ans = new int[MAX];
        int n = Integer.parseInt(in.readLine());

        for (int i = 0; i < n; i++) {
            String[] ln = in.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(ln[j]);
                ans[i] |= x;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
