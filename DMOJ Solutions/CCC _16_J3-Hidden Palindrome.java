import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HiddenPalindromes {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str = in.readLine();

        System.out.println(maxPalidrome(str));
    }

    public static int maxPalidrome(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if(reverse(s.substring(i,j)).equals(s.substring(i,j))) {
                    int size = j - i;
                    max = size > max? size : max;
                }
            }
        }
        return max;
    }

    public static String reverse(String s) {

        StringBuilder rev = new StringBuilder();
        for (int i = s.length()-1; i >= 0 ; i--) {
            rev.append(s.charAt(i));
        }
        return rev.toString();
    }
}
