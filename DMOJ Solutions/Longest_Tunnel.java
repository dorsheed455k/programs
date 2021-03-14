import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Longest_Tunnel {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String[] ln = in.readLine().split(" ");
            int t1 = Integer.parseInt(ln[0]);
            int t2 = Integer.parseInt(ln[1]);

            int len = Math.abs(t1 - t2);
            if (len > max) {
                max = len;
            }
        }
        System.out.println(max);
    }
}
