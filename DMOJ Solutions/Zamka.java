import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zamka {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int l, d, x;

        l = Integer.parseInt(in.readLine());
        d = Integer.parseInt(in.readLine());
        x = Integer.parseInt(in.readLine());

        int n = 0, m = 0;

        for (int i = l; i <= d; i++) {
            if(digitSum(i) == x) {
                n = i;
                break;
            }
        }

        for (int i = d; i >= l; i--) {
            if(digitSum(i) == x) {
                m = i;
                break;
            }
        }
        System.out.print(n + "\n" + m);
    }

    public static int digitSum(int num) {

        String s = String.valueOf(num);

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return sum;
    }
}
