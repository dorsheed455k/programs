/*
   COCI '16 Contest 3 #1 Imena
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Imena {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        String[] ln = in.readLine().split("[!.?]");
        int count = 0;
        for (int i = 0; i < n; i++) {
            String[] words = ln[i].split("\\s+");
            for (String word : words) {
                if (word.length() == 0) continue;
                if (isUppercase(word) && containsNum(word)) {
                    count++;
                }
            }
            System.out.println(count);
            count = 0;
        }
    }

    public static boolean isUppercase(String c) {
        if (c.equals(" ")) return false;
        return c.charAt(0) >= 65 && c.charAt(0) <= 90;
    }

    public static boolean containsNum(String s) {
        return !s.matches(".*\\d.*");
    }
}
