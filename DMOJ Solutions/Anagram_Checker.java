import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s1 = in.readLine();
        String s2 = in.readLine();

        char[] c1 = s1.replaceAll(" ", "").toCharArray();
        char[] c2 = s2.replaceAll(" ", "").toCharArray();

        System.out.println(isAnagram(c1, c2) ? "Is an anagram." : "Is not an anagram.");

    }

    public static boolean isAnagram(char[] c1, char[] c2) {
        int n = c1.length;
        int m = c2.length;

        if(n != m) return false;

        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < m; i++) {
            if(c1[i] != c2[i])  return false;
        }
        return true;
    }
}
