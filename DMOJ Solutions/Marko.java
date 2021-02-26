import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Marko {

    static int[] dig = {0, 3, 3, 3, 3, 3, 4, 3, 4};;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = in.readLine();
            for (int j = 0; j < str.length(); j++) {
                char x = str.charAt(j);
                x = set_digit(x);
                sb.append(x);
            }
            sb.append("\n");
        }

        String s = in.readLine();
        String t = "";
        int ans = 0;
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) != '\n') {
                t += sb.charAt(i);
            } else {
                if (t.equals(s)) {
                    ans++;
                }
                t = "";
            }
        }
        System.out.println(ans);
    }

    public static char set_digit(char x) {
        int digpos = 0;
        int pos = x - 'a' + 1;
        while (pos > 0) {
            pos -= dig[digpos++];
        }
        return (char) ('0' + digpos);
    }
}
