import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Secer {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int sum = 0;
        while (n%5 != 0) {
            n -= 3;
            sum++;
        }

        if (n < 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum + n/5);
        }
    }
}
