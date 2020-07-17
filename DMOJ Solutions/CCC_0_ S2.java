import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FractionCal {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());

        fractCal(n, m);
    }

    public static void fractCal(int a, int b) {

         int temp = a;


        if(a % b == 0) {
            System.out.println(a/b);
            System.exit(0);
        } else {
            a = a / gcdCal(a,b);
            b = b / gcdCal(temp, b);
            if(a/b != 0) {
                System.out.println(a/b + " " + (a%b) + "/" + b);
            } else {
                System.out.println((a%b) + "/" + b);
            }
        }
    }

    public static int gcdCal(int a, int b) {
      int gcd = 1;

        for (int i = 1; i <= a && i <= b ; i++) {
            if(a%i == 0 && b%i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}
