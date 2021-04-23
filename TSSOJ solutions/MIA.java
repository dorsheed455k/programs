/*
   Multiple Integer Addition
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MIA {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(in.readLine());
        }

        System.out.println(sum);
    }
}
