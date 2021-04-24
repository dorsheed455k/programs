/*
   A Product Problem
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class APP {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] ln = in.readLine().split(" ");

        BigInteger a = new BigInteger(ln[0]);
        BigInteger b = new BigInteger(ln[1]);


        BigInteger mod = new BigInteger(String.valueOf(1000000007));

        BigInteger ans = a.multiply(b);
        ans = ans.mod(mod);
        System.out.println(ans);
    }
}
