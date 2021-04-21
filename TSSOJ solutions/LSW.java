/*
   Lexicographically Sorted Words 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LSW {

    static String[] words = new String[101];
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        for (int i = 0; i < n; i++) {
            words[i] = in.readLine();
        }
        sortLexo(n);
        for (int i = 0; i < n; i++) {
            System.out.println(words[i]);
        }
    }

    public static void sortLexo(int n) {
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (words[i].compareTo(words[j]) > 0) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
    }
}
