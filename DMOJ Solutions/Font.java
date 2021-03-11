import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Font {
    static int n;
    static int[] w = new int[30];
    static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());

        for (int i = 0; i < n; i++) {
            char[] tmp = new char[110];
            tmp = in.readLine().toCharArray();
            int l = tmp.length;
            for (int j = 0; j < l; j++) {
                w[i] = w[i] | 1 << tmp[j] - 'a';
            }
        }
        rek(0, 0);
        System.out.println(ans);
    }

    public static void rek(int pos, int m) {
        if (pos == n) {
            if (m == (1 << 26) - 1) ans++;
            return;
        }
        rek(pos + 1, m | w[pos]);
        rek(pos+1, m);
    }
}
