import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        System.out.println(collatz(n, 0));
    }

    public static int collatz(int n, int count) {
        if(n == 1) {
            return count;
        }

        if(n % 2 != 0) {
            return collatz(3 * n + 1, count+1);
        } else if (n % 2 == 0) {
            return collatz( n/2, count+1);
        }
        
        return n;
    }
}
