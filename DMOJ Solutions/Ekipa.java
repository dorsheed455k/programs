import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Epika {

    static double[] best = new double[101];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n, m, k;
        String[] ln = in.readLine().split(" ");

        n = Integer.parseInt(ln[0]);
        m = Integer.parseInt(ln[1]);
        k = Integer.parseInt(ln[2]);

        for (int i = 0; i < m; i++) {
            String[] l1 = in.readLine().split(" ");
            double max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                int s = Integer.parseInt(l1[j*2]);
                double o = Double.parseDouble(l1[j*2+1]);
                best[s-1] = Math.max(best[s-1], o);
            }
        }

        sort(best, n);

        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += best[i];
        }
        System.out.printf("%.1f\n", sum);

    }

    public static void sort(double[] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    double tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
