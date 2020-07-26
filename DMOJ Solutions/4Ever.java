import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final String[] units = {
            "", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    public static final String[] tens = {
            "", "", "twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninety"
    };

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        do {
            n = convert(n).length();
            System.out.println(n + ": " + convert(n));
        } while (n != 4);

    }

    public static String convert(final int n) {

        if(n < 20) {
            return units[n];
        }

        if(n < 100) {
            return tens[n/10] + units[n%10];
        }

        if (n < 1000) {
            return units[n / 100] + "hundred" + convert(n % 100);
        }

        if (n < 1000000) {
            return convert(n / 1000) + "thousand" + convert(n % 1000);
        }

        if (n < 1000000000) {
            return convert(n / 1000000) + "million" +  convert(n % 1000000);
        }

        return convert(n / 1000000000) + "billion"  + convert(n % 1000000000);
    }
}
