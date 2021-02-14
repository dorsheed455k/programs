import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        long t, n;

        t = Long.parseLong(in.readLine());

        for (int i = 0; i < t; i++) {
            n = Long.parseLong(in.readLine());
            System.out.println(Z(n));
        }
    }

    public static long Z(long n) {
        long N = n, zero = 0;
        while (N/5 != 0) {
            zero += N/5;
            N = N/5;
        }
        return zero;
    }
}
