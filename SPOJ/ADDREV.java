import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ADDREV {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int a, b;
        for (int i = 0; i < n; i++) {
            String[] line = in.readLine().split(" ");

            a = Integer.parseInt(line[0]);
            b = Integer.parseInt(line[1]);

            int sum = Integer.parseInt(reverse(a)) + Integer.parseInt(reverse(b));

            sum = Integer.parseInt(reverse(sum));
            System.out.println(sum);

        }
    }

    public static String reverse(int a) {
        String s = String.valueOf(a);
        String rev = "";
        for (int i = s.length()-1; i >= 0; i--) {
            rev += s.charAt(i);
        }

        return rev;
    }
}
