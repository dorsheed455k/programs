import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class primeFinder {

    public static void main(String[] ags) throws IOException {

        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                for (int k = x; k <= y; k++) {
                    BigInteger b = BigInteger.valueOf(k);
                    if(b.isProbablePrime(k)) System.out.println(k);
            }
            System.out.println();
        }
    }
}
