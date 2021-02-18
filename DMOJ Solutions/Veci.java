import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Veci {

    static int[] freq = new int[10];
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(in.readLine());
        int y = x+1;

        while (y - x < 1000000 && !same_digit(x, y)) {
            y++;
        }
        
        if (y - x >= 1000000) {
            System.out.println("0");
        } else {
            System.out.println(y);
        }
    }

    public static boolean same_digit(int x, int y) {
        for (int i = 0; i < 10; i++) {
            freq[i] = 0;
        }
        while (x > 0) {
            freq[x%10]++; x /= 10;
        }
        while (y > 0) {
            freq[y%10]--; y /= 10;
        }

        boolean sd = true;
        for (int i = 0; i < 10; i++) {
            if (freq[i] != 0) {
                sd = false;
                break;
            }
        }
        return sd;
    }
}
