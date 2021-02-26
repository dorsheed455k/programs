import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kriza {
  
    static int MAX = 100002;
    static  int[] v_i = new int[MAX];
    static  long[] miss = new long[MAX];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int k, n, fk = 0;
        String[] ln = in.readLine().split(" ");
        n = Integer.parseInt(ln[0]);
        k = Integer.parseInt(ln[1]);
        for (int i = 0; i < n; ++i) {
            int x = Integer.parseInt(in.readLine());
            v_i[--x] = i;
            if (i == 0) fk = x;
        }

        long sol = (long) Math.abs(v_i[0] - v_i[fk]);
        if (v_i[fk] > v_i[0]) sol = n - sol;

        for (int i = 1; i <= n; ++i) {
            int curr = v_i[i - 1], prev = v_i[(i - 2 + n) % n];
            int wrong = Math.abs(curr - prev);
            if (prev > curr) wrong = n - wrong;
            miss[i] = miss[i - 1] + (long) wrong;
        }

        sol += miss[n] * (k/n);
        sol += miss[k%n] - miss[1];

        System.out.println(sol);
    }
}
