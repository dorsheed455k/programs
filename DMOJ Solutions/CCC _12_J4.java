import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BigBang {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(in.readLine());
        String s = in.readLine();

        System.out.println(decode(k,s));
    }

    public static String decode(int k, String s) {
        StringBuilder sb = new StringBuilder();
        char plain;
        int lett;
        int shift;
        int x;
        for (int i = 0; i < s.length(); i++) {
            lett = i+1;
            shift = 3*lett+k;
            x = s.charAt(i) - shift;
            if(x < 'A') {
                x = 'Z' - ('A' - x) + 1;
            }

            plain =  (char) x;
            sb.append(plain);
        }
        return sb.toString();
    }
}
