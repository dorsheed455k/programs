import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String plain = in.readLine();
        String cipher1 = in.readLine();
        String cipher2 = in.readLine();

        System.out.println(decipher(plain, cipher1, cipher2));

    }

    public static String decipher(String p, String c1, String c2) {
        StringBuilder sb = new StringBuilder();
        int pos;

        for (int i = 0; i < c2.length(); i++) {
            pos = c1.indexOf(c2.charAt(i));

            if(pos == -1) {
                sb.append(".");
            } else {
                sb.append(p.charAt(pos));
            }
        }
        return sb.toString();
    }
}
