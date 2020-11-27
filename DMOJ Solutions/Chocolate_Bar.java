import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            String[] line = in.readLine().split(" ");

            int m = Integer.parseInt(line[0]);
            int n = Integer.parseInt(line[1]);

            System.out.println(numBreaks(m, n));
        }
    }

    public static int numBreaks(int m, int n) {
        int product = (m-1) + m*(n-1);

        return product;
    }
}
