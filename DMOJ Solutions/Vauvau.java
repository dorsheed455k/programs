import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vauvau {

    public static void main(String[] args) throws IOException {

        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));

        int a, b, c, d;
        int[] v = new int[3];

        String[] l1 = in.readLine().split(" ");

        a = Integer.parseInt(l1[0]);
        b = Integer.parseInt(l1[1]);
        c = Integer.parseInt(l1[2]);
        d = Integer.parseInt(l1[3]);

        String[] l2 = in.readLine().split(" ");

        for (int i = 0; i < 3; i++) {
            v[i] = Integer.parseInt(l2[i]);
            solve(v[i], a, b, c, d);
        }
    }

    public static void solve(int x, int a, int b, int c, int d) {
        if(f(x, a, b) + f(x, c, d) == 0) System.out.println("none");
        if(f(x, a, b) + f(x, c, d) == 1) System.out.println("one");
        if(f(x, a, b) + f(x, c, d) == 2) System.out.println("both");

    }

    public static int f(int x, int a, int b) {
        return (x - 1) % (a + b) < a? 1 : 0;
    }
}
