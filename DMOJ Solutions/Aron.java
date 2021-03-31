/*
  COCI '17 Contest 3 #1 Aron
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class Aron {

    static Vector<Character> line = new Vector<>();

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        for (int i = 0; i < n; i++) {
            line.add(in.readLine().charAt(0));
        }

        int index = 0;
        boolean equal = false;
        for (int i = 1; i < line.size(); ) {
            if (line.get(i-1) == line.get(i)) {
                line.removeElementAt(i);
                equal = true;
                index = i;
            }
            if (equal) {
                i = index;
            } else {
                i++;
            }
            equal = false;
        }

        int len = line.size();


        System.out.println(len+1);
    }
}
