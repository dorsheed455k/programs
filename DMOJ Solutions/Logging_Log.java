import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Logging_Log {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int d = Integer.parseInt(in.readLine());

        int i = 1;
        while (d-- > 0) {
            int t = Integer.parseInt(in.readLine());
            int sum = 0;
            for (int j = 0; j < t; j++) {
                sum += Integer.parseInt(in.readLine());
            }
            if (sum > 0) {
                System.out.printf("Day %d: %d\n", i, sum);
            } else {
                System.out.println("Weekend");
            }
            i++;
        }
    }
}
