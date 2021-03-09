import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pripreme {

    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());

        String[] ln = in.readLine().split(" ");
        long x, sum = 0, m = 0;
        int i = 0;
        while (n-- > 0) {
            x = Long.parseLong(ln[i]);
            sum += x;
            m = Math.max(m, x);
            i++;
        }
        System.out.println(Math.max(2*m, sum));
    }
}
