import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tarifa {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(in.readLine());

        int n = Integer.parseInt(in.readLine());

        int months = (n + 1) * x;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(in.readLine());
            sum += m;
        }

        System.out.println(months - sum);
    }
}
