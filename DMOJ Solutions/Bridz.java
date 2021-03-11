import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bridz {
    static int n;
    static int points;
    static String s;
    static String rate = "JQKA";

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            s = in.readLine();
            for (int j = 0; j < 13; j++) {
                points += find(s.charAt(j));
            }
        }
        System.out.println(points);
    }

    static int find(char c) {
        for (int i = 0; i < 4; i++) {
            if (rate.charAt(i) == c) {
                return  i+1;
            }
        }
        return 0;
    }
}
