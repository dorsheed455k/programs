import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int m, n, k;

        String[] line = in.readLine().split(" ");

        m = Integer.parseInt(line[0]);
        n = Integer.parseInt(line[1]);
        k = Integer.parseInt(line[2]);

        int r = 0;

        while (m >= 2 && n >= 1 && m+n >= k+3) {
            r++;
            m -= 2;
            n -= 1;
        }

        System.out.println(r);
    }
}
