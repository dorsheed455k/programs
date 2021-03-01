import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tablica {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        double a, b , c, d;
        String[] l1 = in.readLine().split(" ");
        a = Integer.parseInt(l1[0]);
        b = Integer.parseInt(l1[1]);
        String[] l2 = in.readLine().split(" ");
        c = Integer.parseInt(l2[0]);
        d = Integer.parseInt(l2[1]);

        double v1 = a/c + b/d;
        double v2 = c/d + a/b;
        double v3 = d/b + c/a;
        double v4 = b/a + d/c;
        double max = Math.max(Math.max(v1,v2),Math.max(v3,v4));

        if (equals(max, v1)) {
            System.out.println("0");
        } else if(equals(max, v2)) {
            System.out.println("1");
        } else if(equals(max, v3)) {
            System.out.println("2");
        } else {
            System.out.println("3");
        }
    }

    public static boolean equals(double a, double b) {
        if (Math.abs(a-b) < 0.0001) {
            return true;
        }
        return false;
    }
}
