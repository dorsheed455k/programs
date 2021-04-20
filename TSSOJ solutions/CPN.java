/*
   CPC 1 Problem 4 - Chika's Prime Numbers
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CPN {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(in.readLine());
            if (n <= 3) {
                System.out.println("NO");
                return;
            }

            if(n%2 == 0) {
                System.out.println("YES");
            } else if(isPrime(n-2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n == 1)
            return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
