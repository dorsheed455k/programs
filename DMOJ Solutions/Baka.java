import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baka {

    public static void main(String[] args) throws IOException {

        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));

        String s = in.readLine();
        int sum = 0;
        String num = "nnADGJMPTW";
        for (int i = 0; i < s.length(); i++) {
            int t = 0;
            for (int j = 2; j < 10; j++)
                if (s.charAt(i) >= num.charAt(j))
                    t = j;
            sum += t + 1;
        }
        System.out.println(sum);
    }
}
