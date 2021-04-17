import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Change_Calculator {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(in.readLine());
        int d = Integer.parseInt(in.readLine());
        int n = Integer.parseInt(in.readLine());
        int c = Integer.parseInt(in.readLine());

        System.out.println(getCents(q, d, n, c));

    }

    public static int getCents(int q, int d, int n, int c) {

        return (q * 25) + (d * 10) + (n * 5) + c;
    }
}
