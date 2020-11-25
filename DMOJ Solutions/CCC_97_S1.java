/*
  CCC '97 S1 - Sentences
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        while (n-- > 0) {
           int s = Integer.parseInt(in.readLine());
           int v = Integer.parseInt(in.readLine());
           int o = Integer.parseInt(in.readLine());

           String[] subs = new String[s];
           String[] verbs = new String[v];
           String[] obj = new String[o];

            for (int i = 0; i < s; i++) subs[i] = in.readLine();
            for (int i = 0; i < v; i++) verbs[i] = in.readLine();
            for (int i = 0; i < o; i++) obj[i] = in.readLine();

            createScentence(subs, verbs, obj);
        }
    }

    public static void createScentence(String[] s, String[] v, String[] o) {

        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < v.length; j++) {
                for (int k = 0; k < o.length; k++) {
                    System.out.println(s[i] + " " + v[j] + " " + o[k] + ".");
                }
            }
        }
    }
}
