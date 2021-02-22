import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Karte {

    static int maxA = 5, maxN = 20;
    static boolean[][] bio = new boolean[maxA][maxN];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s = in.readLine();
        for (int i = 0; i < s.length(); i += 3) {
            int b = getColor(s.charAt(i));
            int x = (s.charAt(i + 1) - '0') * 10 + s.charAt(i + 2) - '0';
            if (bio[b][x]) {
                System.out.println("GRESKA");
                return;
            }
            bio[b][x] = true;
        }

        for (int i = 0; i < 4; i++) {
            int cnt = 0;
            for (int j = 1; j <= 13; j++) {
                if (bio[i][j]) {
                    cnt++;
                }
            }
            System.out.print(13 - cnt + " ");
        }
    }

    public static int getColor(char c) {
        if (c == 'P') return 0;
        if (c == 'K') return 1;
        if (c == 'H') return 2;
        if (c == 'T') return 3;

        return 0;
    }
}
