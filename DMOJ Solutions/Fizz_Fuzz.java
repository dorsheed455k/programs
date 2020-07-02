import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine())+1;
        int[] a = new int[n];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n-1; j++) {
                a[j] = a[i] + 1;
            }
        }
        String num1;
        String num2;
        int i = 1;

        while (i < n) {
            if (a[i] % 7 == 0 && a[i] % 13 == 0) {
                num2 = "Fizz Fuzz";
            } else if (a[i] % 7 != 0 && a[i] % 13 == 0) {
                num2 = "Fuzz";
            } else if(a[i] % 7 == 0 && a[i] % 13 != 0) {
                num2 = "Fizz";
            } else {
                num2 = String.valueOf(a[i]);
            }

            if (i % 7 == 0 && i % 13 == 0) {
                num1 = "Fizz Fuzz";
            } else if (i % 7 != 0 && i % 13 == 0) {
                num1 = "Fuzz";
            } else if(i % 7 == 0 && i % 13 != 0) {
                num1 = "Fizz";
            } else {
                num1 = String.valueOf(i);
            }
            System.out.println(num1 + " " + num2);
            i++;
        }
    }
}
