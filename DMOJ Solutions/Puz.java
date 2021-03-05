import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Puz {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int a, b, v;

        String[] ln = in.readLine().split(" ");

        a = Integer.parseInt(ln[0]);
        b = Integer.parseInt(ln[1]);
        v = Integer.parseInt(ln[2]);

        int lo = 1, hi = v;
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            if (mid*a - (mid-1)*b >= v) {
                hi = (int) mid;
            } else {
                lo = (int) mid+1;
            }
        }
        System.out.println(lo);
    }
}
