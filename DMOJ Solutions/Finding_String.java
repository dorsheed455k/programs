import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int NO_OF_CHARS = 256;

    static int max(int a, int b) {
        return (a > b)? a : b;
    }

    static void badCharH(char[] str, int size, int[] badchar) {
        int i;
        for (i = 0; i < NO_OF_CHARS; i++)
            badchar[i] = -1;

        for (i = 0; i < size; i++)
            badchar[(int) str[i]] = i;

    }

    static int search(char[] txt, char[] pat) {
        int m = pat.length;
        int n = txt.length;

        int badchar[] = new int[NO_OF_CHARS];

        badCharH(pat, m, badchar);
        int s = 0;
        while(s <= (n - m)) {
            int j = m-1;

            while(j >= 0 && pat[j] == txt[s+j])
                j--;

            if (j < 0) {
                return s;
            } else
                s += max(1, j - badchar[txt[s+j]]);
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] txt = in.readLine().toCharArray();
        char[] pat = in.readLine().toCharArray();
        System.out.println(search(txt, pat));
    }
}
