import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class New_Students {

    static int[] init;
    static int[] post;
    static int n, s;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        init = new int[n];
        for (int i = 0; i < n; i++) {
            init[i] = Integer.parseInt(in.readLine());
        }

        s = Integer.parseInt(in.readLine());
        post = new int[s];
        for (int i = 0; i < s; i++) {
            post[i] = Integer.parseInt(in.readLine());
        }

        int avg = 0;

        for (int i = 0; i < n; i++) {
            avg += init[i];
        }

        for (int i = 0; i < s; i++) {
            avg += post[i];
            System.out.printf("%.3f\n", (double) avg / (n+i+1));
        }
    }
}
