import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static Scanner line;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String exp = in.readLine();
        exp = exp.replaceAll("[()]", "");

        line = new Scanner(exp);

        try {
            double r = evaluatePrefix();
            System.out.printf("%.0f", r);
        } catch (Exception e) {

        }
    }

    static double evaluatePrefix() {
        String token = "";
        if (line.hasNext()) {
            token = line.next();
        }

        if (token.equals("+")) {
            double a = evaluatePrefix();
            double b = evaluatePrefix();
            return  a + b;
        } else if(token.equals("-")) {
            double a = evaluatePrefix();
            double b = evaluatePrefix();
            return a - b;
        } else {
            return Double.parseDouble(token);
        }
    }
}


