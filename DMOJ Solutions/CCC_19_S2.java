import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(in.readLine());
            primeAvg(p*2);
        }
        in.close();
    }

    public static boolean is_Prime(int n) {
        if(n <= 1) return false;
        if(n == 2) return true;
        for(int i = 2; i <= Math.sqrt(n); i++)
            if(n % i == 0) return false;
        return true;
    }

    public static void primeAvg(int n) {
        for(int i = 2; i <= n; i++) {
            if(is_Prime(i) && is_Prime(n - i)) {
                System.out.println(i + " " + (n - i));
                break;
            }
        }
    }
}
