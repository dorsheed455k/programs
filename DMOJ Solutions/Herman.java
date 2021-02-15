import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Herman {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        double r = Double.parseDouble(in.readLine());

        double rN = r * r * 4 *Math.atan(1);
        double rF = 2.0 * r * r;

        System.out.printf("%.6f\n%.6f", rN, rF);
    }
}
