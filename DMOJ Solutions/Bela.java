import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bela {

    static int[][] point = {{11,4,3,2,10,0,0,0},
                            {11,4,3,20,10,14,0,0}};
    static String card= "AKQJT987";

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n, uk = 0; char s; String kar;

        String[] ln = in.readLine().split(" ");
        n = Integer.parseInt(ln[0]);
        s = ln[1].charAt(0);

        for (int i = 0; i < 4*n; i++) {
            kar = in.readLine();
            uk += point[kar.charAt(1) == s? 1 : 0][fnd(kar.charAt(0))];
        }

        System.out.println(uk);
    }

    public static int fnd(char k) {
        for (int i = 0; i < card.length(); i++) {
            if (card.charAt(i) == k) {
                return i;
            }
        }
        return 0;
    }
}
