import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Domino {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        System.out.println(spots(n));
    }

    public static int spots(int n) {

        int sum = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                sum += i + j;
            }
        }
        return sum;
    }
}
