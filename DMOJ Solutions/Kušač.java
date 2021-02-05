import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kusac {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n, m;

        String[] line = in.readLine().split(" ");

        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        System.out.println(m - gcd(n, m));
    }

    public static int gcd(int n, int m) {
        int a = 1;
        for (int i = 1; i <= n && i <= m; i++) {
            if(n%i == 0 && m%i == 0) {
                a = i;
            }
        }
        return a;
    }
}
