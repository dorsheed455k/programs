import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Encode {

    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());

        String[] ln = in.readLine().split(" ");

        int d;
        if (n > 0) {
            d = 26 - n;
        } else {
            d = 26 + n;
        }

        for (int i = 0; i < ln.length; i++) {
            String o = ln[i];
            for (int j = 0; j < ln[i].length(); j++) {
                if (Character.isUpperCase(ln[i].charAt(j))) {
                 int idx = ln[i].charAt(j) - 'A';
                 int nex;
                 if (n < 0) {
                     nex = (idx - n) % 26;
                 } else {
                     nex = (idx%26 - (n%26) + 26) % 26;
                 }
                    System.out.print((char) (65 + nex));
                } else {
                    int idx = ln[i].charAt(j) - 'a';
                    int nex;
                    if (n < 0) {
                        nex = (idx - n) % 26;
                    } else {
                        nex = (idx%26 - (n%26) + 26) % 26;
                    }
                    System.out.print((char) (97 + nex));
                }
            }
            System.out.print(" ");
        }
    }
}
