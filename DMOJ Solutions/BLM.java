import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n, k;

        String[] line = in.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);

        int[] Ai = new int[n], Bi = new int[n];

        int i = 0;
        BigInteger total =new BigInteger("0");
        while(n-- > 0) {
            String[] txt = in.readLine().split(" ");
            Ai[i] = Integer.parseInt(txt[0]);
            Bi[i] = Integer.parseInt(txt[1]);
            total = total.add(totalCandy(Ai[i], Bi[i]));
        }

        BigInteger split = total.mod(BigInteger.valueOf(k));


        System.out.println(split);
   
    }

    public static BigInteger totalCandy(int a, int b) {
        return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b));
    }
 }
