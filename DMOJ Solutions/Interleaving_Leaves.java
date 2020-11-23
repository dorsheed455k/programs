import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
           int n = Integer.parseInt(in.readLine());
           String[] a = in.readLine().split("");
           String[] b = in.readLine().split("");

            System.out.println(interleave(a, b, n));
        }
    }


    public static String interleave(String[] a, String[] b, int n) {
        StringBuilder pile = new StringBuilder();
        for (int i = 0; i < n; i++) {
            pile.append(a[i]);
            pile.append(b[i]);
        }

        pile = pile.reverse();

        return pile.toString();
    }
}
