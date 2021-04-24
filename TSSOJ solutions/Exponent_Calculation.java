import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exponent_Calculation {

    final static double e = 2.71828182845904523536;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        double x = Integer.parseInt(in.readLine());
        double y = Integer.parseInt(in.readLine());

        double con = eular(x, y);
        System.out.println(con);
        System.out.println(Math.pow(x, y));
    }

    public static double eular(double x, double y) {
        double exp = Math.exp(y*Math.log(x));
        return exp;
    }
}
