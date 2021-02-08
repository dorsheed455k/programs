import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kosnja {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(in.readLine());

        int n, m;
        for (int i = 0; i < k; i++) {
            String[] line = in.readLine().split(" ");

            n = Integer.parseInt(line[0]);
            m = Integer.parseInt(line[1]);

            int rj = 2 * Math.min(n, m) - 2;
            System.out.printf("%d\n", rj);
        }

    }
}
