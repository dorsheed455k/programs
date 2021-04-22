import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cube_Sum {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] n = in.readLine().split("");

        int sum = 0;
        for (int i = 0; i < n.length; i++) {
            int x = Integer.parseInt(n[i]);
            x *= x * x;
            sum += x;
        }
        System.out.println(sum);
    }
}
