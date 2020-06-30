import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(in.readLine());
        int b = Integer.parseInt(in.readLine());
        int c = Integer.parseInt(in.readLine());
        int d = Integer.parseInt(in.readLine());
        int s = Integer.parseInt(in.readLine());

        int d1 = 0, d2 = 0;
        int s1 =  0, s2 = 0;
        int next1 = a, next2 = c;
        int sgn1 = 1, sgn2 = 1;

        while (s1+next1 < s) {
            s1 += next1;
            d1 += sgn1 * next1;
            if (sgn1 == 1) {
                next1 = b;
            } else {
                next1 = a;
            }
            sgn1 = sgn1 * -1;
        }

        d1 += sgn1 * (s - s1);

        while (s2+next2 < s) {
            s2 += next2;
            d2 += sgn2 * next2;
            if (sgn2 == 1) {
                next2 = d;
            } else {
                next2 = c;
            }
            sgn2 = sgn2 * -1;
        }

        d2 += sgn2 * (s - s2);

        if (Math.abs(d1) > Math.abs(d2) ) {
            System.out.println("Nikky");
        } else if (Math.abs(d1) < Math.abs(d2) ){
            System.out.println("Byron");
        } else if (Math.abs(d1) == Math.abs(d2) ) {
            System.out.println("Tied");
        }
    }
}
