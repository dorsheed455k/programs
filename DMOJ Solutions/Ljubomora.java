import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ljubomora {

    static int[] a = new int[300000];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n, m;
        String[] l1 = in.readLine().split(" ");

        n = Integer.parseInt(l1[0]);
        m = Integer.parseInt(l1[1]);

        int s = 0;
        for (int i = 0; i < m; i++) {
            a[i] = Integer.parseInt(in.readLine());
            if (s < a[i]) {
                s = a[i];
            }
        }

        int lo = 0, hi = s;
        while (lo < hi) {
            int y = (lo + hi) / 2;
            int n2 = 0;
            for (int i = 0; i < m; ++i)
                n2 += (a[i] + y - 1) / y;
            if (n2 > n)
                lo = y + 1;
            else
                hi = y;
        }
        System.out.println(lo);
    }
}
