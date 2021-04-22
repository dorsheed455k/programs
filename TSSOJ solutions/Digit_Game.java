import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Digit_Game {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] n = in.readLine().split("");

        int sum = 0;
        for (String s : n) {
            sum += Integer.parseInt(s);
        }

        System.out.println(sum);
    }
}
