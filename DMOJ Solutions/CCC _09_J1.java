import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int d1 = Integer.parseInt(in.readLine());
        int d2 = Integer.parseInt(in.readLine());
        int d3 = Integer.parseInt(in.readLine());

        int digits = (d1 * 1) + (d2 * 3) + (d3 * 1) + 91;

        System.out.printf("The 1-3-sum is %d", digits);


    }
}
