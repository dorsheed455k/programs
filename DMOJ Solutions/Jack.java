import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jack {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n, m;
        String[] ln = in.readLine().split(" ");
        n = Integer.parseInt(ln[0]);
        m = Integer.parseInt(ln[1]);

        int[] a = new int[n];

        String[] l1 = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(l1[i]);
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    int i1 = a[i] + a[j] + a[k];
                    if (i1 <= m) {
                        sum = Math.max(sum, i1);
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
