import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yoda {

    static String a, b;
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        a = in.readLine();
        b = in.readLine();

        while (a.length() < b.length()) {
            a = "0" + a;
        }

        while (b.length() < a.length()) {
            b = "0" + b;
        }
        collision();
    }

    public static void collision() {
        StringBuilder a1 = new StringBuilder();
        StringBuilder b1 = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) > b.charAt(i)) {
                a1.append(a.charAt(i));
            } else if(a.charAt(i) < b.charAt(i)) {
                b1.append(b.charAt(i));
            } else {
                a1.append(a.charAt(i));
                b1.append(a.charAt(i));
            }
        }

        if(a1.length() == 0) {
            System.out.println("YODA");
        } else {
            if(Integer.parseInt(a1.toString()) == 0) {
                System.out.println(0);
            } else {
                System.out.println(a1.toString());
            }
        }

        if(b1.length() == 0) {
            System.out.println("YODA");
        } else {
            if(Integer.parseInt(b1.toString()) == 0) {
                System.out.println(0);
            } else {
                System.out.println(b1.toString());
            }
        }
    }
}
