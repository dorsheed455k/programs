/* 
 CCC'96 S1 - Deficient, Perfect, and Abundant
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        while (n-- > 0) {
            int s = Integer.parseInt(in.readLine());
            integerType(s);
        }
    }

    public static void integerType(int s) {
        int sum = 0;
        for (int i = 1; i < s; i++) {
            if(s % i == 0) {
                sum += i;
            }
        }
        if(sum == s) {
            System.out.println(s + " is a perfect number.");
        } else if(sum < s) {
            System.out.println(s + " is a deficient number.");
        } else {
            System.out.println(s + " is an abundant number.");
        }
    }
}
