import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class English {

    static int numVowels, words, cons;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        numVowels = 0;
        words = 0;
        cons = 0;
        for (int i = 0; i < n; i++) {
            String s = in.readLine();
            isEnglish(s);
        }
        System.out.println(words);
    }

    public static void isEnglish(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' ||
                    s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                numVowels++;
                if (numVowels > 2) {
                    numVowels = 0;
                    words++;
                    break;
                }
            } else {
                cons++;
                if (numVowels > 0) numVowels = 0;

                if (cons == s.length()) {
                    cons = 0;
                    words++;
                }
            }
        }
        cons = 0;
        numVowels = 0;
    }
}
