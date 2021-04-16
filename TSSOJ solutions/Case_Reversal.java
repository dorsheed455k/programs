import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Case_Reversal {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        char[] s = in.readLine().toCharArray();

        for (int i = 0; i < s.length; i++) {
            if (s[i] >= 65 && s[i] <= 90) {
                char c = (char) (s[i] + 32);
                System.out.print(c);
            } else if(s[i] >= 97 && s[i] <= 122) {
                char c = (char) (s[i] - 32);
                System.out.print(c);
            } else {
                System.out.print(s[i]);
            }
        }
    }
}
