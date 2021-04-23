import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Monogram {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String monogram = "";
        for (int i = 0; i < 3; i++) {
            String s = in.readLine();
            char c = s.charAt(0);
            if (Character.isUpperCase(c)) {
                c  += 32;
            } else {
                c -= 32;
            }
            monogram += c;
        }

        System.out.println(monogram);
    }
}
