import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(in.readLine());
        int b = Integer.parseInt(in.readLine());

        System.out.printf("The number of RSA numbers between %d and %d is %d", a, b, rsaNum(a,b));

    }

    public static int rsaNum(int a, int b) {

        int count = 0;
        for (int i = a; i <= b ; i++) {
             count += divis(i);
        }

        return count;
    }

    public static int divis(int n) {

        int div = 0;
        for (int i = 1; i <= n; i++) {
            if(n % i == 0) {
                div++;
            }
        }

        if(div == 4) {
            return 1;
        } else {
            return 0;
        }
    }
}
