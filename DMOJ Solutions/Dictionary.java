import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dictionary {
    static int n;
    static String[] words;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = in.readLine();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (words[i].compareTo(words[j])>0) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (i > 0 && words[i-1].charAt(0) == words[i].charAt(0)) {
                System.out.print(", " + words[i]);
            } else {
                if (i > 0) {
                    System.out.println();
                }
                System.out.print(words[i]);
            }
        }
    }

    public static void sort() {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (words[i].compareTo(words[j])>0) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
    }
}
