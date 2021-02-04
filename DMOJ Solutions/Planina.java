import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int r = 2;

        for (int i = 1; i <= n; i++) {
            r = 2 * r - 1;
        }

        r = r*r;

        System.out.println(r);
    }
}
