import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Necklace_Problem {

    static int c, d;
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        String[] ln;
        for (int i = 0; i < n; i++) {
            ln = in.readLine().split(" ");
            int a = Integer.parseInt(ln[0]);
            int b = Integer.parseInt(ln[1]);
            c = a;
            d = b;
            System.out.print(a + " ");
            necklace(a, b);
            System.out.print(b);
        }
    }

    public static void necklace(int a, int b) {
        System.out.print(b + " ");
        int tmp = a + b;
        a = b;
        b = tmp % 10;
        if (a != c || b != d) {
            necklace(a, b);
        }
    }
}
