import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Resto {

    static boolean[] sito = new boolean[100];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n, k;

        String[] line = in.readLine().split(" ");

        n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);

        System.out.println(solve(n, k));

    }

    public static int solve(int n, int k) {
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n ; j += i) {
                if(sito[j]) {
                    continue;
                }
                k = k -1;
                if(k == 0) {
                    return j;
                }
                sito[j] = true;
            }
        }
        return n;
    }
}
