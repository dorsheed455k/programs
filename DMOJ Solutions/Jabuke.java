import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jabuke {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n, m, j;

        String[] ln = in.readLine().split(" ");

        n = Integer.parseInt(ln[0]);
        m = Integer.parseInt(ln[1]);
        j = Integer.parseInt(in.readLine());

        int lo = 1;
        int hi = m;

        int sum = 0;

        while (j-- > 0){
            int x = Integer.parseInt(in.readLine());
            if (lo <= x && hi >= x) continue;
            if (x < lo) {
                sum += lo - x;
                hi -= (lo - x);
                lo = x;
            } else {
                sum += x - hi;
                lo += (x - hi);
                hi = x;
            }
        }
        System.out.println(sum);
    }
}
