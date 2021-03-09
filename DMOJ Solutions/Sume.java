import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sume {

    static int[][] s = new int[1001][1001];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        if (n == 2) {
            System.out.println("1 1");
            return;
        }

        for (int i = 0; i < n; i++) {
            String[] ln = in.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                s[i][j] = Integer.parseInt(ln[j]);
            }
        }
        int tri = (s[0][1] + s[0][2] + s[1][2]) / 2;
        int a = tri - s[1][2];
        System.out.print(a);
        for (int i = 1; i < n; i++) {
            System.out.printf(" %d", s[0][i] - a);
        }
        System.out.println();
    }
}
