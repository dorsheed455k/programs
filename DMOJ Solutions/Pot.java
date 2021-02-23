import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pot {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        long sum = 0;
        int s1, s2;
        for (int i = 0; i < n; i++) {
            String num = in.readLine();
            int len = num.length();
            s1 = Integer.parseInt(num.substring(0, len-1));
            s2 = Integer.parseInt(num.substring(len-1));

            sum += Math.pow(s1, s2);
        }

        System.out.println(sum);
    }
}
