import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Buka {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String a, b;
        char[] op = new char[2];

        int la, lb;

        a = in.readLine();
        op[0] = in.readLine().charAt(0);
        b = in.readLine();

        la = a.length();
        lb = b.length();

        if(op[0] == '+') {
            if(la == lb) {
                System.out.print("2");
                nule(la - 1);
            } else {
                System.out.print("1"); nule(max(la, lb) - min(la, lb) - 1);
                System.out.print("1"); nule(min(la, lb) - 1);
            }
        } else {
            System.out.print("1");
            nule(la+lb-2);
        }
        System.out.println();
    }

    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    public static int min(int a, int b) {
        return Math.min(a, b);
    }

    public static void nule(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("0");
        }
    }
}
