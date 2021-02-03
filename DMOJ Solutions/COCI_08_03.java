// COCI '08 Contest 3 #1 Pet

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = 5;
        int sum = 0;
        int pos = 0;
        while (n-- > 0) {
            String[] line = in.readLine().split(" ");

            int nS = 0;
            for (int i = 0; i < 4; i++) {
                nS += Integer.parseInt(line[i]);
            }

            if(nS > sum) {
                pos = 5 - n;
                sum = nS;
            }
        }
        System.out.println(pos + " " + sum);
    }
}
