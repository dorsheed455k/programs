import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();

            int[] count = new int[1000000-x];
            for (int j = x; j < 1000000-x; j++) {
                String str = String.valueOf(j);
                String rev = "";
                for (int k = str.length()-1; k >= 0 ; k--) {
                    rev = rev + str.charAt(k);
                }
                if(Integer.parseInt(rev) == Integer.parseInt(str)) {
                    count[j] += Integer.parseInt(rev);
                }
            }

            System.out.println(minPalin(x, count));
        }
    }

    public static int minPalin(int x, int[]count) {
        int min = Integer.MAX_VALUE;
        for (int i : count) {
            if (i > x && i < min) {
                min = i;
            }
        }
        return min;
    }
}
