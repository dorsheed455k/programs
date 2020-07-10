import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int tiles = Integer.parseInt(in.readLine());

        System.out.printf("The largest square has side length %d.", maxSqrt(tiles));
    }

    public static int maxSqrt(int t) {

        int max = 0;
        for (int i = 1; i <= t; i++) {
            if(i*i <= t ) {
              max = i;
            }
        }
        return max;
    }
}
