import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Hindeks {
    static int[] n_i;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        n_i = new int[n];
        String[] ln  = in.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            n_i[i] = Integer.parseInt(ln[i]);
        }

        Arrays.sort(n_i);

        n_i = reverse(n, n_i);

        int h = 0;
        while (h < n && n_i[h] >= h + 1) {
            h += 1;
        }


       System.out.println(h);
    }

    public static int[] reverse(int n, int[] n_i) {
        int j = n;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[j - 1] = n_i[i];
            j = j - 1;
        }
        return b;
    }
}
