import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
CCCHK '08 J2 - Given n cases, determine the the sum of the digits within it
before computing the single digit representation of the given number.
*/

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        for (int i = 0; i < n; i++) {
            String digits = in.readLine();
            System.out.println(luckyNum(digits));

        }
    }

    public static String luckyNum(String d) {

        String str = d;

        while (str.length() != 1) {
            int count = 0;

            for (int i = 0; i < str.length(); i++) {
                count += Integer.parseInt(String.valueOf(str.charAt(i)));
            }

            str = String.valueOf(count);
        }

        return str;
    }
}
