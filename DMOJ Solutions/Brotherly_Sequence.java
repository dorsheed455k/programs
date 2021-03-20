import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Brotherly_Sequence {
    static int n, max = Integer.MIN_VALUE;
    static int[] s = new int[110];
    static int[] a = new int[110];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        String[] ln = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(ln[i]);
            a[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (i > 0 && Math.abs(s[i] - s[i-1]) <= 2) {
                a[i] = a[i-1]+1;
            }
        }
        for (int i = 0; i < n; i++) {
            max = Math.max(max, a[i]);
        }
        System.out.println(max);
    }
}
