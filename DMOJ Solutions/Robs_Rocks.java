import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Robs_Rocks {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        String[] ln = in.readLine().split(" ");
        int[] a_i = new int[n];
        for (int i = 0; i < n; i++) {
            a_i[i] = Integer.parseInt(ln[i]);
        }

        freq(a_i, n);
    }

    public static void freq(int arr[], int n) {

        boolean[] vis = new boolean[n];

        Arrays.fill(vis, false);
        int rock = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (vis[i] == true) continue;

            int count = 1;
            for (int j = i+1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    vis[j] = true;
                    count++;
                }
            }
            if(arr[i] * count > max) {
                max = arr[i] * count;
                rock = arr[i];
            }
        }
        System.out.println(rock);
    }
}
