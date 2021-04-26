import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AMP {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        long[] arr = new long[n];

        String[] ln = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(ln[i]);
        }

        long max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long prod = arr[i] * arr[j];
                if (prod > max) {
                    max = prod;
                }
            }
        }
        System.out.println(max);
    }
}
