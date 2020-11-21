import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        while (n-- > 0){
            String[] line = in.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            System.out.println(getRevSum(a, b));
        }
    }

    public static int getRevSum(int a, int b) {
        int rA, rB;

        rA = reverse(a);
        rB = reverse(b);

        int rSum = rA + rB;

        return reverse(rSum);


    }

    public static int reverse(int n) {
        int rev = 0;

        for(; n != 0; n /= 10) {
            int digit = n % 10;
            rev = rev * 10 + digit;
        }

        return rev;
    }
}
