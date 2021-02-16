import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kemija {

    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String line = in.readLine();

        System.out.println(decode(line));
    }

    public static String decode(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean skip = false;
            for (int j = 0; j < vowels.length; j++) {
                if(c == vowels[j]) {
                    skip = true;
                    break;
                }
            }
            if(skip) {
                sb.append(c);
                i += 2;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
